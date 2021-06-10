package com.company.moderate;

//Factorial Zeros: Write an algorithm which computes the number of trailing zeros in n factorial.



public class Question5Review {

    public Question5Review() {
        int n = 15;
        long num = 1;
        for (int i = 2; i <= n; i++) {
            System.out.println("num: " + num);
            num *= i;
        }

        System.out.println("num: " + num);


    }
}
