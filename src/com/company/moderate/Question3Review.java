package com.company.moderate;

//Intersection: Given two straight line segments (represented as a start point and an end point),
//        compute the point of intersection, if any.

import java.awt.*;

public class Question3Review {

    public Question3Review() {
        Point lineAStart = new Point(1, 2);
        Point lineAEnd = new Point(3, 5);

        Point lineBStart = new Point(1, 5);
        Point lineBEnd = new Point(4, 2);

        Line lineA = new Line(lineAStart, lineAEnd);
        Line lineB = new Line(lineBStart, lineBEnd);

        double intersectionX = (lineA.yIntercept - lineB.yIntercept) / (lineA.slope - lineB.slope);
        double intersectionY = intersectionX * lineA.slope + lineA.yIntercept;

        System.out.println("inter x = " + intersectionX + " inter y = " + intersectionY);

        boolean intersectionInA = isBetween(lineAStart, lineAEnd, intersectionX, intersectionY);
        boolean intersectionInB = isBetween(lineBStart, lineBEnd, intersectionX, intersectionY);

        if (intersectionInA && intersectionInB) System.out.println("x = " + intersectionX + " y = " + intersectionY);
        else System.out.println("no intersection");
    }

    private boolean isBetween(Point lineStart, Point lineEnd, double intersectionX, double intersectionY) {
        if (intersectionX < lineStart.x || intersectionX > lineEnd.x) return false;
        if (intersectionY < lineStart.y || intersectionY > lineEnd.y) return false;
        return true;
    }

    class Line {

        public double slope, yIntercept;

        public Line(Point startPoint, Point endPoint) {
            double xIncrement = endPoint.x - startPoint.x;
            double yIncrement = endPoint.y - startPoint.y;
            this.slope = yIncrement / xIncrement;
            this.yIntercept = startPoint.y - (startPoint.x * slope);
        }
    }
}
