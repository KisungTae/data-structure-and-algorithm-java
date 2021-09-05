package com.company.hard;

//Re-Space: Oh, no! You have accidentally removed all spaces, punctuation, and capitalization in a
//        lengthy document. A sentence like "I reset the computer. It still didn't boot!"
//        became "iresetthecomputeri tstilldidntboot''. You'll deal with the punctuation and capitalization
//        later; right now you need to re-insert the spaces. Most of the words are in a dictionary but
//        a few are not. Given a dictionary (a list of strings) and the document (a string), design an algorithm
//        to unconcatenate the document in a way that minimizes the number of unrecognized characters.
//        EXAMPLE:
//        Input: jesslookedjustliketimherbrother
//        Output: jess looked just like tim her brother (7 unrecognized characters)


import java.util.HashSet;

public class Question13ReviewAgain {
    public Question13ReviewAgain() {
        String input = "jesslookedjustliketimherbrother";
        HashSet<String> words = new HashSet<>();
        words.add("looked");
        words.add("just");
        words.add("like");
        words.add("tim");
        words.add("her");
        words.add("brother");
//        words.add("jesslooked");
//        words.add("justlike");
//        words.add("herbrother");
//        words.add("justliketim");
//        words.add("jessl");
        words.add("edjust");
        words.add("mherb");
        words.add("ther");
//        words.add("im");
//        words.add("et");
//        words.add("ju");
//        words.add("je");


        String abcd = "abcd";
//        words.add("a");
//        words.add("bc");
//        words.add("abc");
        input = "abcd";
        System.out.println("result: " + countAnswer(words, 0, input));
    }

    private Result countAnswer(HashSet<String > dic, int start, String document) {
        if (start >= document.length()) {
            return new Result("", 0);
        }
        int bestInvalid = Integer.MAX_VALUE;
        String partial = "";
        String bestParsed = "";
        int index = start;

        while (index < document.length()) {
            char ch = document.charAt(index);
            partial += ch;
            int invalid = dic.contains(partial) ? 0 : partial.length();
            System.out.println("start: " + start + " | index: " + index + " | partial: " + partial);

            if (invalid < bestInvalid) {

                Result result = countAnswer(dic, index + 1, document);
                if ((invalid + result.count) < bestInvalid) {
                    bestParsed = partial + " " + result.parsed;
                    bestInvalid = invalid + result.count;
                }
            }
            index++;
        }
//        if (bestParsed.length() <= 0) bestParsed = partial;
        return new Result(bestParsed, bestInvalid);

    }



    private void count(HashSet<String> words, String prefix, String remaining, int unrecognizedCount, Result result) {
        if (remaining.length() <= 0) {
            if (unrecognizedCount < result.count) {
                result.count = unrecognizedCount;
                result.parsed = prefix;
            }
            System.out.println(prefix + " : " + unrecognizedCount);
            return;
        }

        for (int i = 1; i <= remaining.length(); i++) {
            String left = remaining.substring(0, i);
            int count = words.contains(left) ? 0 : left.length();
            if ((unrecognizedCount + count) > result.count) continue;
            String right = remaining.substring(i);
            count(words, prefix + " " + left, right, unrecognizedCount + count, result);
        }


    }

    class Result {
        public String parsed;
        public int count;

        public Result(String parsed, int count) {
            this.parsed = parsed;
            this.count = count;
        }

        @Override public String toString() {
            return "Result{" +
                   "document='" + parsed + '\'' +
                   ", unrecognizedCount=" + count +
                   '}';
        }
    }


}
