package com.company.recursionanddynamicprogramming;

//Paint Fill: Implement the "paint fill" function that one might see on many image editing programs.
//        That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
//        fill in the surrounding area until the color changes from the original color.

// 2:47

import java.util.Arrays;
import java.util.Random;

public class Question10 {

    public Question10() {
        int width = 10;
        int height = 6;
        int[][] screen = new int[height][width];

        Random random = new Random();
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[0].length; j++) {
                screen[i][j] = random.nextInt(4);
            }
        }

        for (int[] row : screen) {
            System.out.println(Arrays.toString(row));
        }
        int originalColor = screen[4][5];
        System.out.println("original color: " + originalColor + " new color: " + (originalColor + 1));
        paintFill(screen, 4, 5, originalColor, originalColor + 1);
        for (int[] row : screen) {
            System.out.println(Arrays.toString(row));
        }
    }

    private void paintFill(int[][] screen, int r, int c, int originalColor, int newColor) {

        if (r < 0 || c < 0 || r >= screen.length || c >= screen[0].length) return;

        if (screen[r][c] == originalColor)
            screen[r][c] = newColor;
        else return;

        paintFill(screen, r - 1, c, originalColor, newColor);
        paintFill(screen, r, c + 1, originalColor, newColor);
        paintFill(screen, r + 1, c, originalColor, newColor);
        paintFill(screen, r, c - 1, originalColor, newColor);
    }
}
