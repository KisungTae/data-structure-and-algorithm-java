package com.company.sortingandsearching;

import java.util.Arrays;

public class Question1Review {

//    Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the
//    end to hold B. Write a method to merge B into A in sorted order.

//    7:57

    public Question1Review() {
        int[] arrA = {1, 2, 3, 3, 4, 5, 6, 17, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] arrB = {0, 17, 70};
//        sort(arrA, arrB);
        sortAnswer(arrA, arrB, 11, 3);
        System.out.println(Arrays.toString(arrA));
    }

    private void sortAnswer(int[] longer, int[] shorter, int longerLength, int shorterLength) {
        int longerLastIndex = longerLength - 1;
        int shorterLastIndex = shorterLength - 1;
        int lastIndex = longerLength + shorterLength - 1;
        while (shorterLastIndex >= 0) {
            if (longerLastIndex >= 0 && longer[longerLastIndex] > shorter[shorterLastIndex]) {
                longer[lastIndex] = longer[longerLastIndex];
                longerLastIndex--;
            } else {
                longer[lastIndex] = shorter[shorterLastIndex];
                shorterLastIndex--;
            }
            lastIndex--;
        }
    }








    private void sort(int[] longer, int[] shorter) {
        int longerIndex = 10;
        int shorterIndex = shorter.length - 1;
        int lastIndex = longerIndex + shorterIndex + 1;

        while (longerIndex >= 0 && shorterIndex >= 0) {
            if (longer[longerIndex] > shorter[shorterIndex]) {
                longer[lastIndex] = longer[longerIndex];
                longerIndex--;
            } else {
                longer[lastIndex] = shorter[shorterIndex];
                shorterIndex--;
            }
            lastIndex--;
        }
        while (shorterIndex >= 0 && lastIndex >= 0) {
            longer[lastIndex] = shorter[shorterIndex];
            lastIndex--;
            shorterIndex--;
        }
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
