package com.company.sortingandsearching;

//Peaks and Valleys: In an array of integers, a "peak" is an element which is greater than or equal to
//        the adjacent integers and a "valley" is an element which is less than or equal to the adjacent integers.
//        For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys. Given an array
//        of integers, sort the array into an alternating sequence of peaks and valleys.
//        EXAMPLE
//        Input: {5, 3, 1, 2, 3}
//        Output: {5, 1, 3, 2, 3}

//      10:32

import java.util.Arrays;

public class Question11Review {
    public Question11Review() {
        int[] arr = {5, 3, 1, 2, 3};
        alternate(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void alternate(int[] arr) {

        for (int i = 1; i < arr.length; i += 2) {
            int maxIndex = maxIndex(arr, i - 1, i, i + 1);
            if (maxIndex != i) {
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    private int maxIndex(int[] arr, int prev, int curr, int next) {
        int a = prev >= 0 && prev < arr.length ? arr[prev] : Integer.MIN_VALUE;
        int b = curr >= 0 && curr < arr.length ? arr[curr] : Integer.MIN_VALUE;
        int c = next >= 0 && next < arr.length ? arr[next] : Integer.MIN_VALUE;

        int max = Math.max(a, Math.max(b, c));
        if (max == a) return prev;
        else if (max == b) return curr;
        else return next;
    }
}
