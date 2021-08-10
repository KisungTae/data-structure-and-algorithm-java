package com.company.moderate;

//Sub Sort: Given an array of integers, write a method to find indices m and n such that if you sorted
//        elements m through n, the entire array would be sorted. Minimize n - m (that is, find the smallest
//        such sequence).
//        EXAMPLE
//        lnput:1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
//        Output: (3, 9)

import com.sun.security.jgss.GSSUtil;

public class Question16Review {

    public Question16Review() {
        int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
//        find(arr);
        findIndices(arr);
    }

    private void findIndices(int[] arr) {

        int endOfLeft = findEndOfLeft(arr);
        int startOfRight = findStartOfRight(arr);

        System.out.println("end of left: " + endOfLeft);
        System.out.println("start of right: " + startOfRight);

        int minIndex = findMinIndex(arr, startOfRight);
        int maxIndex = findMaxIndex(arr, endOfLeft);

        System.out.println("min index: " + minIndex);
        System.out.println("max index: " + maxIndex);

        int left = findLeft(arr, minIndex, startOfRight);
        int right = findRight(arr, maxIndex, endOfLeft);

        System.out.println("end of left: " + endOfLeft);
        System.out.println("max index: " + maxIndex);
        System.out.println("left: " + left + " | right: " + right);

    }

    private int findRight(int[] arr, int maxIndex, int endOfLeft) {
        for (int i = endOfLeft + 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) return i - 1;
        }
        return -1;
    }

    private int findLeft(int[] arr, int minIndex, int startOfRight) {
        for (int i = startOfRight - 1; i >= 0; i--) {
            if (arr[i] < arr[minIndex]) return i + 1;
        }
        return -1;
    }

    private int findMaxIndex(int[] arr, int endOfLeft) {
        int max = arr[endOfLeft];
        int maxIndex = endOfLeft;
        for (int i = endOfLeft; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private int findMinIndex(int[] arr, int startOfRight) {
        int min = arr[startOfRight];
        int minIndex = startOfRight;
        for (int i = startOfRight; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private int findEndOfLeft(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i - 1] > arr[i]) return i - 1;
        }
        return -1;
    }

    private int findStartOfRight(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return i + 1;
        }
        return -1;
    }


    private void find(int[] arr) {
        int left = Integer.MAX_VALUE;
        int right = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int before = arr[i];
            int after = arr[i + 1];

            if (before > after) {
                right = i + 1;
                int leftIndex = Math.min(left, i);
                System.out.println("left index: " + leftIndex);
                while (leftIndex > 0 && arr[leftIndex] >= arr[right]) {
                    leftIndex--;
                }
                left = leftIndex + 1;
            }

            if (left != Integer.MAX_VALUE && after <= arr[left]) {
                right = i + 1;
            }
        }

        System.out.println("left: " + left + " | right: " + right);
    }
}
