package com.company.treesandgraphs;

//Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
//        algorithm to create a binary search tree with minimal height.

public class Question2 {
    public Question2() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        BinaryNode<Integer> root = create(arr, 0, arr.length - 1);
        BTreePrinter.printBinaryNode(root);
    }


    private BinaryNode<Integer> create(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        BinaryNode<Integer> binaryNode = new BinaryNode<Integer>(arr[mid]);

        BinaryNode<Integer> left = create(arr, start, mid - 1);
        BinaryNode<Integer> right = create(arr, mid + 1, end);

        binaryNode.left = left;
        binaryNode.right = right;
        return binaryNode;
    }



}
