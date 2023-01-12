package org.example.ReadingAndWriting;

import org.example.Interfaces.ReadingAndWritingInterface;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;

public class FileReaderWriterInfo implements ReadingAndWritingInterface {
    protected String name;
    public FileReaderWriterInfo(String name) {
        this.name = name;
    }

    @Override
    public void Write(ArrayList<ArrayList<String>> lines, String filePath) throws ParserConfigurationException, TransformerException {

    }

    @Override
    public void WriteResult(ArrayList<ArrayList<String>> lines, String filePath) throws ParserConfigurationException, TransformerException {

    }

    @Override
    public ArrayList<ArrayList<String>> Read(String filePath) throws Exception {
        return null;
    }

    @Override
    public String getFileName() {
        return this.name;
    }
}
