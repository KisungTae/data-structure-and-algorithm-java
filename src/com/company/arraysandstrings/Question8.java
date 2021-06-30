package com.company.arraysandstrings;

//Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
//        column are set to 0.


import java.util.Arrays;
import java.util.Random;

public class Question8 {
    public Question8() {
//        int[][] matrix = new int[6][5];
//        Random random = new Random();
//        for (int[] row : matrix) {
//            for (int j = 0; j < row.length; j++) {
//                row[j] = random.nextInt(6);
//            }
//        }

        int[][] matrix = {
                {0, 3, 5, 0, 5},
                {3, 4, 2, 3, 4},
                {3, 5, 4, 1, 4},
                {2, 5, 1, 5, 5},
                {4, 1, 3, 5, 4},
                {0, 2, 5, 4, 1}
        };

        for (int[] row : matrix) System.out.println(Arrays.toString(row));
        System.out.println("=======================================");
        zero(matrix);
        for (int[] row : matrix) System.out.println(Arrays.toString(row));

    }

    private void zero(int[][] matrix) {
        boolean rowHasZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                rowHasZero = true;
                break;
            }
        }

        boolean colHasZero = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                colHasZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) zeroHorizontal(matrix, i);
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) zeroVertical(matrix, i);
        }

        if (rowHasZero) zeroVertical(matrix, 0);
        if (colHasZero) zeroHorizontal(matrix, 0);

    }

    private void zeroHorizontal(int[][] matrix, int index) {
        for (int i = 0; i < matrix[index].length; i++) {
            matrix[index][i] = 0;
        }
    }

    private void zeroVertical(int[][] matrix, int index) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][index] = 0;
        }
    }
}
