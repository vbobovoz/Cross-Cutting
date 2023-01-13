package org.example.Archives.JAR;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressingJAR {
    public static void compressFileJAR(String filePath, int compressionLevel) throws IllegalArgumentException {
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file.getName() + ".jar");
            ZipOutputStream zos = new ZipOutputStream(fos);
            zos.setLevel(compressionLevel);

            ZipEntry zipEntry = new ZipEntry(file.getName());
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            zos.closeEntry();
            zos.close();
            fis.close();
            fos.close();

            System.out.println("File compressed successfully!");
        } catch (Exception e) {
            System.err.println("Error compressing file: " + e.getMessage());
        }
    }

    public static void decompressFileZIP(String zipFilePath) throws FileNotFoundException, IOException {

    }
}
