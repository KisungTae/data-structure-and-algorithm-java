package com.company.sortingandsearching;

//Sorted Matrix Search: Given an M x N matrix in which each row and each column is sorted in
//        ascending order, write a method to find an element.

// 8:31
// 11:20
public class Question9ReviewAgain {

    public Question9ReviewAgain() {
        int m = 10;
        int n = 10;
        int[][] matrix = {{1, 2, 3, 4, 5, 6, 7},
                          {2, 3, 4, 5, 6, 7, 8},
                          {3, 4, 5, 6, 7, 8, 9},
                          {4, 5, 6, 7, 8, 9, 10},
                          {5, 6, 7, 8, 9, 10, 11}};

        Coordinate origin = new Coordinate(0, 0);
        Coordinate dest = new Coordinate(matrix.length - 1, matrix[0].length - 1);
        int x= 3;
        Coordinate found = search(matrix, origin, dest, x);
        if (found == null) System.out.println("found = null");
        else System.out.println(found.toString());
    }

    private Coordinate search(int[][] matrix, Coordinate origin, Coordinate dest, int x) {

        if (!origin.inbounds(matrix) || !dest.inbounds(matrix)) return null;
        if (matrix[origin.row][origin.col] == x) return origin;
        if (!origin.isBefore(dest)) return null;

        Coordinate start = origin.clone();
        int diagDist = Math.min((dest.row - origin.row), (dest.col - origin.col));
        Coordinate end = new Coordinate(origin.row + diagDist, origin.col + diagDist);
        Coordinate middle = new Coordinate(0, 0);

        while (start.isBefore(end)) {
            middle.average(start, end);
            System.out.println(start.toString() + " || " + end.toString() + " || " + middle.toString());
            if (x > matrix[middle.row][middle.col]) {
                start.row = middle.row + 1;
                start.col = middle.col + 1;
            } else {
                end.row = middle.row - 1;
                end.col = middle.col - 1;
            }
        }

        return partition(matrix, origin, dest, start, x);
    }

    private Coordinate partition(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot, int x) {
        Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.col);
        Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.col - 1);
        Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.col);
        Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.col);

        Coordinate found = search(matrix, lowerLeftOrigin, lowerLeftDest, x);
        if (found == null)
            return search(matrix, upperRightOrigin, upperRightDest, x);
        else return found;
    }

    class Coordinate {
        public int row;
        public int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean inbounds(int[][] matrix) {
            return this.row < matrix.length && this.row >= 0 && this.col < matrix[0].length && this.col >= 0;
        }

        public boolean isBefore(Coordinate end) {
            return this.row <= end.row && this.col <= end.col;
        }

        public Coordinate clone() {
            return new Coordinate(row, col);
        }

        public void average(Coordinate start, Coordinate end) {
            this.row = (end.row + start.row) / 2;
            this.col = (end.col + start.col) / 2;
        }

        @Override public String toString() {
            return "Coordinate{" +
                   "row=" + row +
                   ", col=" + col +
                   '}';
        }
    }


}
