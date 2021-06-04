package com.company.recursionanddynamicprogramming;

public class Question8Review {
    public Question8Review() {
        String str = "ab";
        permutation("", str);
    }

    private void permutation(String prefix, String remainder) {
        if (remainder.isEmpty()) System.out.println(prefix);

        for (int i = 0; i < remainder.length(); i++) {
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1);

            char mid = remainder.charAt(i);
            permutation(prefix + mid, before + after);
        }
    }
}
