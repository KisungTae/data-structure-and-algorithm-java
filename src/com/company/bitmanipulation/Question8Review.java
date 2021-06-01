package com.company.bitmanipulation;

public class Question8Review {

    public Question8Review() {
        int width = 32;
        int col = width / 8;
        int height = 3;
        byte[] screen = new byte[height * col];
        draw(screen, width, 33, 60, 1);

        for (int i = 0; i < height * col; i += col) {
            for (int j = i; j < i + col; j++) {
                System.out.print(getByteString(screen[j]));
            }
            System.out.println("");
        }
    }

    private void draw(byte[] screen, int width, int x1, int x2, int y) {
        byte startColumn = (byte) (x1 / 8);
        byte startIndex = (byte) (x1 % 8);
        byte startMask = (byte) (0xFF >>> startIndex);
        byte startMasked = (byte) (screen[startColumn] | startMask);

        byte endColumn = (byte) (x2 / 8);
        byte endIndex = (byte) (x2 % 8);
        byte endMask = (byte) (0xFF << (7 - endIndex));
        byte endMasked = (byte) (screen[endColumn] | endMask);

        if (startColumn == endColumn) {
            screen[startColumn] = (byte) (startMasked & endMasked);
        } else {
            screen[startColumn] = startMasked;
            screen[endColumn] = endMasked;

            int start = startColumn + 1;
            int end = endColumn - 1;

            for (int i = start; i <= end; i++) {
                screen[i] = (byte) 0xFF;
            }
        }
    }

    private String getByteString(byte b) {
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }
}
