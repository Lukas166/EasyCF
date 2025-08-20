/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import java.util.Base64;

/**
 *
 * @author ASUS
 */
public class Encrypt {
    private final String key = "EasyCF";
    
    private byte[] xorWithKey(byte[] data) {
        byte[] keyBytes = key.getBytes();
        byte[] result = new byte[data.length];

        for (int i = 0; i < data.length; i++) {
            result[i] = (byte) (data[i]^keyBytes[i % keyBytes.length]);
        }

        return result;
    }

    public String encode(String data) {
        byte[] dataBytes = data.getBytes();
        byte[] encodedBytes = xorWithKey(dataBytes);
        return Base64.getEncoder().encodeToString(encodedBytes);
    }

    public String decode(String encodedData) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedData);
        byte[] originalBytes = xorWithKey(decodedBytes);
        return new String(originalBytes);
    }
}
