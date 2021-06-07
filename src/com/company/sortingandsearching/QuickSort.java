package com.company.sortingandsearching;

import java.util.Arrays;

// Best and average case: The best case occurs when the partition process always picks the middle element as pivot. (nLogn)
// worst case time complexity of QuickSort is O(n2)

public class QuickSort {

    public QuickSort() {
        int[] arr = {3, 2, 5, 4, 6, 3, 4, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

//    private void quickSort(int[] arr, int left, int right) {
//        if (left < right) {
//            int pivotIndex = partition(arr, left, right);
//            quickSort(arr, left, pivotIndex - 1);
//            quickSort(arr, pivotIndex + 1, right);
//        }
//    }

//    private int partition(int[] arr, int left, int right) {
//        int pivotIndex = (left + right) / 2;
//        int pivot = arr[pivotIndex];
//
//        while (left < right) {
//            while (arr[left] <= pivot) left++;
//            while (arr[right] > pivot) right--;
//
//            if (left < right && arr[left] > arr[right]) {
//                int larger = arr[left];
//                arr[left] = arr[right];
//                arr[right] = larger;
//            }
//        }
//        arr[pivotIndex] = arr[right];
//        arr[right] = pivot;
//        return right;
//    }

    private void quickSort(int[] arr, int left, int right) {
        int pivotIndex = partition(arr, left, right);

        if (pivotIndex - 1 > left)
            quickSort(arr, left, pivotIndex - 1);

        if (pivotIndex < right)
            quickSort(arr, pivotIndex, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];

        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;

            if (left <= right) {
                int larger = arr[left];
                arr[left] = arr[right];
                arr[right] = larger;
                left++;
                right--;
            }
        }
        return left;
    }
}
