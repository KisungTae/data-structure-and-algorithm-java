package com.company.treesandgraphs;

import java.util.ArrayList;

public class BinaryNode<T extends Comparable<?>> {
    public T data;
    public BinaryNode<T> parent;
    public BinaryNode<T> left;
    public BinaryNode<T> right;

    public BinaryNode(T data) {
        this.data = data;
    }


}
