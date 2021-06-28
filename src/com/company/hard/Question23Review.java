package com.company.hard;


//Max Black Square: Imagine you have a square matrix, where each cell (pixel) is either black or white
//        Design an algorithm to find the maximum subsquare such that all four borders are filled with black
//        pixels.

//      9:41

import java.util.Arrays;
import java.util.Random;

public class Question23Review {
    public Question23Review() {

        boolean[][] matrix = new boolean[10][10];
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; i < matrix[0].length; i++) {
                matrix[i][j] = random.nextBoolean();
            }
        }

        for (boolean[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
