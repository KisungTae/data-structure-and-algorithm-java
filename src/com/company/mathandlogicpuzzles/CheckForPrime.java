package com.company.mathandlogicpuzzles;

public class CheckForPrime {
    public CheckForPrime() {
        check();
    }

    private void check() {
        int n = 20;
        int root = (int) Math.sqrt(n);
        for (int i = 2; i <= root; i++) {
            if (n % i == 0)
                System.out.println("found divisible factor");
        }
    }
}
