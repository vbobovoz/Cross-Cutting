package org.example.ReadingAndWriting;

import org.example.Calculation.Calculation;

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

    public static void WriteTXT(ArrayList<ArrayList<String>> lines, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            for(int i = 0; i < lines.size(); ++i) {
                writer.write(lines.get(i).get(0));
                if(i + 1 != lines.size()) {
                    writer.write("\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteResultTXT(ArrayList<ArrayList<String>> lines, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            ArrayList<ArrayList<String>> calc = Calculation.Calc(lines);
            for(int i = 0; i < lines.size(); ++i) {
                writer.write(calc.get(i).get(0));
                if(i + 1 != calc.size()) {
                    writer.write("\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
