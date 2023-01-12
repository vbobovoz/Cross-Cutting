package org.example;
import org.example.FileBuilder.FileBuilder;
import org.example.Interfaces.ReadingAndWritingInterface;

public class Main {
    private static ReadingAndWritingInterface rw;
    public static void main(String[] args) throws Exception {
        String fileType, filePath;
        fileType = "txt";
        filePath = "inputFiles/input.txt";

        FileBuilder fileBuilder = new FileBuilder(fileType, filePath);
        rw = fileBuilder.getFileReader();
        System.out.println(rw.Read(filePath));
    }
}