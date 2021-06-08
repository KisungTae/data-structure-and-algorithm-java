package com.company.sortingandsearching;

import java.util.Arrays;

public class Question1Review {

//    Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the
//    end to hold B. Write a method to merge B into A in sorted order.

//    7:57

    public Question1Review() {
        int[] arrA = {1, 2, 3, 3, 4, 5, 6, 17, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] arrB = {30, 60, 70};
        merge(arrA, end(arrA), arrB);
        System.out.println(Arrays.toString(arrA));
    }

    private int end(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
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

        int startIndex = arrAEnd + arrB.length;
        indexA = arrAEnd;
        indexB = arrB.length - 1;

        while (startIndex >= 0 && indexA >= 0 && indexB >= 0) {
            if (arrA[indexA] >= arrB[indexB]) {
                arrA[startIndex] = arrA[indexA];
                indexA--;
            } else {
                arrA[startIndex] = arrB[indexB];
                indexB--;
            }
            startIndex--;
        }

        while (indexA >= 0) {
            arrA[startIndex] = arrA[indexA];
            indexA--;
            startIndex--;
        }

        while (indexB >= 0) {
            arrA[startIndex] = arrB[indexB];
            indexB--;
            startIndex--;
        }
    }


}
