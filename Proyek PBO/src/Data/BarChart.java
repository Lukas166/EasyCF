package Data;
/**
 *
 * @author userpc
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.SwingUtilities;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.YearMonth;

public class BarChart extends JPanel {
    private long[] data = {200, 150, 100, 250};
    private String[] labels = {"1-8", "9-16", "17-23", "24-31"};
    private int hoveredBar = -1;
    private double[] scaleFactors = {1.0, 1.0, 1.0, 1.0};
    private static final double MAX_SCALE = 1.05;
    private static final double SCALE_STEP = 0.02;
    private double[] animationProgress; // Array to track animation progress for each bar
    private long startAnimationTime; // Time when animation started
    private double progress;

    public BarChart(Users user, int month, int year) {
        setLayout(null);
        this.data = user.getDataPerTanggal(month, year);
        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();
        labels[0] = "1-8";
        labels[1] = "9-16";
        labels[2] = "17-23";
        labels[3] = "24-"+ daysInMonth;
        
        initializeAnimation();
        // Timer untuk animasi scaling
        Timer animationTimer = new Timer(20, e -> {
            for (int i = 0; i < scaleFactors.length; i++) {
                if (i == hoveredBar && scaleFactors[i] < MAX_SCALE) {
                    scaleFactors[i] += SCALE_STEP;
                } else if (i != hoveredBar && scaleFactors[i] > 1.0) {
                    scaleFactors[i] -= SCALE_STEP;
                }
                // Pastikan tidak melebihi atau kurang dari batas
                scaleFactors[i] = Math.min(MAX_SCALE, Math.max(1.0, scaleFactors[i]));
            }
            repaint();
        });
        animationTimer.start();

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int width = getWidth();
                int barWidth = width / (data.length * 3); // Sesuaikan dengan perhitungan di paintComponent

                Point convertedPoint = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), BarChart.this);
                int mouseX = convertedPoint.x;
                int mouseY = convertedPoint.y;

                hoveredBar = -1;
                for (int i = 0; i < data.length; i++) {
                    int barX = i * (barWidth * 2) + barWidth + 70; // Tambahkan offset 70
                    long barHeight = (data[i] * getHeight() / getMaxValue());
                    long barY = getHeight() - barHeight;

                    // Cek apakah mouse berada di area batang
                    if (mouseX >= barX && mouseX <= barX + barWidth &&
                        mouseY <= getHeight() && mouseY >= barY) {
                        hoveredBar = i;
                        break;
                    }
                }
                repaint(); // Tambahkan repaint agar efek hover segera terlihat
            }
        });
    }

    private BarChart() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Call this method when initializing the chart
    private void initializeAnimation() {
        animationProgress = new double[data.length];
        progress = 0.0;
        startAnimationTime = System.currentTimeMillis();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int barWidth = width / (data.length * 3);

        // Modify getMaxValue to handle zero values
        int maxValue = getMaxValue();
        // Ensure maxValue is at least 1 to avoid division by zero
        maxValue = Math.max(maxValue, 1);

        g2d.setPaint(new Color(18, 43, 17));
        g2d.fillRect(0, 0, width, height);

        // Warna gradasi untuk setiap batang
        Color[] barGradients = {
            new Color(217, 217, 217), new Color(10, 41, 20)
        };

        // Gambar garis-garis horizontal
        g.setColor(Color.LIGHT_GRAY);

        // Modify range line calculation to work with zero values
        int rangeLine = getRangeLine();
        for (int i = rangeLine/5; i <= maxValue; i += rangeLine/5) {
            int y = height - (i * height / maxValue);
            g.drawLine(0, y, width, y);

            // Tambah label nilai di samping garis
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(i), 10, y);
            g.setColor(Color.LIGHT_GRAY);
        }

        // Calculate animation duration (milliseconds)
        long currentTime = System.currentTimeMillis();
        long animationDuration = 1000; // 1 second total animation time

        // Gambar batang
        for (int i = 0; i < data.length; i++) {
            // Calculate animation progress
            long timeSinceStart = currentTime - startAnimationTime;
            double progress = Math.min(1.0, (double)timeSinceStart / animationDuration);

            // Stagger the start of each bar's animation
            double staggerDelay = i * 100; // 100ms between each bar's start
            progress = Math.max(0, progress - (staggerDelay / animationDuration));
            progress = Math.min(1.0, progress);

            // Ease out quadratic animation (slows down at the end)
            double animationEase = 1 - Math.pow(1 - progress, 4);

            long barHeight = (data[i] * height) / maxValue;
            int barX = i * (barWidth * 2) + barWidth;

            // Hitung ukuran yang di-scale
            int scaledBarHeight = (int)(barHeight * scaleFactors[i] * animationEase);
            int scaledBarY = height - scaledBarHeight;
            int scaledBarWidth = (int)(barWidth * scaleFactors[i]);
            int scaledBarX = barX - (scaledBarWidth - barWidth) + 70;

            // Gradien warna batang
            GradientPaint gradientPaint;
            if (hoveredBar == i) {
                // Gradien dengan warna yang lebih cerah saat hover
                gradientPaint = new GradientPaint(
                    scaledBarX, scaledBarY, 
                    barGradients[0].brighter(), 
                    scaledBarX, scaledBarY + scaledBarHeight, 
                    barGradients[1].brighter()
                );
            } else {
                gradientPaint = new GradientPaint(
                    scaledBarX, scaledBarY, 
                    barGradients[0], 
                    scaledBarX, scaledBarY + scaledBarHeight, 
                    barGradients[1]
                );
            }

            // Set gradien
            g2d.setPaint(gradientPaint);

            // Hanya gambar batang jika tinggi > 0
            if (scaledBarHeight > 0) {
                g2d.fillRoundRect(
                    scaledBarX, 
                    scaledBarY, 
                    scaledBarWidth, 
                    scaledBarHeight,
                    3,
                    3
                );
            }

            // Label bulan di bawah
            g.setColor(Color.WHITE);
            g.drawString(labels[i], 
                barX + 70, 
                height - 10
            );

            // Label nilai hanya muncul saat hover
            if (hoveredBar == i) {
                g.drawString(String.valueOf(data[i]), 
                    scaledBarX, 
                    scaledBarY - 10
                );
            }
        }

        // If animation is not complete, trigger repaint
        if (progress < 1.0) {
            repaint();
        }
    }

private int getMaxValue() {
    // Handle empty array case
    if (data == null || data.length == 0) {
        return 1;
    }
    
    long max = data[0];
    for (long value : data) {
        if (value > max) max = value;
    }
    return (int) (max * 1.1);
}

private int getRangeLine() {
    int maxValue = getMaxValue();
    
    // Jika maxValue adalah 0, kembalikan 10
    if (maxValue == 0) {
        return 10;
    }
    
    int line = 5000;
    int i = 0;
    while (line < maxValue) {
        line += 5000;
    }
    return line;
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bar Chart Hover Animate");
            frame.add(new BarChart());
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}