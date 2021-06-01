package com.company.bitmanipulation;

public class Question6Review {

    public Question6Review() {
        convert();
    }

    public void convert() {
        int a = Integer.valueOf("1111101", 2);
        int b = Integer.valueOf("01111", 2);

        int xor = a ^ b;
        System.out.println(Integer.toBinaryString(xor));
        int count = 0;
        while (xor > 0) {
            if ((xor & 1) == 1) count++;
            xor >>>= 1;
        }

        System.out.println(count);
    }
}
