package com.company.sortingandsearching;

//Sorted Search, No Size: You are given an array-like data structure Listy which lacks a size
//        method. It does, however, have an elementAt ( i) method that returns the element at index i in
//        0( 1) time. If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data
//        structure only supports positive integers.) Given a Li sty which contains sorted, positive integers,
//        find the index at which an element x occurs. If x occurs multiple times, you may return any index.

public class Question4Review {



    public Question4Review() {
        Listy listy = new Listy();
        int input = 4;
        System.out.println("index of " + input + " is " + find(listy, input));
    }

    private int find(Listy listy, int input) {
        int left = 0;
        int right = 0;
        int add = 1;

        while (left <= right) {
            int value = listy.elementAt(left);

            if (value == input) return left;

            int nextIndex = left + add;
            int nextValue = listy.elementAt(nextIndex);

            if (nextValue == input) return nextIndex;



            if (nextValue == -1 || nextValue > input) {
                add = 1;
                left += add;
                if (left >= right) return -1;
                right = nextIndex;
            } else {
                left += add;
                add += add;
                right = left;
            }
        }

        return -1;
    }

    class Listy {

        public int[] arr = new int[]{1, 2, 3, 5, 5, 5, 5, 6, 6, 7, 7, 8, 9, 10, 10, 10};

        public int elementAt(int index) {
            if (index < 0 || index >= arr.length) return -1;
            return arr[index];
        }
    }

}


