package com.company.recursionanddynamicprogramming;

public class Question14ReviewAgain {

//    Boolean Evaluation: Given a boolean expression consisting of the symbols 0 (false), 1 (true), &
//            (AND), I (OR), and /\ (XOR), and a desired boolean result value result, implement a function to
//    count the number of ways of parenthesizing the expression such that it evaluates to result.
//            EXAMPLE
//    countEval("1^0|0|1", false) -> 2
//    countEval("0&0&0&1^1|0", true) -> 10

//    10:08

    public Question14ReviewAgain() {
//        String expression = "1^0|0|1";
        String expression = "0&0&0&1^1|0";
        boolean result = true;

        int count = count(expression, result);
        System.out.println("count: " + count);
    }

    private int count(String expression, boolean result) {
        if (expression.length() == 1) {
            boolean evaluation = Integer.parseInt(expression) == 1;
//            System.out.println("evaluation: " + evaluation + " | result: " + result);
            if (evaluation == result) {
                System.out.println("here");
                return 1;
            }
            else return 0;
        }

        int count = 0;
        for (int i = 1; i < expression.length(); i += 2) {
            String newExpression = evaluate(expression, i);
//            System.out.println("old: " + expression + " | i: " + i + " | new: " + newExpression);
//            System.out.println("expre: " + newExpression);
            count += count(newExpression, result);
        }
        return count;
    }

    private String evaluate(String expression, int index) {

        int left = expression.charAt(index - 1) == '1' ? 1 : 0;
        char operator = expression.charAt(index);
        int right = expression.charAt(index + 1) == '1' ? 1 : 0;
        int newLeft = calculate(left, operator, right);


        String leftPart = expression.substring(0, index - 1);
        String rightPart = expression.substring(index + 2);

        String newExpression = leftPart + newLeft + rightPart;
        return newExpression;
    }

    private int calculate(int left, char operator, int right) {
        switch (operator) {
            case '^': return left ^ right;
            case '|': return left | right;
            case '&': return left & right;
            default: return 0;
        }
    }





}
