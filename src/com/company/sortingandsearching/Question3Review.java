package com.company.sortingandsearching;

//Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown
//        number of times, write code to find an element in the array. You may assume that the array was
//        originally sorted in increasing order.
//EXAMPLE
//        lnput: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
//        Output: 8 (the index of 5 in the array)

// 11:47
public class Question3Review {

    public Question3Review() {
//        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int[] arr = {2, 2, 2, 3, 4, 2};
        int input = 4;
        System.out.println("index of " + input + " is " + find(arr, input));
    }

    private int find(int[] arr, int input) {
        return findHelper(arr, input, 0, arr.length - 1);
    }

    private int findHelper(int[] arr, int input, int left, int right) {
        if (left > right) return -1;
        int midIndex = (left + right) / 2;
        int midValue = arr[midIndex];
        if (midValue == input) return midIndex;

        if (input > midValue) {
            if (input <= arr[right]) return findHelper(arr, input, midIndex + 1, right);
            else return findHelper(arr, input, left, midIndex - 1);
        } else {
            if (input >= arr[left]) return findHelper(arr, input, left, midIndex - 1);
            else return findHelper(arr, input, midIndex + 1, right);
        }
    }
}
