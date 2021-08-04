package com.company.sortingandsearching;

//Rank from Stream: Imagine you are reading in a stream of integers. Periodically, you wish to be able
//        to look up the rank of a numberx (the number of values less than or equal to x). lmplement the data
//        structures and algorithms to support these operations. That is, implement the method track ( int
//        x), which is called when each number is generated, and the method getRankOfNumber(int
//        x), which returns the number of values less than or equal to x (not including x itself).

//        EXAMPLE
//        Stream (in order of appearance): 5, 1, 4, 4, 5, 9, 7, 13, 3
//        getRankOfNumber(1) 0
//        getRankOfNumber(3) = 1
//        getRankOfNumber(4) 3

// 9:20

import com.company.treesandgraphs.BTreePrinter;
import com.company.treesandgraphs.BinarySearchTree;

public class Question10Review {

    public Question10Review() {
        int[] stream = {5, 1, 4, 4, 5, 9, 7, 13, 3};


        for (int num : stream) {

        }

        Node root = new Node(stream[0]);
        for (int i = 1; i < stream.length; i++) {
            root.add(stream[i]);
        }

        print(root);
        System.out.println("count: " + rankOf(7, root));

    }

    private int rankOf(int data, Node root) {
        if (data == root.data) return root.child;
        else if (data < root.data) {
            if (root.left == null) return  -1;
            else return rankOf(data, root.left);
        } else {
            int right = root.right == null ? -1 : rankOf(data, root.right);
            if (right == -1) return -1;
            return right + root.count + root.child;
        }
    }


    private void print(Node root) {
        if (root == null) return;
        System.out.println("data: " + root.data + " | count: " + root.count + " | child: " + root.child);
        print(root.left);
        print(root.right);
    }

    class Node {
        public int data;
        public int child;
        public int count = 1;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        public void add(int data) {
            if (data < this.data) {
                child++;
                if (this.left == null) left = new Node(data);
                else left.add(data);
            } else if (data == this.data) {
                count++;
            } else {
                if (this.right == null) right = new Node(data);
                else right.add(data);
            }
        }
    }
}
