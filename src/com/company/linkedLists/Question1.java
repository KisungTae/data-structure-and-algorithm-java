package com.company.linkedLists;

import java.util.HashSet;
import java.util.Set;

public class Question1 {
    public Question1() {
        LinkedList<Integer> linkedList = LinkedList.generateRandomLinkedList(10);
        linkedList.print();
        removeDup(linkedList);
        linkedList.print();
    }

    private void removeDup(LinkedList<Integer> linkedList) {
        Set<Integer> memo = new HashSet<>();

        LinkedList<Integer>.Node<Integer> itr =  linkedList.head;

        while (itr != null) {
            if (memo.contains(itr.data)) {
                linkedList.remove(itr);
            } else {
                memo.add(itr.data);
            }
            itr = itr.next;
        }
    }
}
