package com.company.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class SherlockandtheValidString {

    public static String isValid(String s) {
        // Write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Integer count = map.get(ch);
            count = count == null ? 1 : count + 1;
            map.put(ch, count);
        }

        HashMap<Integer, Integer> counts = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer count = counts.get(entry.getValue());
            count = count == null ? 1 : count + 1;
            counts.put(entry.getValue(), count);
        }

        if (counts.size() > 2) return "NO";
        if (counts.size() == 1) return "YES";

        int index = 0;
        Map.Entry<Integer, Integer> first = null;
        Map.Entry<Integer, Integer> second = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (index == 0) first = entry;
            if (index > 0) second = entry;
            index++;
        }

        if (first.getKey() == 1 && first.getValue() == 1) return "YES";
        if (second.getKey() == 1 && second.getValue() == 1) return "YES";

        int keyDiff = Math.abs((first.getKey() - second.getKey()));
        if (keyDiff <= 1) {
            int biggerValue = first.getKey() > second.getKey() ? first.getValue() : second.getValue();

            if (biggerValue == 1) return "YES";
            else return "NO";
        } else {
            return "NO";
        }
    }

}
