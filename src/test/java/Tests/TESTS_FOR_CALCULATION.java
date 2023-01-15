package Tests;

import org.example.Calculation.Calculation;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class TESTS_FOR_CALCULATION {
    @Test
    public void Calculation_test() {
        ArrayList<ArrayList<String>> act_matrix = new ArrayList<>();
        ArrayList<String> r1 = new ArrayList<>(); ArrayList<String> r2 = new ArrayList<>(); ArrayList<String> r3 = new ArrayList<>(); ArrayList<String> r4 = new ArrayList<>();
        r1.add("5+5"); r2.add("15/3"); r3.add("(2+2)*2"); r4.add("9*3/9");
        act_matrix.add(r1); act_matrix.add(r2); act_matrix.add(r3); act_matrix.add(r4);

        ArrayList<ArrayList<String>> exp_matrix = new ArrayList<>();
        ArrayList<String> e1 = new ArrayList<>(); ArrayList<String> e2 = new ArrayList<>(); ArrayList<String> e3 = new ArrayList<>(); ArrayList<String> e4 = new ArrayList<>();
        e1.add("10"); e2.add("5"); e3.add("8"); e4.add("3");
        exp_matrix.add(e1); exp_matrix.add(e2); exp_matrix.add(e3); exp_matrix.add(e4);

        act_matrix = new ArrayList<>(Calculation.Calc(act_matrix));
        assertEquals(exp_matrix, act_matrix);
    }
}
