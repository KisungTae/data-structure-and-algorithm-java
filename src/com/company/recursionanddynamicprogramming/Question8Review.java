package com.company.recursionanddynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Question8Review {
    public Question8Review() {
        String str = "aabb";
//        permutation("", str);
        permutationDup(str);
    }


    private void permutationDup(String str) {
        Map<Character, Integer> map = buildFreq(str);
        printPer(map, "", str.length());
    }

    private void printPer(Map<Character, Integer> map, String prefix, int index) {
        if (index == 0) {
            System.out.println(prefix);
            return;
        }

        for (Character key: map.keySet()) {
            int count = map.get(key);
            if (count > 0) {
                map.put(key, count - 1);
                printPer(map, prefix + key, index - 1);
                map.put(key, count);
            }
        }
    }

    private Map<Character, Integer> buildFreq(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                count++;
                map.put(ch, count);
            } else map.put(ch, 1);
        }
        return map;
    }

    private void permutation(String prefix, String remainder) {
        if (remainder.isEmpty()) System.out.println(prefix);

        for (int i = 0; i < remainder.length(); i++) {
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1);

            char mid = remainder.charAt(i);
            permutation(prefix + mid, before + after);
        }
    }
}
