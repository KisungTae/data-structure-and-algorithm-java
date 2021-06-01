package com.company.bitmanipulation;

public class Question3Review {
    public Question3Review() {
        flipToWin();
    }

    public void flipToWin() {
//        int input = 1775;

        int input = Integer.valueOf("1001010000", 2);
        int prevCount = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        boolean flip = false;

        while (input > 0) {
            int and = input & 1;
            System.out.println("input: " + Integer.toBinaryString(input));
            if (and > 0) {
                count++;
            } else {
                max = Math.max(max, count);
                count -= prevCount;
                count++;
                prevCount = count;
            }
            input >>>= 1;
        }

        System.out.println("max: " + max);
    }
}
