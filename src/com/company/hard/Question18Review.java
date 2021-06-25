package com.company.hard;

//Shortest Supersequence: You are given two arrays, one shorter (with all distinct elements) and one
//        longer. Find the shortest subarray in the longer array that contains all the elements in the shorter
//        array. The items can appear in any order.
//        EXAMPLE
//        Input:
//        {1, 5, 9}
//        {7, 5, 9, 0, 2, 1, 3, 5. 7, 9. 1, 1, 5, 8, 8, 9, 7}
//        Output:[7, 10] (the underlined portion above)

// 11:27

import java.util.*;

public class Question18Review {
    public Question18Review() {
        int[] shorter = {1, 5, 9};
        int[] longer = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};

        ArrayList<Node> nodes = new ArrayList<>();

        Set<Integer> shorts = new HashSet<>();
        for (int num : shorter) {
            shorts.add(num);
        }

        for (int i = 0; i < longer.length; i++) {
            int num = longer[i];
            if (shorts.contains(num))
                nodes.add(new Node(i, num));
        }

        int left = 0;
        int right = 0;

        int minLeft = 0;
        int minRight = 0;
        int min = Integer.MAX_VALUE;
        int curr_size = 0;
        Map<Integer, Integer> memo = new HashMap<>();

        while (right <= nodes.size()) {
            if (curr_size == shorter.length) {
                Node leftNode = nodes.get(left);
                Node rightNode = nodes.get(right - 1);

                int diff = rightNode.index - leftNode.index;
                if (diff < min) {
                    minLeft = leftNode.index;
                    minRight = rightNode.index;
                    min = diff;
                }


                int count = memo.get(leftNode.data);
                count--;
                memo.put(leftNode.data, count);
                if (count <= 0) curr_size--;
                left++;
                continue;
            }

            if (right == nodes.size()) break;

            Node node = nodes.get(right);

            if (memo.containsKey(node.data)) {
                int count = memo.get(node.data);
                if (count == 0) curr_size++;
                count++;
                memo.put(node.data, count);
            } else {
                memo.put(node.data, 1);
                curr_size++;
            }
            right++;
        }

        System.out.println("left: " + minLeft + " | right: " + minRight);
    }

    class Node {
        public int index;
        public int data;

        public Node(int index, int data) {
            this.index = index;
            this.data = data;
        }
    }
}
