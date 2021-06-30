package com.company.arraysandstrings;

//Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
//        bytes, write a method to rotate the image by 90 degrees. Can you do this in place?


import java.util.Arrays;

public class Question7Review {
    public Question7Review() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        rotate(matrix);
        for (int[] row : matrix) System.out.println(Arrays.toString(row));
    }

    private void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int step = matrix.length - (i * 2 + 1);
            int end = matrix.length - i - 1;
            for (int j = i; j < i + step; j++) {
                rotateInPlace(matrix, i, j, i, end, step);
            }
        }
    }

    private void rotateInPlace(int[][] matrix, int row, int col, int start, int end, int step) {
        // +, +
        int before = matrix[row][col];
        row += (step - (end - col));
        col = end;
        int curr = matrix[row][col];
        matrix[row][col] = before;
        before = curr;

        // +, -
        col -= (step - (end - row));
        row = end;
        curr = matrix[row][col];
        matrix[row][col] = before;
        before = curr;

        // -, -
        row -= (step - (col - start));
        col = start;
        curr = matrix[row][col];
        matrix[row][col] = before;
        before = curr;

        // -, +
        col += (step - (row - start));
        row = start;
        curr = matrix[row][col];
        matrix[row][col] = before;
        before = curr;
    }
}
