package org.example.ConsoleUI;

import org.example.Archives.JAR.ArchivingJAR;
import org.example.Archives.ZIP.ArchivingZIP;
import org.example.Calculation.Calculation;
import org.example.Encryption.Encryption;
import org.example.ReadingAndWriting.JSON;
import org.example.ReadingAndWriting.TXT;
import org.example.ReadingAndWriting.XML;

import java.util.*;

public class ConsoleUI {
    public static void consoleUI() throws Exception {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<String>> calc = new ArrayList<>();

        System.out.print("Put file into 'work' directory and enter fileName: ");

        String fileName = in.nextLine(), fileType = "", filePath;
        if(fileName.endsWith(".txt") || fileName.endsWith(".xml")) {
            fileType = fileName.substring(fileName.length() - 3);
            fileName = fileName.substring(0, fileName.length() - 4);
        } else if (fileName.endsWith(".json")) {
            fileType = fileName.substring(fileName.length() - 4);
            fileName = fileName.substring(0, fileName.length() - 5);
        }

        System.out.print("If the file is encrypted, enter the key (16, 24 or 32 characters). If not, enter 'skip': ");
        String choose = in.nextLine(), key = "null";

        if(!choose.equals("skip") && (choose.length() == 16 || choose.length() == 24 || choose.length() == 32)) {
            key = choose;
        }

        switch (fileType) {
            case "zip":
                filePath = "work/" + fileName + "." + fileType;
                if (!key.equals("null")) {
                    String newFilePath = "temp/D" + fileName + "." + fileType;
                    Encryption.decrypt(key, filePath, newFilePath);
                    ArchivingZIP.extractArchiveZIP(newFilePath, "work");
                    System.out.print("Enter fileName of extractedFile: ");
                    String extractedFileName = in.nextLine(), extractedFileType = extractedFileName.substring(extractedFileName.length() - 3);
                    extractedFileName = extractedFileName.substring(0, extractedFileName.length() - 4);
                    switch (extractedFileType) {
                        case "txt" -> {
                            calc = TXT.ReadTXT("work/" + extractedFileName + "." + extractedFileType);
                            assert calc != null;
                            calc = Calculation.Calc(calc);
                        }
                        case "json" -> {
                            calc = JSON.ReadJSON("work/" + extractedFileName + "." + extractedFileType);
                            assert calc != null;
                            calc = Calculation.Calc(calc);
                        }
                        case "xml" -> {
                            calc = XML.ReadXML("work/" + extractedFileName + "." + extractedFileType);
                            assert calc != null;
                            calc = Calculation.Calc(calc);
                        }
                    }
                } else {
                    ArchivingZIP.extractArchiveZIP(filePath, "work");
                    System.out.print("Enter fileName of extractedFile: ");
                    String extractedFileName = in.nextLine(), extractedFileType = extractedFileName.substring(extractedFileName.length() - 3);
                    extractedFileName = extractedFileName.substring(0, extractedFileName.length() - 4);
                    switch (extractedFileType) {
                        case "txt" -> {
                            calc = TXT.ReadTXT("work/" + extractedFileName + "." + extractedFileType);
                            assert calc != null;
                            calc = Calculation.Calc(calc);
                        }
                        case "json" -> {
                            calc = JSON.ReadJSON("work/" + extractedFileName + "." + extractedFileType);
                            assert calc != null;
                            calc = Calculation.Calc(calc);
                        }
                        case "xml" -> {
                            calc = XML.ReadXML("work/" + extractedFileName + "." + extractedFileType);
                            assert calc != null;
                            calc = Calculation.Calc(calc);
                        }
                    }
                }
                break;
            case "jar":
                filePath = "work/" + fileName + "." + fileType;
                if (!key.equals("null")) {
                    String newFilePath = "temp/D" + fileName + "." + fileType;
                    Encryption.decrypt(key, filePath, newFilePath);
                    ArchivingJAR.extractArchiveJAR(newFilePath, "work");
                    System.out.print("Enter fileName of extractedFile: ");
                    String extractedFileName = in.nextLine(), extractedFileType = extractedFileName.substring(extractedFileName.length() - 3);
                    extractedFileName = extractedFileName.substring(0, extractedFileName.length() - 4);
                    switch (extractedFileType) {
                        case "txt" -> {
                            calc = TXT.ReadTXT("work/" + extractedFileName + "." + extractedFileType);
                            assert calc != null;
                            calc = Calculation.Calc(calc);
                        }
                        case "json" -> {
                            calc = JSON.ReadJSON("work/" + extractedFileName + "." + extractedFileType);
                            assert calc != null;
                            calc = Calculation.Calc(calc);
                        }
                        case "xml" -> {
                            calc = XML.ReadXML("work/" + extractedFileName + "." + extractedFileType);
                            assert calc != null;
                            calc = Calculation.Calc(calc);
                        }
                    }
                } else {
                    ArchivingJAR.extractArchiveJAR(filePath, "work");
                    System.out.print("Enter fileName of extractedFile: ");
                    String extractedFileName = in.nextLine(), extractedFileType = extractedFileName.substring(extractedFileName.length() - 3);
                    extractedFileName = extractedFileName.substring(0, extractedFileName.length() - 4);
                    switch (extractedFileType) {
                        case "txt" -> {
                            calc = TXT.ReadTXT("work/" + extractedFileName + "." + extractedFileType);
                            assert calc != null;
                            calc = Calculation.Calc(calc);
                        }
                        case "json" -> {
                            calc = JSON.ReadJSON("work/" + extractedFileName + "." + extractedFileType);
                            assert calc != null;
                            calc = Calculation.Calc(calc);
                        }
                        case "xml" -> {
                            calc = XML.ReadXML("work/" + extractedFileName + "." + extractedFileType);
                            assert calc != null;
                            calc = Calculation.Calc(calc);
                        }
                    }
                }
                break;
            case "txt":
                if (!key.equals("null")) {
                    filePath = "work/" + fileName + "." + fileType;
                    String newFilePath = "work/D" + fileName + "." + fileType;
                    Encryption.decrypt(key, filePath, newFilePath);
                    calc = TXT.ReadTXT(newFilePath);
                    assert calc != null;
                    calc = Calculation.Calc(calc);
                } else {
                    filePath = "work/" + fileName + "." + fileType;
                    calc = TXT.ReadTXT(filePath);
                    assert calc != null;
                    calc = Calculation.Calc(calc);
                }
                break;
            case "json":
                if (!key.equals("null")) {
                    filePath = "work/" + fileName + "." + fileType;
                    String newFilePath = "work/D" + fileName + "." + fileType;
                    Encryption.decrypt(key, filePath, newFilePath);
                    calc = JSON.ReadJSON(newFilePath);
                    assert calc != null;
                    calc = Calculation.Calc(calc);
                } else {
                    filePath = "work/" + fileName + "." + fileType;
                    calc = JSON.ReadJSON(filePath);
                    assert calc != null;
                    calc = Calculation.Calc(calc);
                }
                break;
            case "xml":
                if (!key.equals("null")) {
                    filePath = "work/" + fileName + "." + fileType;
                    String newFilePath = "work/D" + fileName + "." + fileType;
                    Encryption.decrypt(key, filePath, newFilePath);
                    calc = XML.ReadXML(newFilePath);
                    assert calc != null;
                    calc = Calculation.Calc(calc);
                } else {
                    filePath = "work/" + fileName + "." + fileType;
                    calc = XML.ReadXML(filePath);
                    assert calc != null;
                    calc = Calculation.Calc(calc);
                }
                break;
        }

        System.out.println("\nWhere should I write down the answer?");
        System.out.println("1. Console");
        System.out.println("2. TXT");
        System.out.println("3. JSON");
        System.out.println("4. XML");
        System.out.print("Your choice: ");
        choose = in.nextLine();

        switch (choose) {
            case "1" -> System.out.println("Calculated data = " + calc);
            case "2" -> {
                System.out.println("\nWhat do you want to do with calculated data?");
                System.out.println("1. Write data to TXT");
                System.out.println("2. Write data to TXT, ARCHIVE");
                System.out.println("3. Write data to TXT, ARCHIVE, ENCRYPT");
                System.out.println("4. Write data to TXT, ENCRYPT, ARCHIVE");
                System.out.print("Your choice: ");
                choose = in.nextLine();
                switch (choose) {
                    case "1" -> TXT.WriteTXT(calc, "result/result.txt");
                    case "2" -> {
                        TXT.WriteTXT(calc, "temp/result.txt");
                        System.out.print("What type of ARCHIVE do you want to use? (zip/jar): ");
                        String chooseArchive = in.nextLine();
                        if (chooseArchive.equals("zip")) {
                            ArchivingZIP.createArchiveZIP(List.of("temp/result.txt"), "result/result.zip");
                        } else if (chooseArchive.equals("jar")) {
                            ArchivingJAR.createArchiveJAR(List.of("temp/result.txt"), "result/result.jar");
                        }
                    }
                    case "3" -> {
                        TXT.WriteTXT(calc, "temp/result.txt");
                        System.out.print("What type of ARCHIVE do you want to use? (zip/jar): ");
                        String chooseArchive = in.nextLine();
                        if (chooseArchive.equals("zip")) {
                            ArchivingZIP.createArchiveZIP(List.of("temp/result.txt"), "temp/result.zip");
                            System.out.print("Enter secret key (16, 24 or 32 characters): ");
                            key = in.nextLine();
                            if (key.length() == 16 || key.length() == 24 || key.length() == 32) {
                                Encryption.encrypt(key, "temp/result.zip", "result/result.zip");
                            } else {
                                System.out.println("Key is not correct!");
                            }
                        } else if (chooseArchive.equals("jar")) {
                            ArchivingJAR.createArchiveJAR(List.of("temp/result.txt"), "temp/result.jar");
                            System.out.print("Enter secret key (16, 24 or 32 characters): ");
                            key = in.nextLine();
                            if (key.length() == 16 || key.length() == 24 || key.length() == 32) {
                                Encryption.encrypt(key, "temp/result.jar", "result/result.jar");
                            } else {
                                System.out.println("Key is not correct!");
                            }
                        }
                    }
                    case "4" -> {
                        TXT.WriteTXT(calc, "temp/data.txt");
                        System.out.print("Enter secret key (16, 24 or 32 characters): ");
                        key = in.nextLine();
                        if (key.length() == 16 || key.length() == 24 || key.length() == 32) {
                            Encryption.encrypt(key, "temp/data.txt", "temp/result.txt");
                            System.out.print("What type of ARCHIVE do you want to use? (zip/jar): ");
                            String chooseArchive = in.nextLine();
                            if (Objects.equals(chooseArchive, "zip")) {
                                ArchivingZIP.createArchiveZIP(List.of("temp/result.txt"), "result/result.zip");
                            } else if (Objects.equals(chooseArchive, "jar")) {
                                ArchivingJAR.createArchiveJAR(List.of("temp/result.txt"), "result/result.jar");
                            }
                        } else {
                            System.out.println("Key is not correct!");
                        }
                    }
                }
            }
            case "3" -> {
                System.out.println("\nWhat do you want to do with calculated data?");
                System.out.println("1. Write data to JSON");
                System.out.println("2. Write data to JSON, ARCHIVE");
                System.out.println("3. Write data to JSON, ARCHIVE, ENCRYPT");
                System.out.println("4. Write data to JSON, ENCRYPT, ARCHIVE");
                System.out.print("Your choice: ");
                choose = in.nextLine();
                switch (choose) {
                    case "1" -> JSON.WriteJSON(calc, "result/result.json");
                    case "2" -> {
                        JSON.WriteJSON(calc, "temp/result.json");
                        System.out.print("What type of ARCHIVE do you want to use? (zip/jar): ");
                        String chooseArchive = in.nextLine();
                        if (chooseArchive.equals("zip")) {
                            ArchivingZIP.createArchiveZIP(List.of("temp/result.json"), "result/result.zip");
                        } else if (chooseArchive.equals("jar")) {
                            ArchivingJAR.createArchiveJAR(List.of("temp/result.json"), "result/result.jar");
                        }
                    }
                    case "3" -> {
                        JSON.WriteJSON(calc, "temp/result.txt");
                        System.out.print("What type of ARCHIVE do you want to use? (zip/jar): ");
                        String chooseArchive = in.nextLine();
                        if (chooseArchive.equals("zip")) {
                            ArchivingZIP.createArchiveZIP(List.of("temp/result.json"), "temp/result.zip");
                            System.out.print("Enter secret key (16, 24 or 32 characters): ");
                            key = in.nextLine();
                            if (key.length() == 16 || key.length() == 24 || key.length() == 32) {
                                Encryption.encrypt(key, "temp/result.zip", "result/result.zip");
                            } else {
                                System.out.println("Key is not correct!");
                            }
                        } else if (chooseArchive.equals("jar")) {
                            ArchivingJAR.createArchiveJAR(List.of("temp/result.json"), "temp/result.jar");
                            System.out.print("Enter secret key (16, 24 or 32 characters): ");
                            key = in.nextLine();
                            if (key.length() == 16 || key.length() == 24 || key.length() == 32) {
                                Encryption.encrypt(key, "temp/result.jar", "result/result.jar");
                            } else {
                                System.out.println("Key is not correct!");
                            }
                        }
                    }
                    case "4" -> {
                        JSON.WriteJSON(calc, "temp/data.json");
                        System.out.print("Enter secret key (16, 24 or 32 characters): ");
                        key = in.nextLine();
                        if (key.length() == 16 || key.length() == 24 || key.length() == 32) {
                            Encryption.encrypt(key, "temp/data.json", "temp/result.json");
                            System.out.print("What type of ARCHIVE do you want to use? (zip/jar): ");
                            String chooseArchive = in.nextLine();
                            if (Objects.equals(chooseArchive, "zip")) {
                                ArchivingZIP.createArchiveZIP(List.of("temp/result.json"), "result/result.zip");
                            } else if (Objects.equals(chooseArchive, "jar")) {
                                ArchivingJAR.createArchiveJAR(List.of("temp/result.json"), "result/result.jar");
                            }
                        } else {
                            System.out.println("Key is not correct!");
                        }
                    }
                }
            }
            case "4" -> {
                System.out.println("\nWhat do you want to do with calculated data?");
                System.out.println("1. Write data to XML");
                System.out.println("2. Write data to XML, ARCHIVE");
                System.out.println("3. Write data to XML, ARCHIVE, ENCRYPT");
                System.out.println("4. Write data to XML, ENCRYPT, ARCHIVE");
                System.out.print("Your choice: ");
                choose = in.nextLine();
                switch (choose) {
                    case "1" -> XML.WriteXML(calc, "result/result.xml");
                    case "2" -> {
                        XML.WriteXML(calc, "temp/result.xml");
                        System.out.print("What type of ARCHIVE do you want to use? (zip/jar): ");
                        String chooseArchive = in.nextLine();
                        if (chooseArchive.equals("zip")) {
                            ArchivingZIP.createArchiveZIP(List.of("temp/result.xml"), "result/result.zip");
                        } else if (chooseArchive.equals("jar")) {
                            ArchivingJAR.createArchiveJAR(List.of("temp/result.xml"), "result/result.jar");
                        }
                    }
                    case "3" -> {
                        XML.WriteXML(calc, "temp/result.xml");
                        System.out.print("What type of ARCHIVE do you want to use? (zip/jar): ");
                        String chooseArchive = in.nextLine();
                        if (chooseArchive.equals("zip")) {
                            ArchivingZIP.createArchiveZIP(List.of("temp/result.xml"), "temp/result.zip");
                            System.out.print("Enter secret key (16, 24 or 32 characters): ");
                            key = in.nextLine();
                            if (key.length() == 16 || key.length() == 24 || key.length() == 32) {
                                Encryption.encrypt(key, "temp/result.zip", "result/result.zip");
                            } else {
                                System.out.println("Key is not correct!");
                            }
                        } else if (chooseArchive.equals("jar")) {
                            ArchivingJAR.createArchiveJAR(List.of("temp/result.xml"), "temp/result.jar");
                            System.out.print("Enter secret key (16, 24 or 32 characters): ");
                            key = in.nextLine();
                            if (key.length() == 16 || key.length() == 24 || key.length() == 32) {
                                Encryption.encrypt(key, "temp/result.jar", "result/result.jar");
                            } else {
                                System.out.println("Key is not correct!");
                            }
                        }
                    }
                    case "4" -> {
                        XML.WriteXML(calc, "temp/data.xml");
                        System.out.print("Enter secret key (16, 24 or 32 characters): ");
                        key = in.nextLine();
                        if (key.length() == 16 || key.length() == 24 || key.length() == 32) {
                            Encryption.encrypt(key, "temp/data.xml", "temp/result.xml");
                            System.out.print("What type of ARCHIVE do you want to use? (zip/jar): ");
                            String chooseArchive = in.nextLine();
                            if (Objects.equals(chooseArchive, "zip")) {
                                ArchivingZIP.createArchiveZIP(List.of("temp/result.xml"), "result/result.zip");
                            } else if (Objects.equals(chooseArchive, "jar")) {
                                ArchivingJAR.createArchiveJAR(List.of("temp/result.xml"), "result/result.jar");
                            }
                        } else {
                            System.out.println("Key is not correct!");
                        }
                    }
                }
            }
        }
    }
}
