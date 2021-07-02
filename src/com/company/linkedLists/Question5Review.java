package com.company.linkedLists;

//Sum Lists: You have two numbers represented by a linked list, where each node contains a single
//        digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
//        function that adds the two numbers and returns the sum as a linked list.
//        EXAMPLE
//        Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
//        Output: 2 -> 1 -> 9. That is, 912.
//        FOLLOW UP
//        Suppose the digits are stored in forward order. Repeat the above problem.
//        Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
//        Output: 9 -> 1 -> 2. That is, 912.

public class Question5Review {
    public Question5Review() {
        LinkedList<Integer> number1 = LinkedList.generateRandomLinkedList(3);
        LinkedList<Integer> number2 = LinkedList.generateRandomLinkedList(4);
        number1.head.data = 5;
        number2.head.data = 3;

        number1.print();
        number2.print();

        LinkedList<Integer> result = sum2(number1, number2);
        result.print();
//        LinkedList<Integer> result = sum(number1, number2);
//        result.print();
    }

    private LinkedList<Integer> sum2(LinkedList<Integer> number1, LinkedList<Integer> number2) {
        LinkedList<Integer> number1Reverse = reverse(number1);
        LinkedList<Integer> number2Reverse = reverse(number2);
        LinkedList<Integer> result = sum(number1Reverse, number2Reverse);
        return reverse(result);
    }

    private LinkedList<Integer> reverse(LinkedList<Integer> number) {
        LinkedList<Integer> reverse = new LinkedList<>();
        LinkedList<Integer>.Node<Integer> itr = number.head;
        while (itr != null) {
            reverse.prepend(itr.data);
            itr = itr.next;
        }
        return reverse;
    }

    private LinkedList<Integer> sum(LinkedList<Integer> number1, LinkedList<Integer> number2) {
        int carry = 0;

        LinkedList<Integer>.Node<Integer> itr1 = number1.head;
        LinkedList<Integer>.Node<Integer> itr2 = number2.head;
        LinkedList<Integer> result = new LinkedList<>();

        while (itr1 != null && itr2 != null) {
            int sum = itr1.data + itr2.data;
            sum += carry;

            int remainder = sum % 10;
            carry = sum / 10;

            result.append(remainder);

            itr1 = itr1.next;
            itr2 = itr2.next;
        }

        while (itr1 != null) {
            int sum = itr1.data + carry;
            int remainder = sum % 10;
            carry = sum / 10;
            result.append(remainder);
            itr1 = itr1.next;
        }

        while (itr2 != null) {
            int sum = itr2.data + carry;
            int remainder = sum % 10;
            carry = sum / 10;
            result.append(remainder);
            itr2 = itr2.next;
        }

        return result;
    }
}
