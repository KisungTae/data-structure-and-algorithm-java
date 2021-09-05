package com.company.moderate;

//Pairs with Sum: Design an algorithm to find all pairs of integers within an array which sum to a
//        specified value.

import java.util.*;

// 8:40

public class Question24Review {

    public Question24Review() {
        int size = 10;
//        int[] arr = new int[size];
        int[] arr = {1, 3, -3, 7};
//        Random random = new Random();
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = random.nextInt(size);
//        }
        System.out.println(Arrays.toString(arr));
        find(arr, 4);
    }

    private void find(int[] arr, int sum) {
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        for (int num : arr) {
            if (numberMap.containsKey(num)) {
                int count = numberMap.get(num);
                count++;
                numberMap.put(num, count);
            } else {
                numberMap.put(num, 1);
            }
        }

        ArrayList<Pair> pairs = new ArrayList<>();

        for (int num : arr) {
            Integer numCount = numberMap.get(num);
            if (numCount != null && numCount > 0) {
                int diff = sum - num;
                Integer diffCount = numberMap.get(diff);
                if (diffCount != null && diffCount > 0) {
                    pairs.add(new Pair(num, diff));
                    numCount--;
                    diffCount--;
                    numberMap.put(num, numCount);
                    numberMap.put(diff, diffCount);
                }
            }
        }

        System.out.println(pairs);
    }

    class Pair {
        public int a;
        public int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override public String toString() {
            return "Pair{" +
                   "a=" + a +
                   ", b=" + b +
                   '}';
        }
    }
}
