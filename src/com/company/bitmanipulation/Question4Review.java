package com.company.bitmanipulation;

//Next Number: Given a positive integer, print the next smallest and the next largest number that
//        have the same number of 1 bits in their binary representation.

public class Question4Review {
    public Question4Review() {
        int input = 0b101001;
//        System.out.println("bigger: " + Integer.toBinaryString(getBigger(input)));
        System.out.println("smaller: " + Integer.toBinaryString(getSmaller(input)));
    }

    private int getBigger(int input) {
        int count = 0;
        int oneIndex = 0;
        int inputCopy = input;
        while (inputCopy > 0) {
            if ((inputCopy & 1) == 0) {
                if (oneIndex > 0) break;
            } else {
                oneIndex = count;
            }
            count++;
            inputCopy >>= 1;
        }
        int zeroMask = ~(1 << oneIndex);
        int oneMask = 1 << count;

        input &= zeroMask;
        input |= oneMask;
        return input;
    }

    private int getSmaller(int input) {
        int count = 0;
        int zeroIndex = 0;
        int inputCopy = input;
        while (inputCopy > 0) {
            if ((inputCopy & 1) > 0) {
                if (zeroIndex > 0) break;
            } else {
                zeroIndex = count;
            }
            count++;
            inputCopy >>= 1;
        }
        System.out.println("zeroindex: " + zeroIndex + " | count: " + count);
        int zeroMask = 1 << zeroIndex;
        int oneMask = ~(1 << count);

        input |= zeroMask;
        input &= oneMask;
        return input;
    }
}
