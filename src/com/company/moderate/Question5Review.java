package com.company.moderate;

//Factorial Zeros: Write an algorithm which computes the number of trailing zeros in n factorial.


import javax.swing.plaf.IconUIResource;

public class Question5Review {

    public Question5Review() {
        int n = 25;
//        long num = 1;
//        for (int i = 2; i <= n; i++) {
//            num *= i;
//            System.out.println("i: " + i + " - num: " + num);
//        }

//        System.out.println("num: " + num);
        count(n);
        check(n);
    }

    private void count(int n) {
        int count = 0;
        for (int i = 5; (n / i) > 0; i *= 5) {
            count += (n / i);
        }
        System.out.println("count: " + count);
    }

    private void check(int n) {
        int count = 0;
        int addUp = 0;
        for (int i = 5; i <= n; i *= 5) {
            addUp += count;
            count++;
        }
        addUp += (n / 5);
        System.out.println("count: " + addUp);
    }
}
