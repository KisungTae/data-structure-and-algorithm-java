package com.company.treesandgraphs;

//Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
//        projects, where the second project is dependent on the first project). All of a project's dependencies
//        must be built before the project is. Find a build order that will allow the projects to be built. If there
//        is no valid build order, return an error.
//        EXAMPLE
//        Input:
//        projects: a, b, c, d, e, f
//        dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
//        Output: f, e, a, b, d, c


import com.company.Pair;

import java.util.*;

public class Question7Review {
    public Question7Review() {
        char[] projects = {'a', 'b', 'c', 'd', 'e', 'f'};
        ArrayList<Pair<Character>> dependencies = new ArrayList<>();
        dependencies.add(new Pair<>('a', 'd'));
        dependencies.add(new Pair<>('f', 'b'));
        dependencies.add(new Pair<>('b', 'd'));
        dependencies.add(new Pair<>('f', 'a'));
        dependencies.add(new Pair<>('d', 'c'));

        System.out.println(build(projects, dependencies).toString());
    }

    private ArrayList<Character> build(char[] projects, ArrayList<Pair<Character>> dependencies) {
        HashMap<Character, GraphNode<Character>> graphNodes = new HashMap<>();
        Graph<Character> graph = new Graph<>();
        for (char project : projects) {
            GraphNode<Character> graphNode = new GraphNode<Character>(project);
            graphNodes.put(project, graphNode);
            graph.children.put(project, graphNode);
        }

        for (Pair<Character> dependency : dependencies) {
            GraphNode<Character> parent = graphNodes.get(dependency.left);
            GraphNode<Character> child = graphNodes.get(dependency.right);

            if (child.children.containsKey(parent.data)) throw new RuntimeException("not valid build order");

            parent.children.put(child.data, child);
            graph.children.remove(child.data);
        }

        Queue<GraphNode<Character>> queue = new LinkedList<>();

        for (Map.Entry<Character, GraphNode<Character>> entry : graph.children.entrySet()) {
            entry.getValue().status = GraphNode.Status.VISITING;
            queue.add(entry.getValue());
        }

        ArrayList<Character> buildOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            GraphNode<Character> graphNode = queue.poll();
            buildOrder.add(graphNode.data);
            graphNode.status = GraphNode.Status.VISITED;

            for (Map.Entry<Character, GraphNode<Character>> entry : graphNode.children.entrySet()) {
                GraphNode<Character> child = entry.getValue();
                if (child.status == GraphNode.Status.NOT_VISITED) {
                    child.status = GraphNode.Status.VISITING;
                    queue.add(child);
                }
            }
        }

        return buildOrder;
    }
}
