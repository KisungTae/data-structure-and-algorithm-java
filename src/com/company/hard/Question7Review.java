package com.company.hard;

//Baby Names: Each year, the government releases a list of the 10000 most common baby names
//        and their frequencies (the number of babies with that name). The only problem with this is that
//        some names have multiple spellings. For example, "John" and ''.Jon" are essentially the same name
//        but would be listed separately in the list. Given two lists, one of names/frequencies and the other
//        of pairs of equivalent names, write an algorithm to print a new list of the true frequency of each
//        name. Note that if John and Jon are synonyms, and Jon and Johnny are synonyms, then John and
//        Johnny are synonyms. (It is both transitive and symmetric.) In the final list, any name can be used
//        as the "real" name.
//        EXAMPLE
//        Input:
//        Names: John (15), Jon (12), Chris (13), Kris (4), Christopher (19)
//        Synonyms: (Jon, John), (John, Johnny), (Chris, Kris), (Chris, Christopher)
//        Output: John (27), Kris (36)


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Question7Review {
    public Question7Review() {

        HashMap<String, Integer> nameFrequencies = new HashMap<>();
        nameFrequencies.put("John", 15);
        nameFrequencies.put("Jon", 12);
        nameFrequencies.put("Johnny", 13);
        nameFrequencies.put("Chris", 13);
        nameFrequencies.put("Kris", 4);
        nameFrequencies.put("Christopher", 19);
        nameFrequencies.put("Michael", 19);

        ArrayList<Synonym> synonyms = new ArrayList<>();
        synonyms.add(new Synonym("Jon","John"));
        synonyms.add(new Synonym("John", "Johnny"));
        synonyms.add(new Synonym("Chris", "Kris"));
        synonyms.add(new Synonym("Chris", "Christopher"));

        HashMap<String, Integer> frequencies = findFrequencies(nameFrequencies, synonyms);
        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            System.out.println(entry.getKey() + " has " + entry.getValue());
        }

    }

    private HashMap<String, Integer> findFrequencies(HashMap<String, Integer> nameFrequencies, ArrayList<Synonym> synonyms) {
        Graph graph = createGraph(nameFrequencies);
        connectGraph(graph, synonyms);
        return getFrequencies(graph);
    }

    private Graph createGraph(HashMap<String, Integer> nameFrequencies) {
        Graph graph = new Graph();
        for (Map.Entry<String, Integer> entry : nameFrequencies.entrySet()) {
            System.out.println(entry.getKey());
            graph.createNode(entry.getKey(), entry.getValue());
        }
        return graph;
    }

    private void connectGraph(Graph graph, ArrayList<Synonym> synonyms) {
        for (Synonym synonym : synonyms) {
            graph.addChild(synonym.firstName, synonym.secondName);
        }
    }

    private HashMap<String, Integer> getFrequencies(Graph graph) {
        HashMap<String, Integer> names = new HashMap<>();
        for (Map.Entry<String, Node> entry : graph.nodes.entrySet()) {
            Node root = entry.getValue();
            if (!root.visited && root.parent == null) {
                int count = getFrequency(root);
                names.put(root.name, count);
            }
        }
        return names;
    }

    private int getFrequency(Node root) {
        if (root.visited) return 0;
        int count = 0;
        for (Node node : root.children) {
            count += getFrequency(node);
        }
        root.visited = true;
        return count + root.frequency;
    }

    class Graph {
        public HashMap<String, Node> nodes = new HashMap<>();

        public void createNode(String name, int frequency) {
            Node node = new Node(name, frequency);
            nodes.put(name, node);
        }

        public void addChild(String parent, String child) {
            Node parentNode = nodes.get(parent);
            Node childNode = nodes.get(child);
            parentNode.children.add(childNode);
            childNode.parent = parentNode;
        }
    }

    class Node {
        public String name;
        public int frequency;
        public boolean visited = false;
        public Node parent;
        public ArrayList<Node> children = new ArrayList<>();

        public Node(String name, int frequency) {
            this.name = name;
            this.frequency = frequency;
        }
    }


    class Synonym {
        public String firstName;
        public String secondName;

        public Synonym(String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
        }

        @Override public String toString() {
            return "Synonym{" +
                   "firstName='" + firstName + '\'' +
                   ", secondName='" + secondName + '\'' +
                   '}';
        }
    }
}
