package com.company.linkedLists;

//Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
//        beginning of the loop.
//        DEFINITION
//        Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
//        as to make a loop in the linked list.
//        EXAMPLE
//        Input: A -> B -> C - > D -> E -> C [the same C as earlier]
//        Output: C

public class Question8Review {
    public Question8Review() {
        LinkedList<Integer> linkedList = LinkedList.generateIncrementLinkedList(6);
        LinkedList<Integer>.Node<Integer> node = linkedList.head.next.next;
        linkedList.tail.next = node;
        System.out.println("node: " + find(linkedList).data);
    }

    private LinkedList<Integer>.Node<Integer> find(LinkedList<Integer> linkedList) {
        LinkedList<Integer>.Node<Integer> fast = linkedList.head;
        LinkedList<Integer>.Node<Integer> slow = linkedList.head;

        int fastSize = 1;
        int slowSize = 1;

        do {
            fast = fast.next.next;
            slow = slow.next;
            fastSize += 2;
            slowSize++;
        } while (fast != slow);

        int diff = Math.abs(fastSize - slowSize);

        fast = linkedList.head;
        slow = linkedList.head;

        for (int i = 0; i < diff; i++) {
            fast = fast.next;
        }

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
