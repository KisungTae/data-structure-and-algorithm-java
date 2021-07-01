package com.company.linkedLists;

public class Question3 {
    public Question3() {
        LinkedList<Integer> linkedList = LinkedList.generateIncrementLinkedList(10);
        linkedList.print();
        LinkedList<Integer>.Node<Integer> mid = linkedList.head;

        for (int i = 0; i < 5; i++) {
            mid = mid.next;
        }

        remove(mid);
        linkedList.print();
    }

    private void remove(LinkedList<Integer>.Node<Integer> node) {
        LinkedList<Integer>.Node<Integer> fast = node.next;

        while (fast.next != null) {
            node.data = fast.data;
            node = fast;
            fast = fast.next;
        }

        node.data = fast.data;
        node.next = null;

    }
}
