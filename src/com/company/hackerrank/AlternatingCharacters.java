package com.company.hackerrank;

public class AlternatingCharacters {
    public static int alternatingCharacters(String s) {
        // Write your code here
        int slow = 0;
        int fast = 1;
        int count = 0;
        while (fast < s.length()) {
            char slowChar = s.charAt(slow);
            char fastChar = s.charAt(fast);

            if (slowChar == fastChar) {
                count++;
                fast++;
            } else {
                slow = fast;
                fast++;
            }
        }

        return count;
    }
}
