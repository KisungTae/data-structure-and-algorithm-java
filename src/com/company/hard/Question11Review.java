package com.company.hard;

//Word Distance: You have a large text file containing words. Given any two words, find the shortest
//        distance (in terms of number of words) between them in the file. If the operation will be repeated
//        many times for the same file (but different pairs of words), can you optimize your solution?


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class
Question11Review {

    public Question11Review() {

        String[] arr = {"this", "is", "the", "world", "hello", "make", "things", "easy", "world", "most", "popular", "world", "hello", "again"};

        Map<String, ArrayList<Integer>> dic = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            String key = arr[i];
            ArrayList<Integer> wordIndices = dic.get(key);
            if (wordIndices == null) wordIndices = new ArrayList<>();
            wordIndices.add(i);
            dic.put(key, wordIndices);
        }

        dic.forEach((key, value) -> System.out.println(key + ": " + value.toString()));

        String input1 = "hello";
        String input2 = "popular";

        ArrayList<Integer> input1Indices = dic.get(input1);
        ArrayList<Integer> input2Indices = dic.get(input2);

        if (input1Indices == null || input2Indices == null)
            System.out.println("no distance");
        else {
            int input1Index = 0;
            int input2Index = 0;
            int min = Integer.MAX_VALUE;
            while (input1Index < input1Indices.size() && input2Index < input2Indices.size()) {
                int input1Value = input1Indices.get(input1Index);
                int input2Value = input2Indices.get(input2Index);

                int diff = Math.abs((input1Value - input2Value));
                min = Math.min(diff, min);

                if (input1Value > input2Value) input2Index++;
                else input1Index++;
            }

            System.out.println("min distance: " + min);
        }

    }
}
