package com.company.hackerrank;

import java.util.HashMap;

public class MakingAnagrams {
    public static int makeAnagram(String a, String b) {
        String longer = a.length() > b.length() ? a : b;
        String shorter = a.length() > b.length() ? b : a;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : shorter.toCharArray()) {
            Integer count = map.get(ch);
            count = count == null ? 1 : count + 1;
            map.put(ch, count);
        }

        int count = 0;
        for (char ch : longer.toCharArray()) {
            Integer charCount = map.get(ch);
            if (charCount != null && charCount > 0) {
                count++;
                charCount--;
                map.put(ch, charCount);
            }
        }

        return (a.length() - count)  + (b.length() - count);
    }
}
