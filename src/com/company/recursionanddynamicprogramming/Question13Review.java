package com.company.recursionanddynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Question13Review {

//    Stack of Boxes: You have a stack of n boxes, with widths wi , heights hi, and depths di. The boxes
//    cannot be rotated and can only be stacked on top of one another if each box in the stack is strictly
//    larger than the box above it in width, height, and depth. Implement a method to compute the
//    height of the tallest possible stack. The height of a stack is the sum of the heights of each box.

//    9:34
//    1:45

    public Question13Review() {
        int size = 10;
        Box[] boxes = createBoxes(size);
        Arrays.sort(boxes);
        print(boxes);

        int maxHeight = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < boxes.length; i++) {
            int height = count(boxes, i, memo);
            maxHeight = Math.max(height, maxHeight);
        }
        System.out.println("max height: " + maxHeight);
    }

    private int count(Box[] boxes, int index, HashMap<Integer, Integer> memo) {
        if (index >= boxes.length) return 0;
        if (memo.containsKey(index)) return memo.get(index);

        int maxHeight = 0;
        for (int i = index + 1; i < boxes.length; i++) {
            Box box = boxes[i];
            if (box.canBeOnTopOf(boxes[index])) {
                int height = count(boxes, i, memo);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += boxes[index].height;
        memo.put(index, maxHeight);
        return maxHeight;
    }

    private void print(Box[] boxes) {
        for (Box box : boxes) System.out.println(box);
    }

    private Box[] createBoxes(int size) {
        Box[] boxes = new Box[size];
        Random random = new Random();
        int max = 20;

        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new Box(random.nextInt(max) + 1, random.nextInt(max) + 1, random.nextInt(max) + 1);
        }
        return boxes;
    }


    class Box implements Comparable<Box> {
        public int height;
        public int width;
        public int depth;

        public Box(int height, int width, int depth) {
            this.height = height;
            this.width = width;
            this.depth = depth;
        }

        public boolean canBeOnTopOf(Box box) {
            if (this.height > box.height) return false;
            if (this.width > box.width) return false;
            if (this.depth > box.depth) return false;
            return true;
        }


        @Override public String toString() {
            return "Box{" +
                   "height=" + height +
                   ", width=" + width +
                   ", depth=" + depth +
                   '}';
        }

        @Override public int compareTo(Box o) {
            return Integer.compare(o.height, this.height);
        }
    }
}
