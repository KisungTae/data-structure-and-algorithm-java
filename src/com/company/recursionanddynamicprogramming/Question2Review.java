package com.company.recursionanddynamicprogramming;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question2Review {

    public Question2Review() {
        int r = 8;
        int c = 5;

        int[][] grid = new int[r][c];


        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 4 && j == 4) continue;
                if (i == 2 && j == 3) continue;
                if (i == 2 && j == 2) continue;
                if (i == 2 && j == 1) continue;
//                if (i == 2 && j == 0) continue;
                grid[i][j] = 1;
            }
        }
        printGrid(grid);
        ArrayList<Point> path = new ArrayList<>();
        Set<Point> failedPoints = new HashSet<>();
        boolean found = move(grid, 0, 0, path, failedPoints);
        System.out.println("found: " + found);
        printPath(grid, path);
        printGrid(grid);
    }

    private void printPath(int[][] grid, ArrayList<Point> path) {
        for (Point point : path) {
            grid[point.y][point.x] = 5;
        }
    }

    private void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    private boolean move(int[][] grid, int r, int c, ArrayList<Point> path, Set<Point> failedPoints) {
        if (r >= grid.length) return false;
        if (c >= grid[0].length) return false;
        if (grid[r][c] == 0) return false;
        if (failedPoints.contains(new Point(c, r))) return false;
        if (r == grid.length - 1 && c == grid[0].length - 1) return true;

        boolean found = move(grid, r, c + 1, path, failedPoints);
        if (found) {
            path.add(new Point(c, r));
            return true;
        }

        found = move(grid, r + 1, c, path, failedPoints);
        if (found) {
            path.add(new Point(c, r));
        } else {
            grid[r][c] = 9;
            failedPoints.add(new Point(c, r));
        }
        return found;
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
