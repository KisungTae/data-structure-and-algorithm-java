package com.company.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (List<Integer> query : queries) {
            int operation = query.get(0);
            int element = query.get(1);

            if (operation == 1) {
                int elementCount = map.containsKey(element) ? map.get(element) : 0;

                addup(counts, elementCount, -1);

                elementCount++;
                addup(counts, elementCount, 1);

                map.put(element, elementCount);

            } else if (operation == 2) {
                int elementCount = map.containsKey(element) ? map.get(element) : 0;

                addup(counts, elementCount, -1);

                elementCount--;
                addup(counts, elementCount, 1);

                if (elementCount >= 0)
                    map.put(element, elementCount);

            } else {
                Integer countCount = counts.get(element);
                if (countCount == null || countCount <= 0) {
                    arr.add(0);
                    System.out.println(0);
                } else {
                    arr.add(1);
                    System.out.println(1);
                }
            }
        }

        return arr;
    }

    static void addup(HashMap<Integer, Integer> map, int element, int term) {
        int value = map.containsKey(element) ? map.get(element) : 0;
        value += term;
        if (value >= 0) {
            map.put(element, value);
        }
    }
}
