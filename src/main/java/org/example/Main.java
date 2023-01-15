package org.example;

import org.example.ConsoleUI.ConsoleUI;

public class Main{
    public static void main(String[] args) throws Exception {
        ConsoleUI.consoleUI();

        //Encryption.encrypt("mysecretkeyforcc", "work/input.txt", "work/einput.txt");

//        ArrayList<ArrayList<String>> txtData = new ArrayList<>(TXT.ReadTXT("inputFiles/input.txt"));
//        TXT.WriteResultTXT(txtData, "outputFiles/output.txt");
//
//        ArrayList<ArrayList<String>> jsonData = new ArrayList<>(JSON.ReadJSON("inputFiles/input.json"));
//        JSON.WriteResultJSON(jsonData, "outputFiles/output.json");
//
//        ArrayList<ArrayList<String>> xmlData = new ArrayList<>(XML.ReadXML("inputFiles/input.xml"));
//        XML.WriteResultXML(xmlData, "outputFiles/output.xml");
//
//        List<String> filePaths = Arrays.asList("inputFiles/input.json", "inputFiles/input.xml", "inputFiles/input.txt");
//        Archiving.createArchive(filePaths, "outputFiles/Files.zip");
//
//        Archiving.extractArchive("outputFiles/Files.zip", "extractArchiveFiles");
//
//        Compressing.compressFile("inputFiles/input.json", 9);
//        Compressing.decompressFile("inputFiles/input.json.zip");
//
        //System.out.println(Archiving.isArchived("inputFiles/input.txt"));
        //System.out.println(Archiving.isArchived("outputFiles/Files.zip"));

//        List<String> filePaths = Arrays.asList("inputFiles/input.txt", "inputFiles/input.json", "inputFiles/input.xml");
//        ArchivingJAR.createArchiveJAR(filePaths, "outputFiles/Files.jar");
//        ArchivingJAR.extractArchiveJAR("outputFiles/Files.jar", "extractArchiveFiles");
//        System.out.println(ArchivingJAR.isArchivedJAR("inputFiles/input.txt"));
//        System.out.println(ArchivingJAR.isArchivedJAR("outputFiles/Files.jar"));

        //Encryption.encrypt("mysecretkeyforcc", "encryptFiles/DecryptFiles.zip", "encryptFiles/EncryptFiles.zip");

//        Encryption.encrypt("mysecretkeyforcc", "outputFiles/Files.zip", "encryptFiles/EncryptFiles.zip");
//        Encryption.decrypt("mysecretkeyforcc", "encryptFiles/encrypted.txt", "encryptFiles/decrypted.txt");
//        Encryption.decrypt("mysecretkeyforcc", "encryptFiles/EncryptFiles.zip", "encryptFiles/DecryptFiles.zip");
    }
}