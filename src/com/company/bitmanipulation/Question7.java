package com.company.bitmanipulation;

//Pairwise Swap: Write a program to swap odd and even bits in an integer with as few instructions as
//        possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).

public class Question7 {
    public Question7() {
        int input = 0b1011;

        int a = input;
        int b = input;

        int evenMask = 0b10101010101010101010101010101010;
        int oddMask = 0b01010101010101010101010101010101;

        a >>>= 1;
        a &= oddMask;

        b <<= 1;
        b &= evenMask;

        int swap = a | b;
        System.out.println(Integer.toBinaryString(swap));

    }
}
