package com.company.moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://stackoverflow.com/questions/19326125/what-is-the-time-complexity-of-this-hash-function


//T9: On old cell phones, users typed on a numeric keypad and the phone would provide a list of
//        words that matched these numbers. Each digit mapped to a set of O - 4 letters. Implement an algorithm
//        to return a list of matching words, given a sequence of digits. You are provided a list of valid
//        words (provided in whatever data structure you'd like). The mapping is shown in the diagram below:
//        EXAMPLE
//        Input:
//        Output:
//        8733
//        tree, used

// 10:49

public class Question20Review {
    public Question20Review() {

        String[] arr = {"used", "tree", "most", "banana", "apple", "call", "is"};

        Graph graph = new Graph();
        for (String word : arr) {
            graph.addWord(word);
        }

        Map<Character, char[]> keyboard = new HashMap<>();
        keyboard.put('1', null);
        keyboard.put('2', new char[]{'a', 'b', 'c'});
        keyboard.put('3', new char[]{'d', 'e', 'f'});
        keyboard.put('4', new char[]{'g', 'h', 'i'});
        keyboard.put('5', new char[]{'j', 'k', 'l'});
        keyboard.put('6', new char[]{'m', 'n', 'o'});
        keyboard.put('7', new char[]{'p', 'q', 'r', 's'});
        keyboard.put('8', new char[]{'t', 'u', 'v'});
        keyboard.put('9', new char[]{'w', 'x', 'y', 'z'});
        keyboard.put('0', null);

        String input = "226262";

        ArrayList<String> words = new ArrayList<>();
        findWords(keyboard, graph.children,  input, 0, "", words);

        System.out.println(words);
    }

    private void findWords(Map<Character, char[]> keyboard,
                                   Map<Character, Node> children,
                                   String input,
                                   int index,
                                   String prefix,
                                   ArrayList<String> words) {

        char ch = input.charAt(index);
        char[] keys = keyboard.get(ch);

        for (char key : keys) {
            Node node = children.get(key);

            if (index == input.length() - 1) {
                if (node != null && node.children != null && node.children.containsKey('*'))
                    words.add(prefix + key);
                continue;
            }

            if (node != null)
                findWords(keyboard, node.children, input, index + 1, prefix + key, words);
        }
    }

    class Graph {
        public Map<Character, Node> children = new HashMap<>();

        public void print() {
            printHelper(children, "");
        }

        public void printHelper(Map<Character, Node> children, String prefix) {
            if (children == null || children.size() == 0) return;

            for (Map.Entry<Character, Node> entry : children.entrySet()) {
                if (entry.getKey() == '*') {
                    prefix += entry.getKey();
                    System.out.println(prefix);
                    return;
                }
                printHelper(entry.getValue().children, prefix + entry.getKey());
            }
        }

        public void addWord(String word) {
            char ch = word.charAt(0);
            Node node = children.get(ch);
            if (node == null) {
                node = new Node(ch);
                children.put(node.data, node);
            }
            addWordHelper(node, 1, word);
        }

        private void addWordHelper(Node node, int index, String word) {
            if (index >= word.length()) {
                node.children.put('*', null);
                return;
            }

            char ch = word.charAt(index);
            Node child = node.children.get(ch);
            if (child == null)
                child = new Node(ch);

            node.children.put(ch, child);
            addWordHelper(child, index + 1, word);
        }
    }


    class Node {
        public char data;
        public Map<Character, Node> children = new HashMap<>();

        public Node(char data) {
            this.data = data;
        }
    }
}
