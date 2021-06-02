package com.company.recursionanddynamicprogramming;

public class Fibonacci {

    public Fibonacci() {
        int n = 6;
//        System.out.println(n + "th Fibonacci: " + generate(n));
//        System.out.println(n + "th Fibonacci: " + generateWithMemo(n, new int[n + 1]));
        System.out.println(n + "th Fibonacci: " + generateIteratively(n));
    }

    private int generate(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return generate(n - 1) + generate(n - 2);
    }

    private int generateWithMemo(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] == 0) {
            memo[n] = generateWithMemo(n - 1, memo) + generateWithMemo(n - 2, memo);
        }
        return memo[n];
    }

    private int generateIteratively(int n) {
        int a = 0;
        int b = 1;

        for (int i = 2; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b + a;
    }
}
