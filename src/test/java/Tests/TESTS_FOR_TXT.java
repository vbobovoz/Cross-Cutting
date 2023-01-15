package Tests;

import org.example.ReadingAndWriting.TXT;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static junit.framework.TestCase.*;

public class TESTS_FOR_TXT {
    @Test
    public void ReadTXT_test() throws IOException {
        File file = File.createTempFile("test", ".txt");
        FileWriter writer = new FileWriter(file);
        writer.write("Line 1\nLine 2\nLine 3");
        writer.close();

        ArrayList<ArrayList<String>> expected = new ArrayList<>();
        ArrayList<String> line1 = new ArrayList<>();
        line1.add("Line 1");
        ArrayList<String> line2 = new ArrayList<>();
        line2.add("Line 2");
        ArrayList<String> line3 = new ArrayList<>();
        line3.add("Line 3");
        expected.add(line1);
        expected.add(line2);
        expected.add(line3);

        ArrayList<ArrayList<String>> result = TXT.ReadTXT(file.getAbsolutePath());
        assertNotNull(result);
        assertEquals(expected, result);

        file.delete();
    }

    @Test
    public void ReadTXT_FileNotFound() {
        ArrayList<ArrayList<String>> result = TXT.ReadTXT("non-existing-file.txt");
        assertNull(result);
    }

    @Test
    public void WriteTXT_test() throws IOException {
        File file = File.createTempFile("test", ".txt");
        ArrayList<ArrayList<String>> lines = new ArrayList<>();
        ArrayList<String> line1 = new ArrayList<>();
        line1.add("Line 1");
        ArrayList<String> line2 = new ArrayList<>();
        line2.add("Line 2");
        ArrayList<String> line3 = new ArrayList<>();
        line3.add("Line 3");
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);

        TXT.WriteTXT(lines, file.getAbsolutePath());

        Scanner reader = new Scanner(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        while(reader.hasNextLine()) {
            builder.append(reader.nextLine());
            if(reader.hasNextLine()) {
                builder.append("\n");
            }
        }
        reader.close();
        assertEquals("Line 1\nLine 2\nLine 3", builder.toString());

        file.delete();
    }
}
