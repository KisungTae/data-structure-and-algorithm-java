package com.company.treesandgraphs;

//Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
//        this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
//        node never differ by more than one.

public class Question4 {
    public Question4() {
        BinaryNode<Integer> root1 = new BinaryNode<>(1);
        BinaryNode<Integer> root2 = new BinaryNode<>(2);
        BinaryNode<Integer> root3 = new BinaryNode<>(3);
        BinaryNode<Integer> root4 = new BinaryNode<>(4);
        BinaryNode<Integer> root5 = new BinaryNode<>(5);
        BinaryNode<Integer> root6 = new BinaryNode<>(6);
        BinaryNode<Integer> root7 = new BinaryNode<>(7);
        BinaryNode<Integer> root8 = new BinaryNode<>(8);
        BinaryNode<Integer> root9 = new BinaryNode<>(9);
        BinaryNode<Integer> root10 = new BinaryNode<>(10);
        BinaryNode<Integer> root11 = new BinaryNode<>(11);
        BinaryNode<Integer> root12 = new BinaryNode<>(12);
        BinaryNode<Integer> root13 = new BinaryNode<>(13);

        root1.left = root2;
        root1.right = root3;

        root2.left = root4;
        root2.right = root5;

        root3.left = root6;
        root3.right = root7;

        root4.left = root8;
        root4.right = root9;

        root5.left = root10;
        root5.right = root11;

        root6.left = root12;
        root6.right = root13;

        BTreePrinter.printBinaryNode(root1);

        System.out.println("check: " + check(root1));
    }

    private int check(BinaryNode<Integer> root) {
        if (root == null) return 0;

        int left = check(root.left);
        if (left == Integer.MIN_VALUE) return left;

        int right = check(root.right);
        if (right == Integer.MIN_VALUE) return right;

        if (Math.abs(left - right) > 1) return Integer.MIN_VALUE;

        return Math.max(left, right) + 1;
    }
}
