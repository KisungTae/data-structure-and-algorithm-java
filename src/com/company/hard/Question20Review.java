package com.company.hard;

//Continuous Median: Numbers are randomly generated and passed to a method. Write a program
//        to find and maintain the median value as new values are generated.

import java.util.Random;

public class Question20Review {

    double median;

    public Question20Review() {
        Random random = new Random();
        int n = 10;
        for (int i = 0; i < n; i++) {
            maintain(random.nextInt(1000));
        }
    }

    private void maintain(int num) {

    }
}
