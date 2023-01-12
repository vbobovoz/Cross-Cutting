package org.example.FileBuilder;

import org.example.Interfaces.FileBuilderInterface;
import org.example.Interfaces.ReadingAndWritingInterface;
import org.example.ReadingAndWriting.JSON;
import org.example.ReadingAndWriting.TXT;
import org.example.ReadingAndWriting.XML;

public class FileBuilder implements FileBuilderInterface {
    protected ReadingAndWritingInterface fileReader;
    public FileBuilder(String fileType, String filePath) {
        if(fileType == "zip") {

        }
        if(fileType == "txt") {
            fileReader = new TXT(filePath);
        } else if(fileType == "json") {
            fileReader = new JSON(filePath);
        } else if(fileType == "xml") {
            fileReader = new XML(filePath);
        }
    }

    @Override
    public void setEncrypt() {

    }

    @Override
    public void setCompressed() {

    }

    @Override
    public void setZip() {

    }

    @Override
    public ReadingAndWritingInterface getFileReader() {
        return fileReader;
    }
}
