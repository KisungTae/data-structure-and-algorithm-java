package com.company.arraysandstrings;

//Palindrome Permutation: Given a string, write a function to check if it is a permutation of
//        a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
//        permutation is a rearrangement of letters. The palindrome does not need to be limited to just
//        dictionary words.
//        EXAMPLE
//        Input: Tact Coa
//        Output: True (permutations: "taco cat'; "atc o eta·; etc.)


import java.util.HashMap;
import java.util.Map;

public class Question4 {
    public Question4() {
        String input = "aa bb";
        System.out.println(input + " is panlindrome: " + isPalindrome(input));
    }

    private boolean isPalindrome(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : input.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) count = 1;
            else count++;
            map.put(Character.toLowerCase(ch), count);
        }

        boolean odd = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                if (odd) return false;
                else odd = true;
            }
        }
        return true;
    }
}
