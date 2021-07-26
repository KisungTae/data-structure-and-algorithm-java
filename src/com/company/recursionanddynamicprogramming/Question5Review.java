package com.company.recursionanddynamicprogramming;

public class Question5Review {

    public Question5Review() {
        int a = 7;
        int b = 15;
//        System.out.println("multiply: " + doMultiply(a, b, 1, a));
        System.out.println("multiply: " + doMultiple(a, b));
        System.out.println("answer  : " + a * b);

    }

    public int doMultiple(int a, int b) {
        if (b == 1) return a;
        if (b == 0) return 0;

        if ((b % 2) == 0) {
            int num = doMultiple(a, (b / 2));
            return num + num;
        } else {
            int num = doMultiple(a, (b / 2));
            return num + num + a;
        }
    }


    public int doMultiply(int a, int b, int count, int curr) {
        if (b == count) return curr;

        int newCount = count + count;
        if (newCount < b) return doMultiply(a, b, newCount, curr + curr);
        if (newCount > b) return doMultiply(a, b, count + 1, curr + a);
        else return curr + curr;
    }

































    private int multiply(int a, int b) {
        int smaller = Math.min(a, b);
        int bigger = Math.max(a, b);
        if (smaller == 0) return 0;
        return multiply(smaller, bigger, bigger, 1);
    }

    private int multiply(int s, int b, int curr, int count) {
        if (count == s) return curr;
        else if (count < s)
            return multiply(s, b, curr + curr, count + count);
        else {
            int sub = multiply(count - s, b, b, 1);
            return curr - sub;
        }
    }

}
