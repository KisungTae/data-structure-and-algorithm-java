package com.company.moderate;

//LRU Cache: Design and build a "least recently used" cache, which evicts the least recently used item.
//        The cache should map from keys to values (allowing you to insert and retrieve a value associated
//        with a particular key) and be initialized with a max size. When it is full, it should evict the least
//        recently used item. You can assume the keys are integers and the values are strings.


import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Question25 {
    public Question25() {
        int[] keys = {1, 2, 3, 4, 5, 6, 7, 8};
        String[] values = {"a", "b", "c", "d", "e", "f", "g", "h"};

        Cache cache = new Cache(5);

        for (int i = 0; i < keys.length; i++) {
            cache.add(keys[i], values[i]);
        }
        cache.print();
        System.out.println("");
        cache.find(5);
        System.out.println("");
        cache.print();

    }

    class Cache {
        public Node head;
        public Node tail;
        public int maxSize;
        public int size;
        public Map<Integer, Node> nodeMap = new HashMap<>();

        public Cache(int maxSize) {
            this.maxSize = maxSize;
        }

        public void add(int key, String value) {
            if (nodeMap.containsKey(key)) return;
            Node node = new Node(value);
            nodeMap.put(key, node);

            if (head == null) {
                head = node;
                tail = head;
                size++;
            } else {
                if (size >= maxSize) {
                    if (head == tail) {
                        head = node;
                        tail = head;
                    } else {
                        tail = tail.left;
                        tail.right = null;
                        node.right = head;
                        head.left = node;
                        head = node;
                    }
                } else {
                    node.right = head;
                    head.left = node;
                    head = node;
                    size++;
                }
            }
        }

        public String find(int key) {
            Node node = nodeMap.get(key);
            if (node == null) return null;
            System.out.println("find and use: " + node.data);

            if (head == tail) return node.data;

            Node left = node.left;
            Node right = node.right;

            left.right = right;
            right.left = left;

            node.left = null;
            node.right = head;
            head.left = node;
            head = node;

            return node.data;
        }

        public void print() {
            Node itr = head;
            while (itr != null) {
                System.out.print(itr.data + " ==> ");
                itr = itr.right;
            }
            System.out.print("END");
        }

    }

    class Node {
        public String data;
        public Node left;
        public Node right;

        public Node(String data) {
            this.data = data;
        }
    }
}
