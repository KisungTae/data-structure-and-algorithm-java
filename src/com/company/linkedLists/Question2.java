package com.company.linkedLists;

public class Question2 {
    public Question2() {
        LinkedList<Integer> linkedList = LinkedList.generateIncrementLinkedList(10);
        linkedList.print();
        int k = 3;
        System.out.println(k + "th element: " + kthElement(linkedList, k).data);
    }

    private LinkedList<Integer>.Node<Integer> kthElement(LinkedList<Integer> linkedList, int k) {
        LinkedList<Integer>.Node<Integer> slow = linkedList.head;
        LinkedList<Integer>.Node<Integer> fast = linkedList.head;

        int count = k;
        while (fast != null && count > 0) {
            fast = fast.next;
            count--;
        }

        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
