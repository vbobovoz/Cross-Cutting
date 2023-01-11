package ReadingAndWritingTests;

import org.example.ReadingAndWriting.TXT;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class txtTests {
    private String testFilePath = "testFiles/testFile.txt";
    private ArrayList<String> testLines = new ArrayList<>();

    @Test
    public void ReadTXTtest() throws IOException {
        testLines.add("line 1");
        testLines.add("line 2");
        testLines.add("line 3");
        TXT.WriteTXT(testLines, testFilePath);
        ArrayList<String> readLines = TXT.ReadTXT(testFilePath);
        assertEquals(testLines, readLines);
    }

    @Test
    public void testWriteArrayListToFile() throws IOException {
        testLines.add("line 1");
        testLines.add("line 2");
        testLines.add("line 3");
        TXT.WriteTXT(testLines, testFilePath);
        File file = new File(testFilePath);
        assertTrue(file.exists());
        ArrayList<String> readLines = TXT.ReadTXT(testFilePath);
        assertEquals(testLines, readLines);
    }
}
