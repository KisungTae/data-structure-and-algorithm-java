package com.company.bitmanipulation;

//Conversion: Write a function to determine the number of bits you would need to flip to convert
//        integer A to integer B.
//        EXAMPLE
//        Input: 29 (or: 11101), 15 (or: 01111)
//        Output: 2


public class Question6Review {
    public Question6Review() {
        int a = 0b11101;
        int b = 0b01111;

        int xor = a ^ b;
        int count = 0;
        while (xor > 0) {
            if ((xor & 1) > 0)
                count++;
            xor >>>= 1;
        }
        System.out.println("count: " + count);
    }
}
