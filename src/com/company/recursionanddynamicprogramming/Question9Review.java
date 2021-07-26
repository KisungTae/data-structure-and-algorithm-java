package com.company.recursionanddynamicprogramming;

//Parens: Implement an algorithm to print all valid (i.e., properly opened and closed) combinations
//        of n pairs of parentheses.
//        EXAMPLE
//        Input: 3
//        Output: (( () ) ) , ( () () ) , ( () ) () , () ( () ) , () () ()

// 1:53
// 1:53

public class Question9Review {
    public Question9Review() {
        int num = 3;
        printParentheses(num, num, "");
    }

    private void printParentheses(int left, int right, String prefix) {
        if (left == 0 && right == 0) {
            System.out.println(prefix);
            return;
        }

        if (left < 0) return;
        if (right < 0) return;

        if (left == right) {
            printParentheses(left - 1, right, prefix + '(');
        } else {
            printParentheses(left - 1, right, prefix + '(');
            printParentheses(left, right - 1, prefix + ')');
        }
    }
}
