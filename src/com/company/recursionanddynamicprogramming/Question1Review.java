package com.company.recursionanddynamicprogramming;

//    8.1 Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
//        steps at a time. Implement a method to count how many possible ways the child can run up the
//        stairs.

public class Question1Review {

    private int count1 = 0;
    private int count2 = 0;

    public Question1Review() {
        int n = 5;

        System.out.println("ways: " + tripleStep(n, 0) + " with count: " + count1);
        System.out.println("ways: " + tripleStepWithMemo(n, 0, new int[n + 1]) + " with count: " + count2);
    }

    private int tripleStep(int n, int curr) {
        count1++;
        if (n == curr) return 1;

        int diff = n - curr;

        int ways = 0;
        if (diff >= 1)
            ways += tripleStep(n, curr + 1);

        if (diff >= 2)
            ways += tripleStep(n, curr + 2);

        if (diff >= 3)
            ways += tripleStep(n, curr + 3);

        return ways;
    }

    private int tripleStepWithMemo(int n, int curr, int[] memo) {
        count2++;
        if (n == curr) return 1;

        if (memo[curr] == 0) {

            int diff = n - curr;

            int ways = 0;

            if (diff >= 1)
                ways += tripleStepWithMemo(n, curr + 1, memo);

            if (diff >= 2)
                ways += tripleStepWithMemo(n, curr + 2, memo);

            if (diff >= 3)
                ways += tripleStepWithMemo(n, curr + 3, memo);

            memo[curr] = ways;
        }
        return memo[curr];
    }
}
