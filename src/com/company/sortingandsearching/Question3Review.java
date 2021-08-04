package com.company.sortingandsearching;

//Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown
//        number of times, write code to find an element in the array. You may assume that the array was
//        originally sorted in increasing order.
//EXAMPLE
//        lnput: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
//        Output: 8 (the index of 5 in the array)

import java.util.Arrays;

// 11:47
public class Question3Review {

    public Question3Review() {
//        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int[] arr = {2, 2, 2, 3, 4, 2};
        int input = 3;
        System.out.println(Arrays.toString(arr));
        System.out.println("index of " + input + " is " + findIndexAnswer(arr, input, 0, arr.length - 1));
    }

    private int findIndexAnswer(int[] arr, int num, int left, int right) {
        if (left > right) return -1;

        int middleIndex = (left + right) / 2;
        int middleValue = arr[middleIndex];

        if (middleValue == num) return middleIndex;

        // left ordered
        if (arr[left] < middleValue) {
            if (arr[left] <= num && num < middleValue)
                return findIndexAnswer(arr, num, left, middleIndex - 1);
            else return findIndexAnswer(arr, num, middleIndex + 1, right);
        } else if (arr[left] > middleValue) {
            if (middleValue < num && num <= arr[right])
                return findIndexAnswer(arr, num, middleIndex + 1, right);
            else return findIndexAnswer(arr, num, left, middleIndex - 1);
        } else {
            // same
            if (middleValue != arr[right])
                return findIndexAnswer(arr, num, middleIndex + 1, right);
            else {
                int index = findIndexAnswer(arr, num, left, middleIndex - 1);
                if (index != -1) return index;
                else return findIndexAnswer(arr, num, middleIndex + 1, right);
            }
        }
    }

    private int findIndex(int[] arr, int num, int left, int right) {
        if (left > right) return -1;

        int middleIndex = (left + right) / 2;
        int middleValue = arr[middleIndex];

        if (num == middleValue) return middleIndex;
        else if (num > middleValue && num <= arr[right]) return findIndex(arr, num, middleIndex + 1, right);
        else return findIndex(arr, num, left, middleIndex - 1);
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
