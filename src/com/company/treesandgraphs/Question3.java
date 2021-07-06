package com.company.treesandgraphs;

//List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
//        at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).

import java.util.ArrayList;
import java.util.LinkedList;

public class Question3 {
    public Question3() {
        BinaryNode<Integer> root = BinarySearchTree.generate(10);
        BTreePrinter.printBinaryNode(root);
        ArrayList<LinkedList<BinaryNode<Integer>>> arrayList = new ArrayList<>();
        link(arrayList, root, 0);
        System.out.println("size: " + arrayList.size());
    }

    private void link(ArrayList<LinkedList<BinaryNode<Integer>>> arrayList, BinaryNode<Integer> root, int index) {
        if (root == null) return;

        if (index > arrayList.size() - 1) {
            LinkedList<BinaryNode<Integer>> linkedList = new LinkedList<>();
            linkedList.add(root);
            arrayList.add(linkedList);
        } else {
            LinkedList<BinaryNode<Integer>> linkedList = arrayList.get(index);
            linkedList.add(root);
        }
        link(arrayList, root.left, index + 1);
        link(arrayList, root.right, index + 1);
    }
}
