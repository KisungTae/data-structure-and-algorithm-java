package com.company.sortingandsearching;

import java.util.Arrays;


// https://www.baeldung.com/java-radix-sort

public class RadixSort {

    public RadixSort() {
        int[] arr = {387, 468, 134, 123, 68, 221, 769, 37, 7};


        int max = findMaximum(arr);
        int digitCount = String.valueOf(max).length();
        int placeValue = 1;

        System.out.println(Arrays.toString(arr));
        while (digitCount-- > 0) {
            sort(arr, placeValue);
            placeValue *= 10;
        }
        System.out.println(Arrays.toString(arr));
    }

    private int findMaximum(int[] arr) {
        return 769;
    }

    private void sort(int[] arr, int placeValue) {
        int range = 10;

        int[] frequency = new int[range];
        int[] results = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int digit = (arr[i] / placeValue) % range;
            frequency[digit]++;
        }
        System.out.println(Arrays.toString(frequency));
        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }

        System.out.println(Arrays.toString(frequency));

        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / placeValue) % range;
            results[frequency[digit] - 1] = arr[i];
            frequency[digit]--;
        }

//        for (int i = 0; i < arr.length; i++) {
//            int digit = (arr[i] / placeValue) % range;
//            results[frequency[digit] - 1] = arr[i];
//            frequency[digit]--;
//        }

        System.out.println(Arrays.toString(results));
        System.arraycopy(results, 0, arr, 0, arr.length);

    }


}
