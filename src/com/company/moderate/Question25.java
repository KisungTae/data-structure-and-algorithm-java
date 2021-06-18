package com.company.moderate;

//LRU Cache: Design and build a "least recently used" cache, which evicts the least recently used item.
//        The cache should map from keys to values (allowing you to insert and retrieve a value associated
//        with a particular key) and be initialized with a max size. When it is full, it should evict the least
//        recently used item. You can assume the keys are integers and the values are strings.


import java.util.HashMap;
import java.util.Map;

public class Question25 {
    public Question25() {
        int[] keys = {1, 2, 3, 4, 5, 6, 7, 8};
        String[] values = {"a", "b", "c", "d", "e", "f", "g"};

        Cache cache = new Cache(5);

        for (int i = 0; i < keys.length; i++) {
            
        }

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


        }

        public String find(int key) {

            return "";
        }

    }

    class Node {
        public String data;
        public Node left;
        public Node right;
    }
}
