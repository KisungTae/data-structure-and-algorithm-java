package com.company.bitmanipulation;

import java.util.Arrays;


//https://stackoverflow.com/questions/29682355/why-java-unsigned-bit-shifting-for-a-negative-byte-is-so-strange

public class Question8Review {
    public Question8Review() {
        byte[] screen = new byte[16];
        Arrays.fill(screen, (byte) 0);
        int width = 4;
        int x1 = 8;
        int x2 = 23;
        int y = 2;
        draw(screen, width, x1, x2, y);
        print(screen, width);
    }

    private void draw(byte[] screen, int width, int x1, int x2, int y) {
        int leftIndex = x1 / 8 + (width * y);
        int rightIndex = x2 / 8 + (width * y);

        if (leftIndex == rightIndex) {
            int leftOffset = x1 % 8;
            int rightOffset = x2 % 8;

            byte leftMask = rightShift((byte)-1, leftOffset);
            byte rightMask = (byte) (-1 << (7 - rightOffset));
            byte mask = (byte) (leftMask & rightMask);
            screen[leftIndex] |= mask;
        } else {
            int leftOffset = x1 % 8;
            byte leftMask = rightShift((byte)-1, leftOffset);
            screen[leftIndex] |= leftMask;

            x1 += (8 - leftOffset);
            int length = x2 - x1;

            for (int i = 0; i < (length / 8); i++) {
                leftIndex++;
                screen[leftIndex] = (byte) -1;
            }

            int rightOffset = x2 % 8;
            byte rightMask = (byte) (-1 << (7 - rightOffset));
            screen[rightIndex] |= rightMask;
        }
    }

    private byte rightShift(byte b, int count) {
        int temp = b & 0xFF;
        temp >>>= count;
        return (byte) temp;
    }

    private void print(byte[] screen, int width) {
        for (int i = 0; i < screen.length; i = i + width) {
            for (int j = i; j < i + width; j++) {
                System.out.print(printByte(screen[j]));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private String printByte(byte b) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            byte mask = (byte) (1 << i);
            byte bit = 1;
            if ((b & mask) == 0)
                bit = 0;

            String bitString = String.valueOf(bit);
            stringBuilder.append(bitString);
        }
        return stringBuilder.toString();
    }
}
