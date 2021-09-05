package com.company.hard;

//Missing Number: An array A contains all the integers from Oto n, except for one number which
//        is missing. In this problem, we cannot access an entire integer in A with a single operation. The
//        elements of A are represented in binary, and the only operation we can use to access them is "fetch
//        the jth bit of A[ i ],"which takes constant time. Write code to find the missing integer. Can you do
//        it inO(n) time?


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question4Review {

    public Question4Review() {
        int n = 10;
        BinaryArray binaryArray = new BinaryArray(n);

        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            indices.add(i);
        }

        int closestSquareNumber = closestSquareNumber(n);
        System.out.println("missing: " + findMissing(binaryArray, closestSquareNumber, indices, 0, closestSquareNumber, (closestSquareNumber / 4) - 1));
        System.out.println("missing: " + findMissingAnswer(binaryArray, indices, 0));

    }

    private int findMissingAnswer(BinaryArray binaryArray, ArrayList<Integer> indices, int column) {
        if (indices.size() <= 0) return 0;

        ArrayList<Integer> zeros = new ArrayList<>();
        ArrayList<Integer> ones = new ArrayList<>();

        for (int index : indices) {
            if (binaryArray.fetchBit(index, column) > 0)
                ones.add(index);
            else zeros.add(index);
        }

        if (zeros.size() <= ones.size()) {
            int part = findMissingAnswer(binaryArray, zeros, column + 1);
            return part;
        } else {
            int part = findMissingAnswer(binaryArray, ones, column + 1);
            return part | (1 << column);
        }
    }

    private int findMissing(BinaryArray binaryArray, int pivot, ArrayList<Integer> indices, int start, int end, int ithIndex) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();


        int halfPivot = pivot / 2;
//        int ithBit = ((pivot / 4) - 1);

        System.out.println("start: " + start + " | end: " + end + " | ith bit: " + ithIndex);

        for (int index : indices) {
            int bit = binaryArray.fetchBit(index, ithIndex);
            if (bit <= 0) left.add(index);
            else right.add(index);
        }

//        System.out.println("left size: " + left.size() + " | right size: " + right.size());

        if (pivot == 1) {
            System.out.println("start: " + start + " | end: " + end + " | ith bit: " + ithIndex);

            if (left.size() <= 0) return start;
            else return end;
        }

        if (left.size() < halfPivot) return findMissing(binaryArray, halfPivot, left, start, end - halfPivot, ithIndex - 1);
        else return findMissing(binaryArray, halfPivot, right, start + halfPivot, end, ithIndex - 1);
    }

    private int closestSquareNumber(int n) {
        int count = 1;
        while (count <= n) {
            count *= 2;
        }
        return count;
    }

    class BinaryArray {
        public Integer[] arr;

        public BinaryArray(int size) {
            arr = new Integer[size - 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            List<Integer> intList = Arrays.asList(arr);
            Collections.shuffle(intList);
            intList.toArray(arr);
            System.out.println(Arrays.toString(arr));
        }

        public int fetchBit(int i, int j) {
            int mask = 1 << j;
            int num = arr[i];
//            System.out.println(Integer.toBinaryString(arr[i]) + " | " + j + "th bit: " +  Integer.toBinaryString((mask & num)));
            if ((mask & num) > 0) return 1;
            else return 0;
        }
    }
}
