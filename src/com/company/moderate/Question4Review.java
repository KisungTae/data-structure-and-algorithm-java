package com.company.moderate;

//Tic Tac Win: Design an algorithm to figure out if someone has won a game of tic-tac-toe.

// 2:30

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Question4Review {

    public Question4Review() {
        int[][] matrix = new int[3][3];
        Scanner scanner = new Scanner(System.in);

        String input = "";
        int player = 1;
        while (!input.equals("end")) {
            System.out.println("player: " + player + " puts ");
            input = scanner.nextLine();
            String[] points = input.split(",");

            int x = Integer.parseInt(points[0].trim());
            int y = Integer.parseInt(points[1].trim());

            if (x < 0 || x >= matrix.length) continue;
            if (y < 0 || y >= matrix.length) continue;

            if (matrix[y][x] != 0) System.out.println("already taken");
            else {
                matrix[y][x] = player;

                if (player == 1) player = 2;
                else player = 1;
                printMatrix(matrix);
            }

        }

    }

    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private boolean check(boolean[][] matrix) {



        return false;
    }
}
