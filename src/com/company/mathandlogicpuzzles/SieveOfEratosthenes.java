package com.company.mathandlogicpuzzles;

import java.util.Arrays;

public class SieveOfEratosthenes {

    public SieveOfEratosthenes() {
        generate(10);
    }

    private void generate(int max) {
        boolean[] flags = new boolean[max + 1];
        Arrays.fill(flags, true);

        int sqrt = (int) Math.sqrt(max);
        int prime = 2;

        while (prime <= sqrt) {
            crossOff(flags, prime);
            prime = nextPrime(flags, prime);
        }

        System.out.println(Arrays.toString(flags));
    }

    private void crossOff(boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    private int nextPrime(boolean[] flags, int currPrime) {
        int count = currPrime + 1;
        while (count < flags.length && !flags[count]) {
            count++;
        }
        return count;
    }



}
