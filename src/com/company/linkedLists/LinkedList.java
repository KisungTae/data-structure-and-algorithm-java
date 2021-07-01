package com.company.linkedLists;

import java.util.Random;

public class LinkedList<T> {

    public Node<T> head;
    public Node<T> tail;
    public int size;

    public void append(T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        size++;
    }

    public void prepend(T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void remove(Node<T> node) {
        if (node.prev != null)
            node.prev.next = node.next;

        if (node.next != null)
            node.next.prev = node.prev;

        if (node == head) {
            head = node.next;
        } else if (node == tail) {
            tail = node.prev;
        }
        size--;
    }

    public void print() {
        Node<T> itr = head;
        while (itr != null) {
            System.out.print(itr.data);
            System.out.print(" ==> ");
            itr = itr.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void printBackwards() {
        Node<T> itr = tail;
        while (itr != null) {
            System.out.print(itr.data);
            System.out.print(" ==> ");
            itr = itr.prev;
        }
        System.out.print("null");
        System.out.println();
    }

    public static LinkedList<Integer> generateRandomLinkedList(int size) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            linkedList.append(random.nextInt(size));
        }
        return linkedList;
    }

    public static LinkedList<Integer> generateIncrementLinkedList(int size) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.append(i);
        }
        return linkedList;
    }


    public class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }
}
