package com.company.moderate;

//Pairs with Sum: Design an algorithm to find all pairs of integers within an array which sum to a
//        specified value.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Question24Review {

    public Question24Review() {
        int[] arr = new int[30];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(30);
        }
        System.out.println(Arrays.toString(arr));

        int sum = 10;

        HashSet<Integer> set = new HashSet<>();
        HashSet<String> pairs = new HashSet<>();

        int numOfHalf = 0;
        int half = sum / 2;
        boolean sumIsEven = (sum % 2) == 0;

        for (int num : arr) {
            set.add(num);
            if (num == half && sumIsEven) numOfHalf++;
        }


        for (int num : arr) {
            int diff = sum - num;
            if (set.contains(diff)) {
                String pair = num + "-" + diff;
                String reverse = diff + "-" + num;

                if (num == diff) {
                    if (sumIsEven && numOfHalf > 1)
                        pairs.add(pair);
                } else {
                    if (!pairs.contains(pair) || !pairs.contains(reverse))
                        pairs.add(pair);
                }


            }
        }
        System.out.println(pairs);
    }
}
