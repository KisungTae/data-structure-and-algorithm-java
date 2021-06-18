package com.company.moderate;

//Sum Swap: Given two arrays of integers, find a pair of values (one value from each array) that you
//        can swap to give the two arrays the same sum.
//        EXAMPLE
//        Input: {4, 1, 2, 1, 1, 2} and {3, 6, 3, 3}
//        Output: {1, 3}


import java.util.HashSet;

public class Question21Review {
    public Question21Review() {
//        int[] arr1 = {4, 1, 2, 1, 1, 2};
//        int[] arr2 = {3, 6, 3, 3};

        int[] arr1 = {-3, -2};
        int[] arr2 = {-1, -1, -1};

        int arr1Sum = 0;
        int arr2Sum = 0;

        for (int num : arr1)
            arr1Sum += num;

        for (int num : arr2)
            arr2Sum += num;




        int[] bigger = arr1Sum > arr2Sum ? arr1 : arr2;
        int[] smaller = arr1Sum > arr2Sum ? arr2 : arr1;

        double mid = (Math.abs(arr1Sum) + Math.abs(arr2Sum)) / 2.0;
        //if fraction then no pairs

        int diff = (int) Math.abs(Math.max(mid, arr1Sum) - Math.min(mid, arr1Sum));

        HashSet<Integer> numbers = new HashSet<>();

        for (int num : smaller)
            numbers.add(num);

        for (int num : bigger) {
            int offset = num - diff;
            if (numbers.contains(offset)) {
                System.out.println(num + " | " + offset);
                break;
            }
        }

    }
}
