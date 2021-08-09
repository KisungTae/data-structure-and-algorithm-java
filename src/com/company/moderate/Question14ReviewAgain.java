package com.company.moderate;

//Best Line: Given a two-dimensional graph with points on it, find a line which passes the most
//        number of points.

import java.util.*;

public class Question14ReviewAgain {

    public Question14ReviewAgain() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(3, 3);
        Point point3 = new Point(2, 6);
        Point point4 = new Point(2, 4);
        Point point5 = new Point(3, 6);

        ArrayList<Point> points = new ArrayList<>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
        points.add(point5);

        HashSet<Line> lines = new HashSet<>();
        findLine(points, lines, 0);

        Line maxLine = null;
        int max = 0;
        int curr = 0;
        for (Line line : lines) {
            for (Point point : points) {
                if (line.contains(point)) curr++;
            }
            if (curr > max) {
                max = curr;
                maxLine = line;
            }
            curr = 0;
        }

        System.out.println(maxLine + " has " + max + " points");
//        for (Map.Entry<Line, Integer> entry : lines.entrySet()) {
//            System.out.println(entry.getKey() + " - " + entry.getValue());
//        }
    }

    private void findLine(ArrayList<Point> points, HashSet<Line> lines, int index) {
        if (index >= points.size()) return;
        findLine(points, lines, index + 1);

        Point start = points.get(index);

        for (int i = index + 1; i < points.size(); i++) {
            Point end = points.get(i);
            Line line = new Line(start, end);
            lines.add(line);
        }
    }

    class Line {
        private double slope;
        private double yInterceptor;

        public Line(Point point1, Point point2) {
            this.slope = (point2.y - point1.y) / (point2.x - point1.x);
            this.yInterceptor = point1.y - (this.slope * point1.x);
        }

        public boolean contains(Point point) {
            return point.y == (point.x * this.slope + yInterceptor);
        }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return Double.compare(line.slope, slope) == 0 &&
                   Double.compare(line.yInterceptor, yInterceptor) == 0;
        }

        @Override public int hashCode() {
            return Objects.hash(slope, yInterceptor);
        }

        @Override public String toString() {
            return "Line{" +
                   "slope=" + slope +
                   ", yInterceptor=" + yInterceptor +
                   '}';
        }
    }


    class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
