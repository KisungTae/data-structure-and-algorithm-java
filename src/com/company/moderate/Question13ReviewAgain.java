package com.company.moderate;

//Bisect Squares: Given two squares on a two-dimensional plane, find a line that would cut these two
//        squares in half. Assume that the top and the bottom sides of the square run parallel to the x-axis.

// 8:40

import java.awt.*;

public class Question13ReviewAgain {

    public Question13ReviewAgain() {
        Rectangle rectangle1 = new Rectangle(3, new DoublePoint(1, 4));
        Rectangle rectangle2 = new Rectangle(2, new DoublePoint(3, 5));

        DoublePoint rectangle1Mid = rectangle1.getMidPoint();
        DoublePoint rectangle2Mid = rectangle2.getMidPoint();

        Line line = new Line(rectangle1Mid, rectangle2Mid);
        System.out.println(line);
    }

    class Line {
        public double slope;
        public double yInterceptor;

        public Line(DoublePoint doublePoint1, DoublePoint doublePoint2) {
            this.slope = (doublePoint2.y - doublePoint1.y) / (doublePoint2.x - doublePoint1.x);
            this.yInterceptor = doublePoint1.y - (slope * doublePoint1.x);
        }

        @Override public String toString() {
            return "Line{" +
                   "slope=" + slope +
                   ", yInterceptor=" + yInterceptor +
                   '}';
        }
    }

    class Rectangle {
        public int width;
        public int height;
        public DoublePoint startPoint;
        public Point endPoint;

        public Rectangle(int width, DoublePoint startPoint) {
            this.width = width;
            this.startPoint = startPoint;
        }

        public DoublePoint getMidPoint() {
            double halfWidth = width / 2.0;
            return new DoublePoint(startPoint.x + halfWidth, startPoint.y - halfWidth);
        }
    }

    class DoublePoint {
        public double x;
        public double y;

        public DoublePoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override public String toString() {
            return "DoublePoint{" +
                   "x=" + x +
                   ", y=" + y +
                   '}';
        }
    }
}
