package com.company.moderate;

//Contiguous Sequence: You are given an array of integers (both positive and negative). Find the
//        contiguous sequence with the largest sum. Return the sum.
//        EXAMPLE
//        Input: 2, -8, 3, -2, 4, -10
//        Output: 5 ( i. e • , { 3, -2, 4} )

// 4:19

public class Question17Review {
    public Question17Review() {

        int[] arr = {3, -8, 10, -2, -3, 15, -30, 12};
//        int[] arr = {2, -8, 3, -2, 4, -10};
        System.out.println("max: " + findMax(arr));
        System.out.println("max: " + findMaxAnswer(arr));
    }

    private int findMaxAnswer(int[] arr) {
        int max = arr[0];
        int sum = Math.max(arr[0], 0);

        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];

            if (sum < 0)
                sum = 0;
            else if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

//            int[] arr = {2, -8, 3, -2, 4, -10};

    private int findMax(int[] arr) {
        int max = arr[0];
        int prev = Math.min(arr[0], 0);

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];

//            System.out.println("prev: " + prev + " | curr: " + curr + " | max: " + max);

            if (curr > 0) {
                if ((curr + prev) > 0) {
                    int newMax = max + curr + prev;
                    if (newMax > curr) {
                        max = newMax;
                    } else {
                        max = curr;
                    }
                    prev = 0;
                } else {
                    if (curr > max) {
                        max = curr;
                        prev = 0;
                    } else {
                        prev += curr;
                    }
                }

            } else {
                prev += curr;
            }
        }
        return max;
    }
}
