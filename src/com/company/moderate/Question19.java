package com.company.moderate;

//Pond Sizes: You have an integer matrix representing a plot of land, where the value at that location
//        represents the height above sea level. A value of zero indicates water. A pond is a region of
//        water connected vertically, horizontally, or diagonally. The size of the pond is the total number of
//        connected water cells. Write a method to compute the sizes of all ponds in the matrix.
//        EXAMPLE
//        Input:
//        0 2 1 0
//        0 1 0 1
//        1 1 0 1
//        0 1 0 1
//        Output: 2, 4, 1 (in any order)

// 8:27

import java.util.ArrayList;

public class Question19 {

    public Question19() {
        int[][] matrix = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };

        boolean[][] flags = new boolean[matrix.length][matrix[0].length];

        ArrayList<Integer> sums = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                int val = matrix[i][j];
                if (val == 0 && !flags[i][j])
                    sums.add(countPond(matrix, flags, i, j));
            }
        }
        System.out.println(sums.toString());
    }

    private int countPond(int[][] matrix, boolean[][] flags, int r, int c) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length) return 0;
        if (matrix[r][c] != 0 || flags[r][c]) return 0;

        flags[r][c] = true;
        int sum = 1;
        sum += countPond(matrix, flags, r - 1, c - 1);
        sum += countPond(matrix, flags, r - 1, c);
        sum += countPond(matrix, flags, r - 1, c + 1);
        sum += countPond(matrix, flags, r, c + 1);
        sum += countPond(matrix, flags, r + 1, c + 1);
        sum += countPond(matrix, flags, r + 1, c);
        sum += countPond(matrix, flags, r + 1, c - 1);
        sum += countPond(matrix, flags, r, c - 1);

        return sum;
    }
}
