package com.company.stacksandqueues;

//Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
//        Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
//        threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
//        composed of several stacks and should create a new stack once the previous one exceeds capacity.
//        SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
//        (that is, pop () should return the same values as it would if there were just a single stack).
//        FOLLOW UP
//        Implement a function popAt(int index) which performs a pop operation on a specific substack.


import java.util.ArrayList;
import java.util.Stack;

public class Question3Review {
    public Question3Review() {
        SetOfStack setOfStack = new SetOfStack();
        setOfStack.push(3);
        setOfStack.push(4);
        setOfStack.push(5);
        setOfStack.push(6);
        setOfStack.push(1);
        setOfStack.push(23);
        setOfStack.push(4);
        setOfStack.push(74);

        System.out.println("pop(): " + setOfStack.pop());
        System.out.println("pop(): " + setOfStack.pop());
        System.out.println("pop(): " + setOfStack.pop());
        System.out.println("pop(): " + setOfStack.pop());
        System.out.println("pop(): " + setOfStack.pop());
        System.out.println("pop(): " + setOfStack.pop());
        System.out.println("pop(): " + setOfStack.pop());

    }

    class SetOfStack {
        public int capacity = 3;
        public ArrayList<Stack<Integer>> arrayList = new ArrayList<>();

        public void push(int data) {
            if (arrayList.size() <= 0) {
                Stack<Integer> stack = new Stack<>();
                stack.push(data);
                arrayList.add(stack);
            } else {
                Stack<Integer> stack = arrayList.get(0);
                if (stack.size() >= capacity) {
                    Stack<Integer> newStack = new Stack<>();
                    newStack.push(data);
                    arrayList.add(0, newStack);
                } else {
                    stack.push(data);
                }
            }
        }

        public int pop() {
            Stack<Integer> stack = arrayList.get(0);
            System.out.println("stack size: " + stack.size() + " | arrayList.size(): " + arrayList.size());
            int data = stack.pop();
            if (stack.isEmpty())
                arrayList.remove(0);
            return data;
        }

        public int peek() {
            return arrayList.get(0).peek();
        }
    }
}
