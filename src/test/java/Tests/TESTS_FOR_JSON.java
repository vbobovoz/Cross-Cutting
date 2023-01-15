package Tests;

import org.example.ReadingAndWriting.JSON;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.example.ReadingAndWriting.JSON.ReadJSON;

public class TESTS_FOR_JSON {
    @Test
    public void ReadJSON_test() {
        assertTrue(false);
    }

    @Test
    public void WriteJSON_test() {
        String filePath = "test.json";
        ArrayList<ArrayList<String>> lines = new ArrayList<>();
        ArrayList<String> innerList = new ArrayList<>();
        innerList.add("expression1");
        innerList.add("expression2");
        lines.add(innerList);
        innerList = new ArrayList<>();
        innerList.add("expression3");
        innerList.add("expression4");
        lines.add(innerList);
        JSON.WriteJSON(lines, filePath);
        File file = new File(filePath);
        assertTrue(file.exists());
    }
}
