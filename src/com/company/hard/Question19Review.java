package com.company.hard;

//Missing Two: You are given an array with all the numbers from 1 to N appearing exactly once,
//        except for one number that is missing. How can you find the missing number in O(N) time and
//        0( 1) space? What if there were two numbers missing?

// 3:08


import java.util.Arrays;

public class Question19Review {
    public Question19Review() {
        int n = 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 5) continue;
            arr[i] = i;
        }

        System.out.println(Arrays.toString(arr));
    }
}
