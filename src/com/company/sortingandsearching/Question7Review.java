package com.company.sortingandsearching;

//Missing Int: Given an input file with four billion non-negative integers, provide an algorithm to
//        generate an integer that is not contained in the file. Assume you have 1 GB of memory available for
//        this task.
//        FOLLOW UP
//        What if you have only 10 MB of memory? Assume that all the values are distinct and we now have
//        no more than one billion non-negative integers.


import java.util.Arrays;
import java.util.Random;

public class Question7Review {

    public Question7Review() {
        int[] file = new int[10];
        Random random = new Random();
        for (int i = 0; i < file.length; i++) {
            file[i] = random.nextInt(10);
        }

        System.out.println(Arrays.toString(file));
        System.out.println(generate(file));
    }

    private int generate(int[] file) {
        int flagSize = Integer.MAX_VALUE / 8;
        byte[] flags = new byte[flagSize];

        for (int number : file) {
            int quotient = number / 8;
            int remainder = number % 8;

            byte flag = flags[quotient];
            byte mask = (byte) (1 << (8 - remainder - 1));
            flag |= mask;
            flags[quotient] = flag;
        }

        for (int i = 0 ; i < flags.length; i++) {
            byte flag = flags[i];
            for (int j = 0; j < 8; j++) {
                byte mask = (byte) (1 << j);

                if ((flag & mask) == 0) {
                    return i * 8 + j;
                }
            }
        }

        return -1;
    }
}
