package com.company.hard;

//BiNode: Consider a simple data structure called BiNode, which has pointers to two other nodes.
//public class BiNode {
//}
//    public BiNode nodel, node2;
//    public int data;
//    The data structure BiNode could be used to represent both a binary tree (where nodel is the left
//        node and node2 is the right node) or a doubly linked list (where nodel is the previous node and
//        node2 is the next node). Implement a method to convert a binary search tree (implemented with
//        BiNode) into a doubly linked list. The values should be kept in order and the operation should be
//        performed in place (that is, on the original data structure).

public class Question12Review {

    public Question12Review() {
        BiNode root = new BiNode(8);

        BiNode node6 = new BiNode(6);
        BiNode node15 = new BiNode(15);

        BiNode node4 = new BiNode(4);
        BiNode node7 = new BiNode(7);
        BiNode node13 = new BiNode(13);
        BiNode node20 = new BiNode(20);

        BiNode node2 = new BiNode(2);
//        BiNode node3 = new BiNode(3);
        BiNode node25 = new BiNode(25);

        root.node1 = node6;
        root.node2 = node15;

        node6.node1 = node4;
        node6.node2 = node7;
        node15.node1 = node13;
        node15.node2  = node20;

        node4.node1 = node2;
//        node4.node2 = node3;
        node20.node2 = node25;


        
    }

    class BiNode {
        public BiNode node1, node2;
        public int data;

        public BiNode(int data) {
            this.data = data;
        }
    }
}
