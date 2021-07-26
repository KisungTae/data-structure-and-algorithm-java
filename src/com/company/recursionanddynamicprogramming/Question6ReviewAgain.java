package com.company.recursionanddynamicprogramming;

import java.util.LinkedList;
import java.util.Stack;

// 8:34

public class Question6ReviewAgain {
    public Question6ReviewAgain() {
        Stack<Integer> tower1 = new Stack<>();
        Stack<Integer> tower2 = new Stack<>();
        Stack<Integer> tower3 = new Stack<>();

        tower1.push(1);
        tower1.push(2);
        tower1.push(3);
//        tower1.push(4);

        move(3, tower1, tower2, tower3);
    }

    private void move(int n, Stack<Integer> start, Stack<Integer> buffer, Stack<Integer> dest) {
        if (n > 0) {
            int value = start.pop();

            // empty dest to buffer
            doMove(dest, start, buffer);

            // move to dest
            dest.push(value);

            // empty buffer to dest
            doMove(buffer, start, dest);
        }
    }

    private void doMove(Stack<Integer> start, Stack<Integer> buffer, Stack<Integer> dest) {
        while (!start.isEmpty()) {
            int value = start.pop();



        }
    }

    public class Tower {

    }


}
