package com.company.hard;

//Letters and Numbers: Given an array filled with letters and numbers, find the longest subarray with
//        an equal number of letters and numbers.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question5Review {

    public Question5Review() {
        char[] arr = {'a', 'b', '1', 'd', 'e', '2', '1', '3', 'a', 'b', 'c', 'd'};
        find(arr);
    }

    private void find(char[] arr) {
        ArrayList<Info> infos = new ArrayList<>();
        int charCount = 0;
        int digitCount = 0;
        for (char ch : arr) {
            if (Character.isDigit(ch))
                digitCount++;
            else charCount++;
            infos.add(new Info(charCount, digitCount));
        }

        HashMap<Integer, Info> hashMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for (Info curr : infos) {
            int diff = curr.numOfChar - curr.numOfDigit;
            if (hashMap.containsKey(diff)) {
                Info before = hashMap.get(diff);
                int count = (curr.numOfChar + curr.numOfDigit) - (before.numOfDigit + before.numOfChar);
                if (count > max) {
                    max = count;
                    start = infos.indexOf(before);
                    end = infos.indexOf(curr) - 1;
                }
            } else {
                hashMap.put(diff, curr);
            }
        }
        System.out.println("start: " + start + " | end: " + end);
    }

    class Info {
        public int numOfChar;
        public int numOfDigit;

        public Info(int numOfChar, int numOfDigit) {
            this.numOfChar = numOfChar;
            this.numOfDigit = numOfDigit;
        }
    }
}
