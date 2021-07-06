package com.company.treesandgraphs;

public class Question6Review {
    public Question6Review() {
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


        root8.left = root4;
        root8.right = root12;
        root4.parent = root8;
        root12.parent = root8;

        root4.left = root2;
        root4.right = root6;
        root2.parent = root4;
        root6.parent = root4;

        root2.left = root1;
        root2.right = root3;
        root1.parent = root2;
        root3.parent = root2;

        root6.left = root5;
        root6.right = root7;
        root5.parent = root6;
        root7.parent = root6;

        root12.left = root10;
        root12.right = root13;
        root10.parent = root12;
        root13.parent = root12;

        root10.left = root9;
        root10.right = root11;
        root9.parent = root10;
        root11.parent = root10;



        BTreePrinter.printBinaryNode(root8);
        System.out.println("next: " + next(root12).data);

//        System.out.println("parent: " + nextParent(root8).data);

    }

    private BinaryNode<Integer> next(BinaryNode<Integer> node) {
        if (node.parent == null) return leftMost(node.right);
        else if (node.parent.left == node) {
            if (node.right == null) return node.parent;
            else return leftMost(node.right);
        } else {
            if (node.right == null) {
                return nextParent(node);
            }
            else return leftMost(node.right);
        }
    }

    private BinaryNode<Integer> nextParent(BinaryNode<Integer> node) {
        while (node != null && node.parent != null && node.parent.right == node) {
            node = node.parent;
        }
        return node == null ? null : node.parent;
    }

    private BinaryNode<Integer> leftMost(BinaryNode<Integer> node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
