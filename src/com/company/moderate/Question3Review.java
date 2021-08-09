package com.company.moderate;

//Intersection: Given two straight line segments (represented as a start point and an end point),
//        compute the point of intersection, if any.

import java.awt.*;

public class Question3Review {

    public Question3Review() {
        Point start1 = new Point(1, 2);
        Point end1 = new Point(5, 3);

        Point start2 = new Point(2, 1);
        Point end2 = new Point(4, 5);


        Point intersection = intersect(start1, end1, start2, end2);
        if (intersection == null) System.out.println("null");
        else System.out.println(intersection);
    }

    private Point intersect(Point start1, Point end1, Point start2, Point end2) {
        if (start1.x > end1.x) swap(start1, end1);
        if (start2.x > end2.x) swap(start2, end2);
        if (start1.x > start2.x) {
            swap(start1, start2);
            swap(end1, end2);
        }

        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        if (line1.slope == line2.slope) {
            if (line1.yIntercept == line2.yIntercept && isBetween(start1, start2, end1))
                return start2;
            else return null;
        }

        double intersectionX = (line1.yIntercept - line2.yIntercept) / (line2.slope - line1.slope);
        double intersectionY = line1.slope * intersectionX + line1.yIntercept;
        Point intersection = new Point(intersectionX, intersectionY);

        boolean intersect = isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2);
        if (intersect) return intersection;
        else return null;
    }

    private boolean isBetween(Point start, Point middle, Point end) {
        return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
    }

    private boolean isBetween(double start, double middle, double end) {
        if (start > end) return end <= middle && middle <= start;
        else return start <= middle && middle <= end;
    }

    private void swap(Point start, Point end) {
        double tempX = start.x;
        double tempY = start.y;
        start.x = end.x;
        start.y = end.y;
        end.x = tempX;
        end.y = tempY;
    }


    class Line {
        public double slope;
        public double yIntercept;

        public Line(Point start, Point end) {
            this.slope = (end.y - start.y) / (end.x - start.x);
            this.yIntercept = start.y - (this.slope * start.x);
        }
    }

    class Point {
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override public String toString() {
            return "Point{" +
                   "x=" + x +
                   ", y=" + y +
                   '}';
        }
    }
}
