package com.company.hard;

//Missing Number: An array A contains all the integers from Oto n, except for one number which
//        is missing. In this problem, we cannot access an entire integer in A with a single operation. The
//        elements of A are represented in binary, and the only operation we can use to access them is "fetch
//        the jth bit of A[ i ],"which takes constant time. Write code to find the missing integer. Can you do
//        it inO(n) time?


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question4Review {

    public Question4Review() {
        int n = 20;
        BinaryArray binaryArray = new BinaryArray();
    }

    class BinaryArray {
        public Integer[] arr;
        public int size = 20;

        public BinaryArray() {
            arr = new Integer[size];
            for (int i = 0; i < arr.length; i++) {
                if (i == 7) arr[i] = 0;
                else arr[i] = i;
            }
            List<Integer> intList = Arrays.asList(arr);
            Collections.shuffle(intList);
            intList.toArray(arr);
            System.out.println(Arrays.toString(arr));
        }

        public int fetchBit(int i, int j) {
            int mask = 1 << (i - 1);
            int num = arr[i];
            return mask & num;
        }
    }
}
