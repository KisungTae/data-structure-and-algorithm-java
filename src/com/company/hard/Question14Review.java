package com.company.hard;

// Smallest K: Design an algorithm to find the smallest K numbers in an array.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Question14Review {

    public int size = 0;

    public Question14Review() {
        int n = 10;
        int k = 5;

//        int[] arr = new int[n];
        int[] arr = {76, 0, 31, 10, 25, 71, 15, 87, 52, 12};
//        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            arr[i] = random.nextInt(100);
//        }
        System.out.println(Arrays.toString(arr));

        MaxHeap maxHeap = new MaxHeap(n);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(arr[i]);
            maxHeap.insert(arr[i]);
        }
//        maxHeap.print();
//        System.out.println("maxHeap.extract(): " + maxHeap.extract());
//        maxHeap.print();


        ArrayList<Integer> left = rankingSort(arrayList, k);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("left: " + left.toString());
    }

    private ArrayList<Integer> rankingSort(ArrayList<Integer> arr, int rank) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        Random random = new Random();
        int pivot = arr.get(random.nextInt(arr.size()));

        for (Integer integer : arr) {
            if (integer <= pivot) left.add(integer);
            else right.add(integer);
        }

        if (left.size() == rank) return left;
        else if (left.size() > rank) return rankingSort(left, rank);
        else {
            ArrayList<Integer> temp = rankingSort(right, rank - left.size());
            left.addAll(temp);
            return rankingSort(left, rank);
        }
    }

    class MaxHeap {
        int[] arr;
        int maxSize;
        int size = 0;

        public MaxHeap(int maxSize) {
            this.maxSize = maxSize;
            this.arr = new int[maxSize + 1];
            this.arr[0] = Integer.MAX_VALUE;
        }

        private boolean isLeaf(int pos) {
            return pos > (size / 2) && pos <= size;
        }

        private int parent(int pos) {
            return pos / 2;
        }

        private int leftChild(int pos) {
            return pos * 2;
        }

        private int rightChild(int pos) {
            return pos * 2 + 1;
        }

        private void sort(int pos) {
            if (isLeaf(pos)) return;
            if (arr[pos] < arr[leftChild(pos)] || arr[pos] < arr[rightChild(pos)]) {
                if (arr[leftChild(pos)] > arr[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    sort(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    sort(rightChild(pos));
                }
            }
        }

        public int extract() {
            if (size <= 0) throw new RuntimeException();
            size--;
            int data = arr[1];
            arr[1] = arr[size];
            sort(1);
            return data;
        }

        private void swap(int left, int right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        public void insert(int data) {
            if (size >= maxSize) throw new RuntimeException();

            size++;
            this.arr[size] = data;

            int index = size;
            while (arr[index] > arr[parent(index)]) {
                swap(index, parent(index));
                index = parent(index);
            }
        }

        public void print() {
            for (int i = 1; i <= size / 2; i++) {
                int right = 2 * i + 1;
                System.out.print(
                        " PARENT : " + arr[i]
                        + " LEFT CHILD : " + arr[2 * i]
                        + " RIGHT CHILD :" + (right > size ? "null": arr[right]));
                System.out.println();
            }
        }
    }
}
