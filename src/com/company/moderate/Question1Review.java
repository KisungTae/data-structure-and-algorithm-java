package com.company.moderate;

//  Number Swapper: Write a function to swap a number in place (that is, without temporary variables).

// 11:19

public class Question1Review {
    public Question1Review() {
        int a = -13;
        int b = -50;

        a -= b;
        b += a;
        a = b - a;

        System.out.println("a = " + a + " b = " + b);

        System.out.println(Integer.valueOf("101", 2));
        System.out.println(Integer.valueOf("110", 2));
        System.out.println(Integer.valueOf("011", 2));
    }
}
