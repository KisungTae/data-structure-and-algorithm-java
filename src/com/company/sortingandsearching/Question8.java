package com.company.sortingandsearching;

//Find Duplicates: You have an array with all the numbers from 1 to N, where N is at most 32,000. The
//        array may have duplicate entries and you do not know what N is. With only 4 kilobytes of memory
//        available, how would you print all duplicate elements in the array?

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Question8 {

    public Question8() {
        int n = 10;
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < random.nextInt(4); j++) {
                numbers.add(i);
            }
        }
        Collections.shuffle(numbers);
        printDup(numbers.stream().mapToInt(i -> i).toArray());
    }




























    private void printDup(int[] arr) {
        byte[] flags = new byte[4000];

        for (int num : arr) {
            int quotient = num / 8;
            int remainder = num % 8;

            byte flag = flags[quotient];
            byte mask = (byte) (1 << remainder);

            if ((flag & mask) > 0)
                System.out.println("dup: " + (quotient * 8 + remainder));

            flag |= mask;
            flags[quotient] = flag;


        }

        System.out.println(Arrays.toString(arr));
    }
}
