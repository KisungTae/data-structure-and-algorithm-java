package com.company.moderate;

//Sub Sort: Given an array of integers, write a method to find indices m and n such that if you sorted
//        elements m through n, the entire array would be sorted. Minimize n - m (that is, find the smallest
//        such sequence).
//        EXAMPLE
//        lnput:1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
//        Output: (3, 9)

public class Question16 {

    public Question16() {
        int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        find(arr);
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
