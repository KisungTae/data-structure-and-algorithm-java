package com.company.moderate;

//Word Frequencies: Design a method to find the frequency of occurrences of any given word in a
//        book. What if we were running this algorithm multiple times?


import java.util.HashMap;
import java.util.Map;

public class Question2 {

    public Question2() {
        String book = "this is a book about something. this is just a text to test";
        Map<String, Integer> dic = new HashMap<>();
        generateDic(book, dic);
        String word = "this";
        System.out.println(word + " frequency is " + dic.get(word));
    }

    private void generateDic(String book, Map<String, Integer> dic) {
        String[] split = book.split(" ");
        for (String word : split) {
            Integer freq = dic.get(word);
            if (freq == null) freq = 0;
            freq++;
            dic.put(word, freq);
        }
    }
}
