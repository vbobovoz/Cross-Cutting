package org.example;

import org.example.ReadingAndWriting.TXT;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = TXT.ReadTXT("inputFiles/input.txt");
        TXT.WriteTXT(lines, "inputFiles/output.txt");
    }
}