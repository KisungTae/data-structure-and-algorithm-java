package com.company.treesandgraphs;

//Random Node: You are implementing a binary search tree class from scratch, which, in addition
//        to insert, find, and delete, has a method getRandomNode() which returns a random node
//        from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
//        for getRandomNode, and explain how you would implement the rest of the methods.

public class Question11Review {
    public Question11Review() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(8);
        binarySearchTree.add(4);
        binarySearchTree.add(3);
        binarySearchTree.add(2);
        binarySearchTree.add(12);
        binarySearchTree.add(10);
        binarySearchTree.add(15);
        binarySearchTree.add(11);
        binarySearchTree.add(20);

        BTreePrinter.printBinaryNode(binarySearchTree.root);
        System.out.println("size: " + binarySearchTree.size);
        System.out.println("random: " + binarySearchTree.random().data);

    }
}
