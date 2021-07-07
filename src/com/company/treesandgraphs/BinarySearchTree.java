package com.company.treesandgraphs;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchTree {

    public BinaryNode<Integer> root;

    public void add(int data) {
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

    private BinaryNode<Integer> delete(BinaryNode<Integer> node, int key) {
        if (node == null) return null;

        if (key < node.data) {
            node.left = delete(node.left, key);
        } else if (key > node.data) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            node.data = leftMostValue(node.right);
            node.right = delete(node.right, node.data);
        }

        return node;
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
