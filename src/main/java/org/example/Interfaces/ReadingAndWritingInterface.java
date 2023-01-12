package org.example.Interfaces;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;

public interface ReadingAndWritingInterface {
    void Write(ArrayList<ArrayList<String>> lines, String filePath) throws ParserConfigurationException, TransformerException;
    void WriteResult(ArrayList<ArrayList<String>> lines, String filePath) throws ParserConfigurationException, TransformerException;
    ArrayList<ArrayList<String>> Read(String filePath) throws Exception;
    String getFileName();
}
