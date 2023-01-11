package org.example.Calculation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculation {
    private String expression;
    private Integer result;

    public static ArrayList<ArrayList<String>> Calc(ArrayList<ArrayList<String>> lines) {
        ArrayList<ArrayList<String>> answ = new ArrayList<>();
        Pattern pattern = Pattern.compile("[0-9]+([\\+\\-\\*\\/][0-9])*");
        for(int i = 0; i < lines.size(); ++i) {
            ArrayList<String> tmp = new ArrayList<>();
            for(int j = 0; j < lines.get(i).size(); ++j) {
                Matcher matcher = pattern.matcher(lines.get(i).get(j));
                if(matcher.find()) {
                    tmp.add(String.valueOf(eval(lines.get(i).get(j))));
                } else {
                    tmp.add(lines.get(i).get(j));
                }
            }
            answ.add(i, tmp);
        }
        return answ;
    }

    public static int eval(String s) {
        LinkedList<Integer> st = new LinkedList<Integer>();
        LinkedList<Character> op = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDelim(c))
                continue;
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperator(st,op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    processOperator(st, op.removeLast());
                op.add(c);
            } else {
                String operand = "";
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    operand += s.charAt(i++);
                --i;
                st.add(Integer.parseInt(operand));
            }
        }
        while (!op.isEmpty())
            processOperator(st, op.removeLast());
        return st.get(0);
    }

    static boolean isDelim(char c){
        return c == ' ';
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    static int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }

    static void processOperator(LinkedList<Integer> st, char op) {
        int r = st.removeLast();
        int l = st.removeLast();
        switch (op) {
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case '/':
                st.add(l / r);
                break;
            case '%':
                st.add(l % r);
                break;
        }
    }
}
