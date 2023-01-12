package org.example.Archivation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Archiving {
    public static void createArchive(List<String> inputFilePaths, String outputFilePath) {
        try {
            FileOutputStream fos = new FileOutputStream(outputFilePath);
            ZipOutputStream zos = new ZipOutputStream(fos);
            for(String inputFilePath : inputFilePaths) {
                File file = new File(inputFilePath);
                FileInputStream fis = new FileInputStream(file);
                ZipEntry entry = new ZipEntry(file.getName());
                zos.putNextEntry(entry);
                byte[] buffer = new byte[1024];
                int length;
                while((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void extractArchive(String archivePath, String directory) {
        try {
            FileInputStream fis = new FileInputStream(archivePath);
            ZipInputStream zis = new ZipInputStream(fis);

            ZipEntry entry = zis.getNextEntry();
            while(entry != null) {
                String fileName = entry.getName();
                File newFile = new File(directory + File.separator + fileName);
                FileOutputStream fos = new FileOutputStream(newFile);

                byte[] buffer = new byte[1024];
                int length;

                while((length = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
                fos.close();
                entry = zis.getNextEntry();
            }
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
