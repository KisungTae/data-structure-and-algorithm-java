package com.company.hard;

// Smallest K: Design an algorithm to find the smallest K numbers in an array.

import java.util.Arrays;
import java.util.Random;

public class Question14Review {

    public int size = 0;

    public Question14Review() {
        int n = 10;
        int k = 3;

        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
        }


        arr[++size] = -90;
        System.out.println("size: " + size);
        System.out.println(Arrays.toString(arr));

    }

    class MaxHeap {

    }
}
