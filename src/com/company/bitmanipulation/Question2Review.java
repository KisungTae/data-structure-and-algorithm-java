package com.company.bitmanipulation;

public class Question2Review {

    public Question2Review() {
        binaryToString();
    }

    private void binaryToString() {
        double num = 0.375;

        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {

            if (stringBuilder.length() > 32) {
                stringBuilder.setLength(0);
                stringBuilder.append("ERROR");
                break;
            }

            double multiply = num * 2.0;
            if (multiply >= 1) {
                num = multiply - 1.0;
                stringBuilder.append("1");
            } else {
                num = multiply;
                stringBuilder.append("0");
            }

        }

        System.out.println(stringBuilder.toString());
    }


}
