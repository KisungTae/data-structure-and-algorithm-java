package com.company.stacksandqueues;

import java.util.Stack;

public class Question4 {
    public Question4() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        myQueue.push(6);

        System.out.println("pop: " + myQueue.pop());
        System.out.println("pop: " + myQueue.pop());
        System.out.println("pop: " + myQueue.pop());
        System.out.println("pop: " + myQueue.pop());

        myQueue.push(7);
        myQueue.push(8);
        myQueue.push(9);
        myQueue.push(10);


        System.out.println("pop: " + myQueue.pop());
        System.out.println("pop: " + myQueue.pop());
        System.out.println("pop: " + myQueue.pop());
        System.out.println("pop: " + myQueue.pop());

        System.out.println("pop: " + myQueue.pop());
        System.out.println("pop: " + myQueue.pop());
        System.out.println("pop: " + myQueue.pop());
        System.out.println("pop: " + myQueue.pop());


    }

    class MyQueue {
        public Stack<Integer> stack1 = new Stack<>();
        public Stack<Integer> stack2 = new Stack<>();

        public void push(int data) {
            stack1.push(data);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }
    }
}
