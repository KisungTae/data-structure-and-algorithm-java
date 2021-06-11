package com.company.moderate;

//Diving Board: You are building a diving board by placing a bunch of planks of wood end-to-end.
//        There are two types of planks, one of length shorter and one of length longer. You must use
//        exactly K planks of wood. Write a method to generate all possible lengths for the diving board.

// 3:55

// combination with repetition: n+r-1 C r == (n + r - 1) / r!(n-1)!
// combination: n C r == n! / r!(n-r)!


// review the runtime of the algorithm with memorization


public class Question11Review {

    public Question11Review() {
        int shorter = 2;
        int longer = 4;
        int k = 5;

        compute(shorter, longer, k);

    }

    private void compute(int shorter, int longer, int k) {
        if (shorter == longer) {
            System.out.println("length: " + (shorter * k));
            return;
        }

        int shorterMultiply = k;
        int longerMultiply = 0;

        for (int i = 1; i <= k; i++) {
            int shorterLength = shorter * shorterMultiply;
            int longerLength = longer * longerMultiply;
            System.out.println("length: " + (shorterLength + longerLength));

            shorterMultiply -= 1;
            longerMultiply += 1;
        }

        System.out.println("length: " + (longer * k));
    }


}
