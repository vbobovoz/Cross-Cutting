package Tests;

import org.example.ReadingAndWriting.XML;
import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

public class TESTS_FOR_XML {
    @Test
    public void ReadXML_test() throws Exception {
        assertTrue(false);
    }

    @Test
    public void WriteXML_test() throws ParserConfigurationException, TransformerException {
        ArrayList<String> row1 = new ArrayList<String>();
        row1.add("value1");
        row1.add("value2");
        row1.add("value3");
        ArrayList<String> row2 = new ArrayList<String>();
        row2.add("value4");
        row2.add("value5");
        row2.add("value6");
        ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
        lines.add(row1);
        lines.add(row2);
        String filePath = "output.xml";
        XML.WriteXML(lines, filePath);
        File outputFile = new File(filePath);
        assertTrue(outputFile.exists());
    }
}
