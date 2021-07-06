package com.company.treesandgraphs;

//Validate BST: Implement a function to check if a binary tree is a binary search tree.

public class Question5Review {
    public Question5Review() {
        BinaryNode<Integer> root = BinarySearchTree.generate(10);
        int[] arr = { Integer.MIN_VALUE };
        System.out.println("check: " + check(root, arr));
    }

    private boolean check(BinaryNode<Integer> root, int[] arr) {
        if (root == null) return true;

        boolean left = check(root.left, arr);
        if (!left) return false;

        if (root.data < arr[0]) return false;
        else arr[0] = root.data;

        return check(root.right, arr);
    }
}
