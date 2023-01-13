package org.example.Encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Encryption {
    public static void encrypt(String key, String inputFileName, String outputFileName) throws Exception {
        FileInputStream inputStream = new FileInputStream(inputFileName);
        FileOutputStream outputStream = new FileOutputStream(outputFileName);

        byte[] keyBytes = key.getBytes();
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        int available = inputStream.available();
        byte[] inputBytes = new byte[available];
        inputStream.read(inputBytes);

        byte[] outputBytes = cipher.doFinal(inputBytes);
        outputStream.write(outputBytes);

        inputStream.close();
        outputStream.close();
    }

    public static void decrypt(String key, String inputFileName, String outputFileName) throws Exception {
        FileInputStream inputStream = new FileInputStream(inputFileName);
        FileOutputStream outputStream = new FileOutputStream(outputFileName);

        byte[] keyBytes = key.getBytes();
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] inputBytes = new byte[(int) inputStream.available()];
        inputStream.read(inputBytes);

        byte[] outputBytes = cipher.doFinal(inputBytes);
        outputStream.write(outputBytes);

        inputStream.close();
        outputStream.close();
    }
}