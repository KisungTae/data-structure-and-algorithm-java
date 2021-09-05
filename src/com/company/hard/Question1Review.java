package com.company.hard;

//Add Without Plus: Write a function that adds two numbers. You should not use+ or any arithmetic
//        operators.


// 9:46

public class Question1Review {
    public Question1Review() {
        int a = 3;
        int b = -5;
        System.out.println("sum: " + add(a, b));
        System.out.println("sum: " + addAnswer(a, b));
    }

    private int addAnswer(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;

            a = sum;
            b = carry;
        }
        return a;
    }

    private int add(int a, int b) {
        int sum = 0;
        int carry = 0;
        int index = 0;

        while (index < 32) {
            int partialA = a & 1;
            int partialB = b & 1;

            int partialSum = carry + partialA + partialB;
            int quotient = partialSum / 2;
            int remainder = partialSum % 2;

            if (remainder > 0) {
                int sumMask = 1 << index;
                sum |= sumMask;
            }

            if (quotient > 0) {
                carry = 1;
            } else {
                carry = 0;
            }

            index++;
            a >>>= 1;
            b >>>= 1;
        }
        return sum;
    }
}
