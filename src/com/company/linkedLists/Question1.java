package com.company.linkedLists;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Question1 {
    public Question1() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            linkedList.append(random.nextInt(5));
        }
        linkedList.print();
        removeDup(linkedList);
        linkedList.print();
    }

    private void removeDup(LinkedList<Integer> linkedList) {
        Set<Integer> memo = new HashSet<>();

        LinkedList<Integer>.Node<Integer> itr =  linkedList.head;

        while (itr != null) {
            if (memo.contains(itr.data)) {

            } else {
                memo.add(itr.data);
            }
            itr = itr.next;
        }
    }
}
