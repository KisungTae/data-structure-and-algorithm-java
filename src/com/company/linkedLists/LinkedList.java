package com.company.linkedLists;

import java.util.Random;

public class LinkedList<T> {

    public Node<T> head;
    public Node<T> tail;

    public void append(T data) {
        Node<T> node = new Node<>(data);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
    }

    public void remove(Node<T> node) {
        Node<T> prev = node.prev;


        Node<T> next = node.next;
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

    public class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }
}
