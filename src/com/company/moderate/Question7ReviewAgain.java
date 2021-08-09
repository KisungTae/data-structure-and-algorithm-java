package com.company.moderate;

//Number Max: Write a method that finds the maximum of two numbers. You should not use if-else
//        or any other comparison operator.

public class Question7ReviewAgain {

    public Question7ReviewAgain() {
        int a = 170;
        int b = 150;

        int diff = a - b;
        diff *= -1;
        int max = a + diff;

        System.out.println("max: " + max);
    }
}
