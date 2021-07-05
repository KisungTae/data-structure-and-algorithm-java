package com.company.stacksandqueues;

//Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
//        an additional temporary stack, but you may not copy the elements into any other data structure
//        (such as an array). The stack supports the following operations: push, pop, peek, and is Empty.

import javax.swing.plaf.IconUIResource;
import java.util.Random;
import java.util.Stack;

public class Question5Review {
    public Question5Review() {
        Random random = new Random();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            pushRandom(stack);
        }

        print(stack);
        System.out.println("======================");
        order(stack);
        print(stack);

    }

    private void pushRandom(Stack<Integer> stack) {
        Random random = new Random();
        int data = random.nextInt(50);
        stack.push(data);
//        System.out.println("push: " + data);
    }

    private void order(Stack<Integer> stack) {
        Stack<Integer> buffer = new Stack<>();
        int biggest = Integer.MIN_VALUE;
        int biggestCount = 0;
        int size = stack.size();

        while (size > 0) {
            int count = size;
            while (count > 0) {
                int data = stack.pop();
                if (data > biggest) {
                    biggest = data;
                    biggestCount = 1;
                } else if (data == biggest) {
                    biggestCount++;
                }
                count--;
                buffer.push(data);
            }

            for (int i = 0; i < biggestCount; i++) {
                stack.push(biggest);
            }

            while (!buffer.isEmpty()) {
                int data = buffer.pop();
                if (data == biggest) continue;
                stack.push(data);
            }
            size -= biggestCount;
            biggest = Integer.MIN_VALUE;
            biggestCount = 0;
        }

    }

    private void print(Stack<Integer> stack) {
        Stack<Integer> buffer = new Stack<>();
        while (!stack.isEmpty()) {
            int data = stack.pop();
            buffer.push(data);
            System.out.println("stack: " + data);
        }

        while (!buffer.isEmpty()) {
            stack.push(buffer.pop());
        }
    }

}
