package com.company.treesandgraphs;

//Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
//        route between two nodes.

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Question1 {
    public Question1() {
        Graph graph = new Graph();
        GraphNode graphNode1 = new GraphNode(1);
        GraphNode graphNode2 = new GraphNode(2);
        GraphNode graphNode3 = new GraphNode(3);
        GraphNode graphNode4 = new GraphNode(4);
        GraphNode graphNode5 = new GraphNode(5);
        GraphNode graphNode6 = new GraphNode(6);
        GraphNode graphNode7 = new GraphNode(7);
        GraphNode graphNode8 = new GraphNode(8);

//        graphNode1.children.add(graphNode2);
//        graphNode1.children.add(graphNode3);
//        graphNode3.children.add(graphNode4);
//        graphNode3.children.add(graphNode5);
//        graphNode3.children.add(graphNode6);
//        graphNode5.children.add(graphNode8);
//        graphNode6.children.add(graphNode7);

//        graph.children.add(graphNode1);
//        graph.children.add(graphNode3);
//        graph.children.add(graphNode5);

        System.out.println("find path: " + findPath(graphNode1, graphNode7));

    }

    private boolean findPath(GraphNode fromNode, GraphNode toNode) {
        LinkedList<GraphNode> graphNodes = new LinkedList<>();
        graphNodes.add(fromNode);

        while (!graphNodes.isEmpty()) {
            GraphNode graphNode = graphNodes.remove(0);
            graphNode.status = GraphNode.Status.VISITED;
            if (graphNode == toNode) return true;

            for (int i = 0; i < graphNode.children.size(); i++) {
//                GraphNode child = graphNode.children.get(i);
//                if (child.status == GraphNode.Status.NOT_VISITED) {
//                    child.status = GraphNode.Status.VISITING;
//                    graphNodes.add(child);
//                }
            }
        }

        return false;
    }
}
