package com.company.moderate;

//Smallest Difference: Given two arrays of integers, compute the pair of values (one value in each
//        array) with the smallest (non-negative) difference. Return the difference.
//        EXAMPLE
//        Input: {1, 3, 15, 11, 2}, {23, 127,235, 19, 8}
//        Output: 3. That is, the pair (11, 8).

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Question6 {

    public Question6() {
        int[] arrA = {1, 3, 15, 11, 2};
        int[] arrB = {23, 127,235, 19, 8};

        Arrays.sort(arrA);
        Arrays.sort(arrB);



        System.out.println(Arrays.toString(arrA));
        System.out.println(Arrays.toString(arrB));

        int indexA = 0;
        int indexB = 0;
        int min = Integer.MAX_VALUE;

        while (indexA < arrA.length && indexB < arrB.length) {
            int a = arrA[indexA];
            int b = arrB[indexB];

            int diff = Math.abs((a - b));
            min = Math.min(min, diff);

            if (a < b) indexA++;
            else if (a > b) indexB++;
            else {
                indexA++;
                indexB++;
            }
        }

        System.out.println("min: " + min);
    }
}
