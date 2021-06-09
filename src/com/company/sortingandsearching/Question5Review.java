package com.company.sortingandsearching;

//Sparse Search: Given a sorted array of strings that is interspersed with empty strings, write a
//        method to find the location of a given string.
//        EXAMPLE
// input: ball, {"at", "", "", "", "ball", "", "", "car", "", "", "dad", ""}
// output: 4

// 10:39

public class Question5Review {

    public Question5Review() {
        String[] arr = {"", "at", "", "ball", "", "bull", "", "", "", "", "car", "", "", "dad", ""};
        String input = "a";

        System.out.println("index of " + input + " is " + find(arr, input, 0, arr.length - 1));

    }

    private int find(String[] arr, String input, int left, int right) {
        System.out.println("left: " + left + " right: " + right );
        if (left > right) return -1;

        int midIndex = (left + right) / 2;
        String midValue = arr[midIndex];

        if (midValue.isEmpty()) {
            int leftMostIndex = leftMostIndex(arr, midIndex, left);

            if (leftMostIndex == -1) {
                int rightMostIndex = rightMostIndex(arr, midIndex, right);
                if (rightMostIndex == -1) return -1;

                String rightMostValue = arr[rightMostIndex];
                int rightCompared = compare(input, rightMostValue);

                if (rightCompared == 0) return rightMostIndex;
                else if (rightCompared == -1) return -1;
                else return find(arr, input, rightMostIndex + 1, right);
            } else {
                String leftMostValue = arr[leftMostIndex];
                int leftCompared = compare(input, leftMostValue);

                if (leftCompared == 0) return leftMostIndex;
                else if (leftCompared == -1) return find(arr, input, left, leftMostIndex - 1);
                else {
                    int rightMostIndex = rightMostIndex(arr, midIndex, right);
                    if (rightMostIndex > right) return -1;

                    String rightMostValue = arr[rightMostIndex];
                    int rightCompared = compare(input, rightMostValue);

                    if (rightCompared == 0) return rightMostIndex;
                    else if (rightCompared == -1) return -1;
                    else return find(arr, input, rightMostIndex + 1, right);
                }
            }
        }

        int compared = compare(input, midValue);

        if (compared == 0) return midIndex;
        else if (compared == -1) return find(arr, input, left, midIndex - 1);
        else return find(arr, input, midIndex + 1, right);
    }

    private int compare(String leftStr, String rightStr) {
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < leftStr.length() && rightIndex < rightStr.length()) {
            char leftChar = leftStr.charAt(leftIndex);
            char rightChar = rightStr.charAt(rightIndex);

            if (leftChar < rightChar) return -1;
            else if (leftChar > rightChar) return 1;

            leftIndex++;
            rightIndex++;
        }

        int leftLength = leftStr.length();
        int rightLength = rightStr.length();

        if (leftLength == rightLength) return 0;
        else if (leftLength > rightLength) return 1;
        else return -1;
    }

    private int leftMostIndex(String[] arr, int index, int leftEnd) {
        while (index > leftEnd && arr[index].isEmpty()) {
            index--;
        }
        if (arr[index].isEmpty()) return  -1;
        return index;
    }

    private int rightMostIndex(String[] arr, int index, int rightEnd) {
        while (index < rightEnd && arr[index].isEmpty()) {
            index++;
        }
        if (arr[index].isEmpty()) return  -1;
        return index;
    }


}
