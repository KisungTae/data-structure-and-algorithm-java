package com.company.bitmanipulation;

//Flip Bit to Win: You have an integer and you can flip exactly one bit from a O to a 1. Write code to
//        find the length of the longest sequence of 1 s you could create.
//        EXAMPLE
//        Input: 1775 (or: 11011101111)
//        Output: 8

public class Question3Review {
    public Question3Review() {
        int input = 0b11001101110000;
        int prev = 0;
        int sum = 0;
        int best = Integer.MIN_VALUE;

        while (input > 0) {
            System.out.println("prev: " + prev + " | sum: " + sum + " | best: " + best);
            if ((input & 1) == 0) {
                best = Math.max(sum, best);
                sum = sum - prev;
                sum++;
                prev = sum;
            } else {
                sum++;
            }
            input >>>= 1;
        }


    }
}
