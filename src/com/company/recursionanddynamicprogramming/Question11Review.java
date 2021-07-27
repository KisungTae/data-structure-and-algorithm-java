package com.company.recursionanddynamicprogramming;

//Coins: Given an infinite number of quarters (25 cents), dimes (1 O cents), nickels (5 cents), and
//        pennies (1 cent), write code to calculate the number of ways of representing n cents.

// 7:42
// 3:23

public class Question11Review {
    public Question11Review() {
        int n = 22;
        int[] denoms = {25, 10, 5, 1};
        System.out.println("count: " + countAnswer(denoms, n, 0));
        int[][] memo = new int[n + 1][denoms.length];
        System.out.println("count: " + countWithMemo(denoms, n, 0, memo));
    }

    private int countWithMemo(int[] denoms, int n, int index, int[][] memo) {
        if (index >= denoms.length - 1) {
            return 1;
        }
        if (memo[n][index] > 0) return memo[n][index];

        int denom = denoms[index];
        int ways = 0;
        for (int i = 0; i * denom <= n; i++) {
            int remain = n - (i * denom);
            ways += countWithMemo(denoms, remain, index + 1, memo);
        }

        memo[n][index] = ways;
        return ways;
    }





























    private int countAnswer(int[] denoms, int n, int index) {
        if (index >= denoms.length - 1) return 1;

        int denom = denoms[index];
        int ways = 0;
        for (int i = 0; i * denom <= n; i++) {
            int remain = n - (i * denom);
            ways += countAnswer(denoms, remain, index + 1);
        }
        return ways;
    }




    private void count(int n, int cent) {
        if (n < 5 || cent == 1) {
            System.out.println("one way");
            return;
        }

        for (int i = n / cent; i >= 0; i--) {
            if ((n - cent) < 0) count(n, nextCent(cent));
            else count(n - cent, nextCent(cent));
        }
    }

    private int nextCent(int cent) {
        switch (cent) {
            case 25: return 10;
            case 10: return 5;
            case 5: return 1;
        }
        return 1;
    }


    private void represent(int current) {
        if (current < 0) return;
        if (current < 5) {
            System.out.println("current: " + current);
            return;
        }

        represent(current - 25);
        represent(current - 10);
        represent(current - 5);
        represent(0);
    }
}
