package com.company.linkedLists;

//Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
//        intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
//        kth node of the first linked list is the exact same node (by reference) as the jth node of the second
//        linked list, then they are intersecting.

public class Question7 {
    public Question7() {
        LinkedList<Integer> linkedList1 = LinkedList.generateIncrementLinkedList(10);
        LinkedList<Integer> linkedList2 = LinkedList.generateRandomLinkedList(7);
        linkedList1.tail.next = linkedList2.head.next.next;

        linkedList1.print();
        linkedList2.print();
        System.out.println();
        LinkedList<Integer>.Node<Integer> node = intersection(linkedList1, linkedList2);
        while (node != null) {
            System.out.print(node.data);
            System.out.print(" ==> ");
            node = node.next;
        }
        System.out.print("null");
    }

    private LinkedList<Integer>.Node<Integer> intersection(LinkedList<Integer> linkedList1, LinkedList<Integer> linkedList2) {
        int size1 = getSize(linkedList1);
        int size2 = getSize(linkedList2);

        LinkedList<Integer> longer = size1 > size2 ? linkedList1 : linkedList2;
        LinkedList<Integer> shorter = size1 > size2 ?  linkedList2 : linkedList1;

        int diff = Math.abs((size1 - size2));

        LinkedList<Integer>.Node<Integer> longerHead = longer.head;
        LinkedList<Integer>.Node<Integer> shorterHead = shorter.head;

        for (int i = 0; i < diff; i++) {
            longerHead = longerHead.next;
        }

        while (longerHead != null && shorterHead != null) {
            if (longerHead == shorterHead) return longerHead;
            longerHead = longerHead.next;
            shorterHead = shorterHead.next;
        }
        return null;
    }

    private int getSize(LinkedList<Integer> linkedList) {
        int size = 0;
        LinkedList<Integer>.Node<Integer> head = linkedList.head;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
