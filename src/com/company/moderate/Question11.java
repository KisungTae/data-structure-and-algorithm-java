package com.company.moderate;

//Diving Board: You are building a diving board by placing a bunch of planks of wood end-to-end.
//        There are two types of planks, one of length shorter and one of length longer. You must use
//        exactly K planks of wood. Write a method to generate all possible lengths for the diving board.

// 3:55

// combination with repetition: n+r-1 C r == (n + r - 1) / r!(n-1)!
// combination: n C r == n! / r!(n-r)!
// https://bb-dochi.tistory.com/47
// https://www.geeksforgeeks.org/combinations-with-repetitions/

// review the runtime of the algorithm with memorization
// 4:45

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question11 {

    public Question11() {
        int shorter = 39;
        int longer = 7;
        int k = 5;

        compute(shorter, longer, k);

        int[] arr = {1, 2, 3, 4};
        int r = 3;
        int[] chosen = new int[r];
        printCombination(arr, chosen, 0, r, 0, arr.length - 1);
    }

    private void printCombination(int arr[], int[] chosen, int index, int r, int start, int end) {

        if (index == r) {
            System.out.println(Arrays.toString(chosen));
            return;
        }


        for (int i = start; i <= end; i++) {
            chosen[index] = i;
            printCombination(arr, chosen, index + 1, r, i, end);
        }
    }

    private void compute(int shorter, int longer, int k) {
        Set<Integer> length = new HashSet<>();

        for (int i = 0; i <= k; i++) {
            int offset = k - i;
            int shortLength = shorter * i;
            int longerLength = longer * offset;
            int sum = shortLength + longerLength;
            length.add(sum);
        }

        System.out.println("count: " + length.size());
    }


}
