package org.example;

import org.example.ReadingAndWriting.JSON;
import org.example.ReadingAndWriting.TXT;
import org.example.ReadingAndWriting.XML;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws Exception {
        ArrayList<ArrayList<String>> txtData = new ArrayList<>(TXT.ReadTXT("inputFiles/input.txt"));
        TXT.WriteResultTXT(txtData, "outputFiles/output.txt");

        ArrayList<ArrayList<String>> jsonData = new ArrayList<>(JSON.ReadJSON("inputFiles/input.json"));
        JSON.WriteResultJSON(jsonData, "outputFiles/output.json");

        ArrayList<ArrayList<String>> xmlData = new ArrayList<>(XML.ReadXML("inputFiles/input.xml"));
        XML.WriteResultXML(xmlData, "outputFiles/output.xml");
    }
}