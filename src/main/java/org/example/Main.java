package org.example;

import org.example.ReadingAndWriting.JSON;
import org.example.ReadingAndWriting.TXT;
import org.example.ReadingAndWriting.XML;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
//        ArrayList<ArrayList<String>> txtLines = TXT.ReadTXT("inputFiles/input.txt");
//        System.out.println("txtLines = " + txtLines);
//
//        ArrayList<ArrayList<String>> jsonLines = JSON.ReadJSON("inputFiles/input.json");
//        System.out.println("jsonLines = " + jsonLines);
//
        ArrayList<ArrayList<String>> xmlLines = XML.ReadXML("inputFiles/input.xml");
        System.out.println("xmlLines = " + xmlLines);
    }
}