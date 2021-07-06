package com.company.treesandgraphs;

import java.util.*;

public class GraphNode<T> {

    public enum Status {
        NOT_VISITED,
        VISITING,
        VISITED
    }

    public Status status = Status.NOT_VISITED;
    public T data;
//    public List<GraphNode> children = new ArrayList<>();
    public HashMap<T, GraphNode<T>> children = new HashMap<>();


    public GraphNode(T data) {
        this.data = data;
    }
}
