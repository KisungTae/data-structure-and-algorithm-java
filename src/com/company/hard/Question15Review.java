package com.company.hard;

//Longest Word: Given a list of words, write a program to find the longest word made of other words
//        in the list.
//        EXAMPLE
//        lnput:cat, banana, dog, nana, walk, walker, dogwalker
//        Output: dogwalker


import java.util.*;

public class Question15Review {
    public Question15Review() {
        String[] arr = {"cat", "banana", "dog", "nana", "ba", "walk", "walker", "dogwalker"};
        System.out.println("longest word: " + find(arr));
    }

    private String find(String[] arr) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, arr);
        Arrays.sort(arr, Collections.reverseOrder());

        for (String word : arr) {
            for (int j = 0; j < word.length() - 1; j++) {
                String left = word.substring(0, j + 1);
                String right = word.substring(j + 1);
                if (set.contains(left) && set.contains(right))
                    return word;
            }
        }
        return "None";
    }
}
