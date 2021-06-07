package com.company.sortingandsearching;

import java.util.Arrays;

// Time complexity of Merge Sort is O(n*Log n) in all the 3 cases (worst, average and best)
// as merge sort always divides the array in two halves and takes linear time to merge two halves.

public class MergeSort {

    public MergeSort() {
        int[] arr = {3,2,5,4,6,3,4,5};
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void mergeSort(int[] arr, int[] buffer, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, buffer, left, mid - 1);
            mergeSort(arr, buffer, mid + 1, right);
            merge(arr, buffer, left, mid, right);
        }
    }

    private void merge(int[] arr, int[] buffer, int left, int mid, int right) {
        int itr = left;
        while (itr <= right) {
            buffer[itr] = arr[itr];
            itr++;
        }

        int leftStart = left;
        int current = left;
        int rightStart = mid + 1;

        while (leftStart <= mid && rightStart <= right) {
            if (arr[leftStart] <= arr[rightStart]) {
                arr[current] = arr[leftStart];
                leftStart++;
            } else {
                arr[current] = arr[rightStart];
                rightStart++;
            }
            current++;
        }

        while (leftStart <= mid) {
            arr[current] = arr[leftStart];
            leftStart++;
        }
    }

}
