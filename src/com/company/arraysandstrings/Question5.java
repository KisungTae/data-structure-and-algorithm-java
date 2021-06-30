package com.company.arraysandstrings;

//One Away: There are three types of edits that can be performed on strings: insert a character,
//        remove a character, or replace a character. Given two strings, write a function to check if they are
//        one edit (or zero edits) away.
//        EXAMPLE
//        pale, ple -> true
//        pales, pale -> true
//        pale, bale -> true
//        pale, bae -> false


public class Question5 {
    public Question5() {
        String input1 = "pales";
        String input2 = "pele";

        System.out.println(input1 + " and " + input2 + " one edit away: " + check(input1, input2));

    }

    private boolean check(String input1, String input2) {
        String longer = input1.length() > input2.length() ? input1 : input2;
        String shorter = input1.length() > input2.length() ? input2 : input1;

        int longerIndex = 0;
        int shorterIndex = 0;

        boolean foundDifference = false;

        while (longerIndex < longer.length() && shorterIndex < shorter.length()) {
            char longerChar = longer.charAt(longerIndex);
            char shorterChar = shorter.charAt(shorterIndex);

            System.out.println(longerChar + " " + shorterChar);

            if (longerChar != shorterChar) {
                if (foundDifference) return false;
                else foundDifference = true;

                if (longer.length() == shorter.length()) {
                    longerIndex++;
                    shorterIndex++;
                } else longerIndex++;
            } else {
                longerIndex++;
                shorterIndex++;
            }

        }
        return true;
    }
}
