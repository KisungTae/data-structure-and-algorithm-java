package com.company.recursionanddynamicprogramming;

public class Question7 {

    public Question7() {
        String str = "abc";
//        permutation("", str);
        permutationPrint("", str);
    }

    private void permutationPrint(String prefix, String remain) {
        if (remain.isEmpty()) {
            System.out.println("prefix: " + prefix);
            return;
        }

        for (int i = 0; i < remain.length(); i++) {
            char middle = remain.charAt(i);
            String newRemain = remain.substring(0, i) + remain.substring(i + 1);
            permutationPrint(prefix + middle, newRemain);
        }

    }








































    private void permutation(String left, String right) {
        if (right.isEmpty()) System.out.println(left);
        
        for (int i = 0; i < right.length(); i++) {
            String prefix = left + right.charAt(i);
            String remain = right.substring(0, i) + right.substring(i + 1);
            permutation(prefix, remain);
        }
    }
}
