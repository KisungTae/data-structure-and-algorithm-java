package com.company.sortingandsearching;

import java.util.Arrays;

// Worst and Average Case Time Complexity: O(n^2). Worst case occurs when array is reverse sorted.
// Best Case Time Complexity: O(n). Best case occurs when array is already sorted.

public class BubbleSort {

    public BubbleSort() {
        int[] arr = {1,3,2,5,4,6,3,4,5};
        boolean ordered = true;

        for (int i = 0; i < arr.length - 1; i++) {
            ordered = true;
            for (int j = 0; j < arr.length - 1; j++) {
                int prev = arr[j];
                int next = arr[j + 1];

                if (prev > next) {
                    arr[j] = next;
                    arr[j + 1] = prev;
                    ordered = false;
                }
            }
            if (ordered) break;
        }
        System.out.println(Arrays.toString(arr));
    }
}
