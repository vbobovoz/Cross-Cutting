package org.example.ReadingAndWriting;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TXT {
    public static ArrayList<ArrayList<String>> ReadTXT(String filePath) {
        try {
            ArrayList<ArrayList<String>> lines = new ArrayList<>();
            Scanner reader = new Scanner(new FileReader(filePath));
            while(reader.hasNextLine()) {
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(reader.nextLine());
                lines.add(tmp);
            }
            reader.close();
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
