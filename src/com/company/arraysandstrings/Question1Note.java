package com.company.arraysandstrings;

// Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
//        cannot use additional data structures?

// Note
// ASCII uses 7 bits to represent 128 characters and 1 bit for parity
// Extended ASCII uses 8 bit for 256 characters

public class Question1Note {
    public Question1Note() {
        String input = "ab123";
        System.out.println(input + " is unique: " + isUnique(input));
    }

    private boolean isUnique(String input) {
        boolean[] flag = new boolean[128];

        for (char ch : input.toCharArray()) {
            if (flag[ch]) return false;
            else flag[ch] = true;
        }
        return true;
    }
}
