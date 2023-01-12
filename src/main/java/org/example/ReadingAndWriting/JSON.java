package org.example.ReadingAndWriting;

import org.example.Calculation.Calculation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSON {
    public static ArrayList<ArrayList<String>> ReadJSON(String filePath) {
        try {
            ArrayList<ArrayList<String>> lines = new ArrayList<>();
            lines.add(0, new ArrayList<>());
            JSONParser jsonParser = new JSONParser();
            JSONArray list = (JSONArray) jsonParser.parse(new FileReader(filePath));
            for (int i = 0; i < list.size(); ++i) {
                JSONObject object = (JSONObject) list.get(i);
                for (int j = 0; j < object.size(); ++j) {
                    lines.get(i).add(object.get("expression" + Integer.toString(j)).toString());
                }
                if(i + 1 != list.size()) {
                    lines.add(i + 1, new ArrayList<>());
                }
            }
            return lines;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void WriteJSON(ArrayList<ArrayList<String>> lines, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write("[" + "\n");
            for(int i = 0; i < lines.size(); ++i) {
                JSONObject object = new JSONObject();
                for(int j = 0; j < lines.get(i).size(); ++j) {
                    int k = j;
                    object.put("expression" + k, lines.get(i).get(j));
                }
                writer.write("\t");
                if(i + 1 == lines.size()) {
                    writer.write(object.toJSONString().replaceAll("\\\\", "") + "\n");
                } else {
                    writer.write(object.toJSONString() + "," + "\n");
                }
            }
            writer.write("]");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteResultJSON(ArrayList<ArrayList<String>> lines, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            ArrayList<ArrayList<String>> calc = Calculation.Calc(lines);
            writer.write("[" + "\n");
            for(int i = 0; i < calc.size(); ++i) {
                JSONObject object = new JSONObject();
                for(int j = 0; j < calc.get(i).size(); ++j) {
                    int k = j;
                    object.put("expression" + k, calc.get(i).get(j));
                }
                writer.write("\t");
                if(i + 1 == calc.size()) {
                    writer.write(object.toJSONString().replaceAll("\\\\", "") + "\n");
                } else {
                    writer.write(object.toJSONString() + "," + "\n");
                }
            }
            writer.write("]");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}