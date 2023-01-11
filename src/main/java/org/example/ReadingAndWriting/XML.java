package org.example.ReadingAndWriting;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class XML {
    public static ArrayList<ArrayList<String>> ReadXML(String filePath) throws Exception {
        try {
            ArrayList<ArrayList<String>> lines = new ArrayList<>();
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(filePath));
            int i = 0, counter = 0;
            lines.add(0, new ArrayList<>());
            while(reader.hasNext()) {
                if(reader.next() == XMLStreamConstants.CHARACTERS) {
                    String tmp = reader.getText().replaceAll("  ", "").replaceAll("\n", "");
                    if(tmp != "") {
                        lines.get(i).add(tmp);
                        counter = 0;
                    } else {
                        counter++;
                    }
                }
                if(counter == 3) {
                    lines.add(++i, new ArrayList<>());
                    counter = 0;
                }
            }
            return lines;
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
