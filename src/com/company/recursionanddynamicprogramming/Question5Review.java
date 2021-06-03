package com.company.recursionanddynamicprogramming;

public class Question5Review {

    public Question5Review() {
        int a = 7;
        int b = 15;
        System.out.println("multiply: " + multiply(a, b));
        System.out.println("answer  : " + a * b);

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
