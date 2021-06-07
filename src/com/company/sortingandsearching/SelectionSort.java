package com.company.sortingandsearching;

import java.util.Arrays;

// Best, Worst and Average Case Time Complexity: O(n^2)
// The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.


public class SelectionSort {

    public SelectionSort() {
        int[] arr = {3,2,5,4,6,3,4,5};

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int min = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
        System.out.println(Arrays.toString(arr));
    }
}
