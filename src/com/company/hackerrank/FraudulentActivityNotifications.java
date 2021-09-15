package com.company.hackerrank;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FraudulentActivityNotifications {
    public static int activityNotifications(List<Integer> expenditure, int d) {

        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        int count = 0;

        for (int i = 0; i < expenditure.size(); i++) {
            if (i >= d) {
                double doubleMedian = getMedian(max, min) * 2.0;
                if (expenditure.get(i) >= doubleMedian) {
                    count++;
                }
                subtract(max, min, expenditure.get(i - d));
                add(max, min, expenditure.get(i));
            } else {
                add(max, min, expenditure.get(i));
            }
        }
        return count;
    }

    public static void subtract(PriorityQueue<Integer> max, PriorityQueue<Integer> min, int element) {
        if (max.peek() != null && element <= max.peek()) {
            max.remove(element);
        } else {
            min.remove(element);
        }
    }

    public static double getMedian(PriorityQueue<Integer> max, PriorityQueue<Integer> min) {
        if (max.size() == min.size()) {
            double maxPeek = (double) max.peek();
            double minPeek = (double) min.peek();
            return (maxPeek + minPeek) / 2.0;
        } else {
            return (double) max.peek();
        }
    }

    public static void add(PriorityQueue<Integer> max, PriorityQueue<Integer> min, int element) {
        if (max.size() == min.size() || max.size() < min.size()) {
            if (min.peek() != null && element > min.peek()) {
                max.offer(min.poll());
                min.offer(element);
            } else {
                max.offer(element);
            }
        } else {
            if (max.peek() != null && element < max.peek()) {
                min.offer(max.poll());
                max.offer(element);
            } else {
                min.offer(element);
            }
        }
    }
}
