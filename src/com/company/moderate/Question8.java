package com.company.moderate;

//English Int: Given any integer, print an English phrase that describes the integer (e.g., "One Thousand,
//        Two Hundred Thirty Four").

// 10:36

public class Question8 {

    String[] bases = {"", "thousand", "million", "billion"};
    String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
                      "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    String[] tenth = {};
    String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public Question8() {
        int num = 340;
        System.out.println(num + " = " + print(num));
    }

    private String print(int num) {
        if (num == 0) return "zero";

        StringBuilder stringBuilder = new StringBuilder();
        int base = 0;
        while (num > 0) {
            int remainder = num % 1000;
            String numString = get(remainder) + " " + bases[base] + " ";
            stringBuilder.insert(0, numString);
            num /= 1000;
            base++;
        }

        return stringBuilder.toString();
    }

    private String get(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int hundredDigit = num / 100;

        if (hundredDigit > 0) {
            stringBuilder.append(ones[hundredDigit]).append(" ").append("hundred").append(" ");
        }

        num %= 100;

        if (num >= 10 && num < 20) {
            stringBuilder.append(ones[num]);
            return stringBuilder.toString();
        }

        int tenDigit = num / 10;
        stringBuilder.append(tens[tenDigit]).append(" ");

        num %= 10;

        stringBuilder.append(ones[num]);

        return stringBuilder.toString();
    }


}
