package com.company.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Question17Review {

    public Question17Review() {
        String b = "customercecus";
        String[] t = {"cus", "tom", "service", "stomer", "cst", "vice"};

        Graph graph = initGraph(b);
        graph.print(b);

        System.out.println(find("cus", graph).toString());

    }

    private ArrayList<Integer> find(String word, Graph graph) {
        ArrayList<Integer> indices = new ArrayList<>();
        ArrayList<Node> nodes = graph.children.get(word.charAt(0));
        for (Node node : nodes) {
            int index = depthSearch(node, word);
            if (index > -1) indices.add(index);
        }
        return indices;
    }

    private int depthSearch(Node node, String word) {
        int index = 1;
        Node itr = node;
        while (index < word.length()) {
            itr = itr.children.get(word.charAt(index));
            if (itr == null) return -1;
            index++;
        }
        return node.index;
    }

    private Graph initGraph(String b) {
        Graph graph = new Graph();
        Node lastNode = new Node(b.charAt(0), 0);
        ArrayList<Node> initialNodes = new ArrayList<>();
        initialNodes.add(lastNode);
        graph.children.put(b.charAt(0), initialNodes);

        for (int i = 1; i < b.length(); i++) {
            char ch = b.charAt(i);
            Node node = new Node(ch, i);

            lastNode.children.put(ch, node);
            lastNode = node;

            ArrayList<Node> nodes = graph.children.get(ch);
            if (nodes == null) nodes = new ArrayList<>();
            nodes.add(node);
            graph.children.put(ch, nodes);
        }

        return graph;
    }


    class Graph {
        public Map<Character, ArrayList<Node>> children = new HashMap<>();

        public void print(String b) {
            for (char ch : b.toCharArray()) {
                ArrayList<Node> nodes = children.get(ch);
                System.out.println(ch + " - " + nodes.size());
            }
        }
    }

    class Node {
        public char data;
        public int index;
        public Map<Character, Node> children = new HashMap<>();

        public Node(char data, int index) {
            this.data = data;
            this.index = index;
            this.children.put('*', null);
        }

        @Override public String toString() {
            return "Node{" +
                   "data=" + data +
                   ", index=" + index +
                   ", children=" + children +
                   '}';
        }
    }
}
