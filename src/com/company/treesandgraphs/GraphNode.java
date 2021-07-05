package com.company.treesandgraphs;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    public enum Status {
        NOT_VISITED,
        VISITING,
        VISITED
    }

    public Status status = Status.NOT_VISITED;
    public int data;
    public List<GraphNode> children = new ArrayList<>();

    public GraphNode(int data) {
        this.data = data;
    }
}
