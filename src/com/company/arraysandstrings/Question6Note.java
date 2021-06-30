package com.company.arraysandstrings;

//String Compression: Implement a method to perform basic string compression using the counts
//        of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
//        "compressed" string would not become smaller than the original string, your method should return
//        the original string. You can assume the string has only uppercase and lowercase letters (a - z).


// string concatenation operates in O(n^2) time because every time you concatenate, you need to look through previous
// characters, e.g. like + like = likelike --> likelike + like = likelikelieke, see the second loop, we need to
// loop through the previous likelike.

public class Question6Note {
    public Question6Note() {
        String input = "aabcccccaaa";
        System.out.println(input + " compressed to: " + compress(input));
    }

    private String compress(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        char curr = input.charAt(0);
        int count = 0;
        for (char ch : input.toCharArray()) {
            if (ch == curr) count++;
            else {
                stringBuilder.append(curr);
                stringBuilder.append(count);
                curr = ch;
                count = 1;
            }
        }
        stringBuilder.append(curr);
        stringBuilder.append(count);
        return stringBuilder.toString();
    }
}
