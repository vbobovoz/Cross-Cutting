package org.example.Archives.JAR;

import java.io.*;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void decompressFileJAR(String jarFilePath) throws FileNotFoundException, IOException {
        byte[] buffer = new byte[1024];
        try {
            FileInputStream fis = new FileInputStream(jarFilePath);
            JarInputStream jis = new JarInputStream(fis);
            JarEntry jarEntry = jis.getNextJarEntry();

            while(jarEntry != null) {
                String fileName = jarEntry.getName();
                File newFile = new File(fileName);
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = jis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                jarEntry = jis.getNextJarEntry();
            }
            jis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
