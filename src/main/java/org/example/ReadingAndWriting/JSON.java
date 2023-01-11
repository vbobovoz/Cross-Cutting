package org.example.ReadingAndWriting;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
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
                    lines.get(i).add(object.get("expression" + Integer.toString(j + 1)).toString());
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
}