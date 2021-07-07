package com.company.treesandgraphs;

//First Common Ancestor: Design an algorithm and write code to find the first common ancestor
//        of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
//        necessarily a binary search tree.

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question8Review {
    public Question8Review() {
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
        Set<BinaryNode<Integer>> set = new HashSet<>();
        set.add(root10);
        set.add(root13);
//        System.out.println("common: " + common(root1, root10).data);
        System.out.println("common: " + common2(root8, set).data);
//


//        System.out.println("exists: " + find(root12, set));

    }

    private BinaryNode<Integer> common(BinaryNode<Integer> first, BinaryNode<Integer> second) {
        int firstLevel = level(first);
        int secondLevel = level(second);

        BinaryNode<Integer> longer = firstLevel > secondLevel ? first : second;
        BinaryNode<Integer> shorter = firstLevel > secondLevel ? second : first;

        for (int i = 0; i < Math.abs(firstLevel - secondLevel); i++) {
            longer = longer.parent;
        }

        while (longer != shorter) {
            longer = longer.parent;
            shorter = shorter.parent;
        }

        return longer;
    }

    private int level(BinaryNode<Integer> node) {
        int count = 0;
        while (node != null) {
            node = node.parent;
            count++;
        }
        return count;
    }

    private BinaryNode<Integer> common2(BinaryNode<Integer> node, Set<BinaryNode<Integer>> set) {
        if (node == null) return null;

        if (set.contains(node)) {
            set.remove(node);
            return null;
        }

        BinaryNode<Integer> left = common2(node.left, set);
        if (left != null) return left;

        if (set.size() == 1) {
            boolean exists = find(node.right, set);
            if (exists) return node;
        }

        return common2(node.right, set);
    }

    private boolean find(BinaryNode<Integer> root, Set<BinaryNode<Integer>> set) {
        if (root == null) return false;
        if (set.contains(root)) return true;

        boolean left = find(root.left, set);
        if (left) return true;

        return find(root.right, set);
    }
}
