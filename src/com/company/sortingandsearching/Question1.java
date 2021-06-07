package com.company.sortingandsearching;

import java.util.Arrays;

public class Question1 {

//    Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the
//    end to hold B. Write a method to merge B into A in sorted order.

//    5:40

    public Question1() {
        int[] arrA = {1, 2, 3, 3, 4, 5, 6, 17, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] arrB = {7, 8, 30};
        merge(arrA, end(arrA), arrB);
        System.out.println(Arrays.toString(arrA));
    }

    private int end(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println("i: " + i);
            if (arr[i] != 0) return i;
        }
        return -1;
    }

    private void merge(int[] arrA, int arrAEnd, int[] arrB) {
        int indexA = 0;
        int indexB = 0;

        while (indexA <= arrAEnd && indexB < arrB.length) {
            if (arrA[indexA] < arrB[indexB]) indexA++;
            else if (arrA[indexA] == arrB[indexB]) {
                indexA++;
                indexB++;
            } else indexB++;
        }

        
    }
}
