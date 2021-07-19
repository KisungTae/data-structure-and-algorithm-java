package com.company.recursionanddynamicprogramming;

//    8.1 Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
//        steps at a time. Implement a method to count how many possible ways the child can run up the
//        stairs.

//the runtime of this algorithm is exponential (roughly O ( 3") )

public class Question1Review {

    private int count1 = 0;
    private int count2 = 0;

    public Question1Review() {
        int n = 4;

//        System.out.println("ways: " + tripleStep(n, 0) + " with count: " + count1);
//        System.out.println("ways: " + tripleStepWithMemo(n, 0, new int[n + 1]) + " with count: " + count2);

        System.out.println("count: " + count(n, 0));
        System.out.println("count: " + countWithMemo(n, new int[n + 1]));

    }

    private int count(int n, int curr) {
        if (curr > n) return 0;
        if (curr == n) return 1;

        int one = count(n, curr + 1);
        int two = count(n, curr + 2);
        int three = count(n, curr + 3);

        return one + two + three;
    }

    private int countWithMemo(int curr, int[] memo) {
        if (curr < 0) return 0;
        if (curr == 0) return 1;
        if (memo[curr] > 0) return memo[curr];

        int one = countWithMemo(curr - 1, memo);
        int two = countWithMemo(curr - 2, memo);
        int three = countWithMemo(curr - 3, memo);
        int result = one + two + three;
        memo[curr] = result;
        return result;
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
