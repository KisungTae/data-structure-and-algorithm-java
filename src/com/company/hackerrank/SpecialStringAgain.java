package com.company.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;

public class SpecialStringAgain {


    static class Point {
        public char ch;
        public int count;

        public Point(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override public String toString() {
            return "Point{" +
                   "ch=" + ch +
                   ", count=" + count +
                   '}';
        }
    }

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        ArrayList<Point> points = new ArrayList<>();

        char current = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (current == ch) {
                count++;
            } else {
                points.add(new Point(current, count));
                current = ch;
                count = 1;
            }
        }
        points.add(new Point(current, count));

        count = 0;
        if (points.size() > 2) {

            count += addup(points.get(0).count);

            for (int i = 1; i < points.size() - 1; i++) {
                Point prev = points.get(i - 1);
                Point curr = points.get(i);
                Point next = points.get(i + 1);


                count += addup(curr.count);

                if (prev.ch == next.ch && curr.count == 1) {
                    int min = Math.min(prev.count, next.count);
                    count += min;
                }
            }

            count += addup(points.get(points.size() - 1).count);

        } else if (points.size() == 1) {
            Point curr = points.get(0);
            count += addup(curr.count);
        } else if (points.size() == 2) {
            Point prev = points.get(0);
            count += addup(prev.count);
            Point next = points.get(1);
            count += addup(next.count);
        }


        System.out.println(points);

        return count;

    }

    static int addup(int num) {
        return (num * (num + 1)) / 2;
    }

}

class Point {
    public char ch;
    public int count;

    @Override public String toString() {
        return "Point{" +
               "ch=" + ch +
               ", count=" + count +
               '}';
    }
}
