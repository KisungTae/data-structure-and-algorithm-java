package com.company.arraysandstrings;

//Check Permutation: Given two strings, write a method to decide if one is a permutation of the
//        other.

import java.util.HashSet;
import java.util.Set;

public class Question2Review {
    public Question2Review() {
        String input1 = "abcd";
        String input2 = "bcda";
        System.out.println(input1 + " and " + input2 + " are permutation: " + isPermutation(input1, input2));
    }

    private boolean isPermutation(String input1, String input2) {
        Set<Character> characters = new HashSet<>();
        for (char ch : input1.toCharArray()) characters.add(ch);
        for (char ch : input2.toCharArray()) {
            if (!characters.contains(ch)) return false;
        }
        return true;
    }
}
