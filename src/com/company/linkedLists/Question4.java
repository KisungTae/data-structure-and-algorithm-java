package com.company.linkedLists;

//Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
//        before all nodes greater than or equal to x. If x is contained within the list the values of x only need
//        to be after the elements less than x (see below). The partition element x can appear anywhere in the
//        "right partition"; it does not need to appear between the left and right partitions.
//        EXAMPLE
//        Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
//        Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8

public class Question4 {
    public Question4() {
        LinkedList<Integer> linkedList = LinkedList.generateRandomLinkedList(10);
        linkedList.print();
        partition(linkedList, 5);
        linkedList.print();
    }

    private void partition(LinkedList<Integer> linkedList, int k) {
        LinkedList<Integer>.Node<Integer> smaller = null;
        LinkedList<Integer>.Node<Integer> biggerHead = null;
        LinkedList<Integer>.Node<Integer> bigger = null;

        LinkedList<Integer>.Node<Integer> itr = linkedList.head;
        while (itr != null) {
            if (itr.data < k) {
                if (smaller == null) {
                    smaller = itr;
                    linkedList.head = smaller;
                }
                else {
                    smaller.next = itr;
                    smaller = itr;
                }
            } else {
                if (bigger == null) {
                    bigger = itr;
                    biggerHead = bigger;
                }
                else {
                    bigger.next = itr;
                    bigger = itr;
                }
            }
            itr = itr.next;
        }

        smaller.next = biggerHead;
        bigger.prev = smaller;
        bigger.next = null;
    }
}
