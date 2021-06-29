package com.company.arraysandstrings;

//URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
//        has sufficient space at the end to hold the additional characters, and that you are given the "true"
//        length of the string. (Note: if implementing in Java, please use a character array so that you can
//        perform this operation in place.)
//        EXAMPLE
//        Input: "Mr John Smith ", 13
//        Output: "Mr%20John%20Smith"


import java.util.Arrays;

public class Question3 {
    public Question3() {
        char[] input = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        int size = 13;
        urlify(input, size);
        System.out.println(Arrays.toString(input));
    }

    private void urlify(char[] input, int size) {
        int spaces = 0;

        for (int i = 0; i < size; i++) if (input[i] == ' ') spaces++;

        int newIndex = size - 1 + (spaces * 2);
        for (int i = size - 1; i >= 0; i--) {
            char ch = input[i];
            if (ch == ' ') {
                input[newIndex] = '0';
                newIndex--;
                input[newIndex] = '2';
                newIndex--;
                input[newIndex] = '%';
            } else {
                input[newIndex] = input[i];
            }
            newIndex--;
        }
    }
}
