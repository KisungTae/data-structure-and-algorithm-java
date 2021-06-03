package com.company.recursionanddynamicprogramming;

import java.util.Arrays;

public class Question2Review {

    public Question2Review() {
        int r = 8;
        int c = 5;

        boolean[][] grid = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 4 && j == 4) continue;
//                if (i == 2 && j == 3) continue;
//                if (i == 2 && j == 2) continue;
//                if (i == 2 && j == 1) continue;
//                if (i == 2 && j == 0) continue;

                grid[i][j] = true;
            }
        }

        for (boolean[] row : grid) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("found: " + move(grid, 0, 0));

        for (boolean[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }


    private boolean move(boolean[][] grid, int r, int c) {
        if (r >= grid.length) return false;
        if (c >= grid[0].length) return false;
        if (r == grid.length - 1 && c == grid[0].length - 1) return true;
        if (!grid[r][c]) return false;
        System.out.println("r=" + r + " c=" + c);

        boolean found = move(grid, r, c + 1);
        if (!found) {
            found = move(grid, r + 1, c);
            if (!found)
                grid[r][c] = false;
        }

        return found;
    }


}
