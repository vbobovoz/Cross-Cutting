package org.example.ReadingAndWriting;

import org.example.Calculation.Calculation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
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

    private static Node getLanguage(Document doc, ArrayList<String> lines) {
        Element line = doc.createElement("expressions");
        int k = 0;
        for(int i = 0; i < lines.size(); ++i) {
            line.appendChild(getLanguageElements(doc, line, "expression" + (k++), lines.get(i)));
        }
        return line;
    }

    private static Node getLanguageElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    public static void WriteResultXML(ArrayList<ArrayList<String>> lines, String filePath) throws ParserConfigurationException, TransformerException {
        ArrayList<ArrayList<String>> calc = Calculation.Calc(lines);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element element = document.createElement("Expressions");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transform = transformerFactory.newTransformer();
        transform.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(filePath));
        document.appendChild(element);
        for(int i = 0; i < calc.size(); ++i) {
            element.appendChild(XML.getLanguage(document, calc.get(i)));
        }
        transform.transform(source, result);
    }

    public static void WriteXML(ArrayList<ArrayList<String>> lines, String filePath) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element element = document.createElement("Expressions");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transform = transformerFactory.newTransformer();
        transform.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(filePath));
        document.appendChild(element);
        for(int i = 0; i < lines.size(); ++i) {
            element.appendChild(XML.getLanguage(document, lines.get(i)));
        }
        transform.transform(source, result);
    }
}
