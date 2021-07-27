package com.company.recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class Question12Review {

//    Eight Queens: Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board
//    so that none of them share the same row, column, or diagonal. In this case, "diagonal" means all
//    diagonals, not just the two that bisect the board.

//  8:50
//  9:40

    public Question12Review() {
        int gridSize = 8;
        int[] columns = new int[gridSize];
        ArrayList<Integer[]> results = new ArrayList<>();
        place(gridSize, new int[gridSize], 0, results);
    }

    private void place(int gridSize, int[] columns, int row, ArrayList<Integer[]> results) {
        if (row == gridSize) {
            System.out.println(Arrays.toString(columns));
        }

        for (int col = 0; col < gridSize; col++) {
            if (check(columns, row, col, gridSize)) {
                columns[row] = col;
                place(gridSize, columns, row + 1, results);
            }
        }
    }

    private boolean check(int[] columns, int row1, int col1, int gridSize) {

        for (int row2 = 0; row2 <= row1; row2++) {
            int col2 = columns[row2];
            if (col1 == col2) return false;

            int rowDiff = Math.abs((row2 - row1));
            int colDiff = Math.abs((col2 - col1));

            if (rowDiff == colDiff) return false;
        }
        return true;
    }
}
