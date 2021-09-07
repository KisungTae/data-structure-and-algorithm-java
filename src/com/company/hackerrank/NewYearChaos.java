package com.company.hackerrank;

import java.util.List;

public class NewYearChaos {

    public static void minimumBribes(List<Integer> q) {
        int count = 0;

        for (int i = 0; i < q.size() - 1; i++) {
            int num = q.get(i);
            if ((num - 1) - i > 2) {
                System.out.println("Too chaotic");
                return;
            }
        }

        for (int i = q.size() - 1; i > 0; i--) {
            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) count++;
            }
        }
        System.out.println(count);
    }
}
