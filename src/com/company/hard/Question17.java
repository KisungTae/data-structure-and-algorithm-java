package com.company.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Question17 {

    public Question17() {
        String b = "customercecus";
        String[] t = {"cus", "tom", "service", "stomer", "cst", "vice"};

        Graph graph = initGraph(b);



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
    }
}
