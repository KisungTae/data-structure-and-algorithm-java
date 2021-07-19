package com.company.bitmanipulation;

public class Question1 {
    public Question1() {
        int n = 0b10000000000;
        int m = 0b10011;
        int i = 2;
        int j = 6;

        int left = -1 << (j + 1);
        int right = (1 << i) - 1;
        int mask = left | right;


        int x = (n & mask) | (m << i);
        System.out.println(Integer.toBinaryString(x));
//        System.out.println(Integer.toBinaryString(right));
    }
}
