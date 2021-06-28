package com.company.hard;

//Max Submatrix: Given an NxN matrix of positive and negative integers, write code to find the
//        submatrix with the largest possible sum.

import java.util.Arrays;
import java.util.Random;

public class Question24Review {
    public Question24Review() {
        int[][] matrix = {
                {1, 2, -3, 4, 5},
                {8, -5, 3, 2, 4},
                {3, 1, -1, 3, 5},
                {3, 2, -2, -2, -3},
                {-5, 4, 1, 2, -5}
        };


        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
