package com.company.hard;

//Random Set: Write a method to randomly generate a set of m integers from an array of size n. Each
//        element must have equal probability of being chosen.

// https://stackoverflow.com/questions/13755472/randomly-generate-a-set-of-m-integers-from-an-array-of-size-n


// 1:36

import java.util.Arrays;
import java.util.Random;

public class Question3ReviewAgain {
    public Question3ReviewAgain() {
        int n = 10;
        int m = 5;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int[] subset = new int[m];
//        subset(arr, subset);
        subsetAnswer(arr, subset);
        System.out.println(Arrays.toString(subset));
    }

    private void subsetAnswer(int[] arr, int[] subset) {
        for (int i = 0; i < subset.length; i++) {
            subset[i] = arr[i];
        }
        Random random = new Random();
        for (int i = subset.length; i < arr.length; i++) {
            int k = random.nextInt(i + 1);
            if (k < subset.length) {
                subset[k] = arr[i];
            }
        }
    }

    private void subset(int[] arr, int[] subset) {
        int index = 0;
        Random random = new Random();
        for (int i = arr.length; i > (arr.length - subset.length); i--) {
            int k = random.nextInt(i);
            int temp = arr[k];
            subset[index] = temp;
            arr[k] = arr[i - 1];
            arr[i - 1] = temp;
            index++;
        }
    }
}
