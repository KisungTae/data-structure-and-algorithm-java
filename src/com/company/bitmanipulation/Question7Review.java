package com.company.bitmanipulation;

public class Question7Review {

    public Question7Review() {
//        swap();
        swapAnswer();
    }

    public void swap() {
        int input = Integer.valueOf("10111", 2);
        int lastBit = input & 1;

        input >>= 1;

        if (lastBit > 0) {
            int count = 0;
            int mask = input;

            while (mask > 0) {
                count++;
                mask >>>= 1;
            }
            System.out.println(Integer.toBinaryString((1 << count)));
            input = input | (1 << count);
        }

        System.out.println("input: " + Integer.toBinaryString(input));
    }

    public void swapAnswer() {
        int d = 0xaaaaaaaa;
        int input = Integer.valueOf("10111", 2);
//        int oddMask = Integer.valueOf("101010101010101010101010101010", 2);
//        int evenMask = Integer.valueOf("1010101010101010101010101010101", 2);
//        101011
        int oddMask = 0xaaaaaaaa;
        int evenMask = 0x55555555;

        System.out.println("odd mask: " + Integer.toBinaryString(oddMask));
        System.out.println("eve mask: " + Integer.toBinaryString(evenMask));

        int oddMasked = (input & oddMask) >>> 1;
        System.out.println("masked: " + Integer.toBinaryString(oddMasked));
        int evenMasked = (input & evenMask) << 1;
        System.out.println("masked: " + Integer.toBinaryString(evenMasked));

        int swapped = oddMasked | evenMasked;
        System.out.println("swapped: " + Integer.toBinaryString(swapped));
    }
}
