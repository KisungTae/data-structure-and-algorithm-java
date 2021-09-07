package com.company.hackerrank;

import java.util.Arrays;
import java.util.HashMap;

public class SherlockandAnagrams {


    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                System.out.println(sub);
                char[] arr = sub.toCharArray();
                Arrays.sort(arr);
                String sorted = new String(arr);

                if (map.containsKey(sorted)) {
                    int frequency = map.get(sorted);
                    frequency++;
                    count += frequency;
                    map.put(sorted, frequency);
                } else {
                    map.put(sorted, 0);
                }
            }
        }
        return count;
    }
}
