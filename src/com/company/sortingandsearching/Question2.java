package com.company.sortingandsearching;

//  Group Anagrams: Write a method to sort an array of strings so that all the anagrams are next to
//                  each other.

// 9:00

import java.util.*;

public class Question2 {
    public Question2() {
        String[] arr = {"ab c", "de ds", "sd ed", "a12k a", "dd es", "b ca", "ca b", "k12a a"};
        group(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void group(String[] arr) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : arr) {
            char[] charArr = str.replace(" ", "").toCharArray();
            Arrays.sort(charArr);
            String sorted = Arrays.toString(charArr);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                map.put(sorted, arrayList);
            }
        }

        int arrIndex = 0;
        for (Map.Entry<String, ArrayList<String>> entrySet : map.entrySet()) {
            for (String anagram : entrySet.getValue()) {
                arr[arrIndex] = anagram;
                arrIndex++;
            }
        }
    }
}
