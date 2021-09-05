package com.company.hard;

//Count of 2s: Write a method to count the number of 2s that appear in all the numbers between O
//        and n (inclusive).
//        EXAMPLE
//        Input: 25
//        Output: 9 (2, 12, 20, 21, 22, 23, 24 and 25. Note that 22 counts for two 2s.)

// 10:48

public class Question6Review {

    public Question6Review() {
        int n = 25;

        System.out.println((25%1));

        int count = 0;
        int nLength = String.valueOf(n).length();
        for (int i = 0; i < nLength; i++) {
            count += count(n, i);
        }
        System.out.println("count: " + count);


    }

    private int count(int n, int power) {
        int currPower = (int) Math.pow(10, power);
        int nextPower = currPower * 10;
        int right = n % currPower;

        int roundDown = n - (n % nextPower);
        int roundUp = roundDown + nextPower;

        int digit = (n % nextPower) / currPower;
        if (digit > 2) {
            System.out.println("roundup: " + roundUp);
            return roundUp / 10;
        } else if (digit == 2) {
            System.out.println("rounddown: " + roundDown + " right: " + right);
            return (roundDown / 10) + right + 1;
        } else {
            return roundDown / 10;
        }
    }
}
