package com.company.treesandgraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BinarySearchTree {

    public BinaryNode<Integer> root;
    public int size;

    public void add(int data) {
        size++;
        BinaryNode<Integer> node = new BinaryNode<>(data);
        if (root == null) root = node;
        else addHelper(root, node);
    }

    private void addHelper(BinaryNode<Integer> root, BinaryNode<Integer> node) {
        if (node.data <= root.data) {
            if (root.left == null) {
                root.left = node;
                node.parent = root;
            }
            else addHelper(root.left, node);
        } else {
            if (root.right == null) {
                root.right = node;
                node.parent = root;
            }
            else addHelper(root.right, node);
        }
    }

    public BinaryNode<Integer> delete(BinaryNode<Integer> node, int key) {
        if (node == null) return null;

        if (key < node.data) {
            node.left = delete(node.left, key);
        } else if (key > node.data) {
            node.right = delete(node.right, key);
        } else {
            size--;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            node.data = leftMostValue(node.right);
            node.right = delete(node.right, node.data);
        }

        return node;
    }


    public BinaryNode<Integer> random() {
        Random random = new Random();
        int index = random.nextInt(size);
        int[] count = new int[1];
        System.out.println("random index: " + index);
        return findWithIndex(root, 6, count);
    }


    public BinaryNode<Integer> findWithIndex(BinaryNode<Integer> root, int index, int[] count) {
        if (root == null) return null;

        System.out.println("count:" + count[0]);

        if (count[0] == index) return root;


        count[0]++;

        BinaryNode<Integer> left = findWithIndex(root.left, index, count);
        if (left != null) return left;

        BinaryNode<Integer> right = findWithIndex(root.right, index, count);
        if (right != null) return right;

        return null;
    }

    private int leftMostValue(BinaryNode<Integer> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }


    public static BinaryNode<Integer> generate(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        Random random = new Random();
        for (int i = 1; i < size; i++) {
            int index = random.nextInt(i);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.root = new BinaryNode<Integer>(arr[0]);

        for (int i = 1; i < size; i++) {
            binarySearchTree.add(arr[i]);
        }

        return binarySearchTree.root;
    }
}
