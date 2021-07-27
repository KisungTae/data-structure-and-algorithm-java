package com.company.recursionanddynamicprogramming;

public class Question14Review {

//    Boolean Evaluation: Given a boolean expression consisting of the symbols 0 (false), 1 (true), &
//            (AND), I (OR), and /\ (XOR), and a desired boolean result value result, implement a function to
//    count the number of ways of parenthesizing the expression such that it evaluates to result.
//            EXAMPLE
//    countEval("1^0|0|1", false) -> 2
//    countEval("0&0&0&1^1|0", true) -> 10

//    10:08

    public Question14Review() {
        String expression = "1^0|0|1";
        boolean result = false;

//        int count = count(expression, result);
//        System.out.println("count: " + count);
        boolean a = true;
        boolean b = false;
        boolean c = a | a;
        char d = c ? '1' : '0';
        System.out.println("d: " + d);
    }

    private int count(String expression, boolean result) {
        if (expression.length() == 1) {
            boolean evaluation = Boolean.parseBoolean(expression);
            if (evaluation == result) return 1;
            else return 0;
        }

        int count = 0;
        for (int i = 1; i < expression.length(); i += 2) {
            String newExpression = evaluate(expression, i);
            count += count(newExpression, result);
        }
        return count;
    }

    private String evaluate(String expression, int index) {

        boolean left = expression.charAt(index - 1) == '1';
        char operator = expression.charAt(index);
        boolean right = expression.charAt(index + 1) == '1';
        char newLeft = calculate(left, operator, right) ? '1' : '0';


        String leftPart = expression.substring(0, index - 1);
        String rightPart = expression.substring(index + 2);

        String newExpression = leftPart + newLeft + rightPart;
        return newExpression;
    }

    private boolean calculate(boolean left, char operator, boolean right) {
        switch (operator) {
            case '^': return left ^ right;
            case '|': return left | right;
            case '&': return left & right;
            default: return false;
        }
    }





}
