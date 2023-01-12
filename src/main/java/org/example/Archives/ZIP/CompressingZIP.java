package org.example.Archives.ZIP;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class CompressingZIP {
    public static void compressFileZIP(String filePath, int compressionLevel) throws IllegalArgumentException {
        if(compressionLevel < 0 || compressionLevel > 9)
            throw new IllegalArgumentException("Invalid compression level, it should be between 0 and 9");
        try {
            File file = new File(filePath);
            File zipFile = new File(filePath + ".zip");

            byte[] buffer = new byte[1024];
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            zos.setLevel(compressionLevel);

            FileInputStream in = new FileInputStream(file);
            zos.putNextEntry(new ZipEntry(file.getName()));

            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            in.close();
            zos.closeEntry();
            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decompressFileZIP(String zipFilePath) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(zipFilePath);
        ZipInputStream zis = new ZipInputStream(fis);

        ZipEntry entry = zis.getNextEntry();
        while (entry != null) {
            String entryName = entry.getName();
            File newFile = new File(entryName);
            FileOutputStream fos = new FileOutputStream(newFile);

            int len;
            byte[] buffer = new byte[1024];
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            zis.closeEntry();
            entry = zis.getNextEntry();
        }
        zis.close();
        fis.close();
    }
}
