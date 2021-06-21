package com.company.moderate;

//Calculator: Given an arithmetic equation consisting of positive integers,+,-,* and/ (no parentheses),
//        compute t he result.
//        EXAMPLE
//        Input:
//        Output:
//        SOLUTION
//        2*3+5/6*3+15
//        23.5


import java.util.ArrayList;
import java.util.Arrays;

public class Question26 {

    public Question26() {
        String input = "2*3+5/6*3+15";
        ArrayList<String> terms = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (isOperator(ch)) {
                terms.add(stringBuilder.toString());
                stringBuilder.setLength(0);
                terms.add(String.valueOf(ch));
            } else stringBuilder.append(ch);
        }
        terms.add(stringBuilder.toString());
        System.out.println(terms.toString());
        while (terms.size() > 1) {
            calculate(terms, getOperatorIndex(terms));
        }
        System.out.println("sum: " + terms.get(0));
    }

    private int getOperatorIndex(ArrayList<String> terms) {
        String firstOperator = terms.get(1);
        if (terms.size() < 4) return 1;
        else {
            String secondOperator = terms.get(3);
            if ((firstOperator.equals("+") || firstOperator.equals("-")) && (secondOperator.equals("*") || secondOperator.equals("/")))
                return 3;
            else return 1;
        }
    }

    private void calculate(ArrayList<String> terms, int operatorIndex) {
        System.out.println(terms.toString() + " index: " + operatorIndex);

        double left = Double.valueOf(terms.get(operatorIndex - 1));
        String operator = terms.get(operatorIndex);
        double right = Double.valueOf(terms.get(operatorIndex + 1));

        double sum = 0;
        switch (operator) {
            case "+": sum = left + right; break;
            case "-": sum = left - right; break;
            case "*": sum = left * right; break;
            case "/": sum = left / right; break;
        }
        terms.remove(operatorIndex - 1);
        terms.add(operatorIndex - 1, String.valueOf(sum));
        terms.remove(operatorIndex);
        terms.remove(operatorIndex);
    }

    private boolean isOperator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            return true;
        return false;
    }
}
