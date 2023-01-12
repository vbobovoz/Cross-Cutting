package org.example;

import org.example.Archivation.Archiving;
import org.example.Compressing.Compressing;
import org.example.Encryption.Encryption;
import org.example.ReadingAndWriting.JSON;
import org.example.ReadingAndWriting.TXT;
import org.example.ReadingAndWriting.XML;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args) throws Exception {
        ArrayList<ArrayList<String>> txtData = new ArrayList<>(TXT.ReadTXT("inputFiles/input.txt"));
        TXT.WriteResultTXT(txtData, "outputFiles/output.txt");

        ArrayList<ArrayList<String>> jsonData = new ArrayList<>(JSON.ReadJSON("inputFiles/input.json"));
        JSON.WriteResultJSON(jsonData, "outputFiles/output.json");

        ArrayList<ArrayList<String>> xmlData = new ArrayList<>(XML.ReadXML("inputFiles/input.xml"));
        XML.WriteResultXML(xmlData, "outputFiles/output.xml");

        List<String> filePaths = Arrays.asList("inputFiles/input.json", "inputFiles/input.xml", "inputFiles/input.txt");
        Archiving.createArchive(filePaths, "outputFiles/Files.zip");

        Archiving.extractArchive("outputFiles/Files.zip", "extractArchiveFiles");

        Compressing.compressFile("inputFiles/input.json", 9);
        Compressing.decompressFile("inputFiles/input.json.zip");

        Key key = Encryption.encrypt("inputFiles/input.json", "encryptFiles/encrypted.json");
        Encryption.decrypt("encryptFiles/encrypted.json", "encryptFiles/decrypted.json", key);
    }
}