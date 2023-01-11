package org.example.ReadingAndWriting;

import java.io.*;
import java.util.ArrayList;

public class TXT {
    public static ArrayList<String> ReadTXT(String filePath) {
        ArrayList<String> input = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = br.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public static void WriteTXT(ArrayList<String> lines, String filePath) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for(String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
