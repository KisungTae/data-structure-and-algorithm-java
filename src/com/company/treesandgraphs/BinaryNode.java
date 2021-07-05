package com.company.treesandgraphs;

public class BinaryNode<T extends Comparable<?>> {
    public T data;
    public BinaryNode<T> left;
    public BinaryNode<T> right;

    public BinaryNode(T data) {
        this.data = data;
    }
}
