package com.company.linkedLists;

//Implement a function to check if a linked list is a palindrome.

public class Question6 {
    public Question6() {
        LinkedList<Character> linkedList = new LinkedList<>();
        linkedList.append('c');
        linkedList.append('b');
        linkedList.append('a');
//        linkedList.append('a');
        linkedList.append('b');
        linkedList.append('c');
        linkedList.print();
        System.out.println("is palindrome: " + isPalindrome(linkedList));
    }

    private boolean isPalindrome(LinkedList<Character> linkedList) {
        LinkedList<Character>.Node<Character> fast = linkedList.head;
        LinkedList<Character>.Node<Character> slow = linkedList.head;

        LinkedList<Character> reverse = new LinkedList<>();

        while (fast != null && fast.next != null) {
            reverse.prepend(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;

//        while (slow != null) {
//            reverse.prepend(slow.data);
//            slow = slow.next;
//        }

/*        slow = linkedList.head;*/
        LinkedList<Character>.Node<Character> reverseHead = reverse.head;

        while (slow != null && reverseHead != null) {
            if (slow.data != reverseHead.data) return false;

            slow = slow.next;
            reverseHead = reverseHead.next;
        }

        return true;
    }
}
