package com.company.stacksandqueues;

//Stack Min: How would you design a stack which, in addition to push and pop, has a function min
//        which returns the minimum element? Push, pop and min should all operate in 0(1) time.

import java.util.Stack;

public class Question2 {
    public Question2() {
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(8);
        minStack.push(13);
        minStack.push(15);
        minStack.push(8);
        minStack.push(10);
        minStack.push(7);
        minStack.push(10);
        minStack.push(10);


        System.out.println("min: " + minStack.min());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();

        System.out.println("min: " + minStack.min());
    }

    class MinStack {
        public Stack<Integer> stack = new Stack<>();
        public Stack<Integer> min = new Stack<>();

        public void push(int data) {
            stack.push(data);
            if (min.isEmpty() || data <= min.peek())
                min.push(data);
        }

        public int pop() {
            if (stack.peek().equals(min.peek())) min.pop();
            return stack.pop();
        }

        public int min() {
            return min.peek();
        }
    }
}
