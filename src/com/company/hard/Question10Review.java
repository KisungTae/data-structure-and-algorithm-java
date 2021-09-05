package com.company.hard;

//Majority Element: A majority element is an element that makes up more than half of the items in
//        an array. Given a positive integers array, find the majority element. If there is no majority element,
//        return-1. Do this inO(N) time and 0(1) space.
//        EXAMPLE
//        Input:
//        Output:
//        1 2 5 9 5 9 5 5 5
//        5


import java.util.Arrays;

public class Question10Review {
    public Question10Review() {
        int[] arr = {1, 2, 55, 9, 55, 9, 55, 55, 55};
        System.out.println("majority: " + findMajority(arr));
        System.out.println("majority: " + answer(arr));
    }

    private int answer(int[] arr) {
        int candidate = candidate(arr);
        int count = 0;
        for (int num : arr) {
            if (num == candidate) count++;
        }
        if (count > (arr.length / 2)) return candidate;
        else return -1;
    }

    private int candidate(int[] arr) {
        int majority = 0;
        int count = 0;
        for (int num : arr) {
            if (count == 0) {
                majority = num;
            }
            if (majority == num) {
                count++;
            } else {
                count--;
            }
        }

        return majority;
    }

    private int findMajority(int[] arr) {
        int max = maxIn(arr);
        int length = String.valueOf(max).length();
        int place = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int majorityDigit = majorityDigit(arr, place);
            if (majorityDigit == -1) return -1;
            else {
                stringBuilder.insert(0, majorityDigit);
            }
            place *= 10;
        }
        String majority = stringBuilder.toString();
        for (int num : arr) {
            String numString = String.valueOf(num);
            if (majority.equals(numString)) return Integer.parseInt(numString);
        }
        return -1;
    }

    private int maxIn(int[] arr) {
        int max = 0;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int majorityDigit(int[] arr, int place) {
        int range = 10;
        int[] frequency = new int[range];

        for (int num : arr) {
            int digit = (num / place) % range;
            frequency[digit]++;
        }
        int half = arr.length / 2;
        for (int i = 0; i < range; i++) {
            if (frequency[i] > half) return i;
        }
        return -1;
    }
}
