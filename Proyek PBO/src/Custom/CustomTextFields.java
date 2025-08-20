package Custom;

import java.awt.Insets;


public class CustomTextFields extends javax.swing.JTextField {
    public CustomTextFields() {
        Insets ins = getInsets();
        ins.left += 3;
        setMargin(ins);
    }
}

