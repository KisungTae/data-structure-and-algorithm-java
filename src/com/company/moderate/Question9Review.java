package com.company.moderate;

//Operations: Write methods to implement the multiply, subtract, and divide operations for integers.
//        The results of all of these are integers. Use only the add operator.

// 1:10

public class Question9Review {
    public Question9Review() {

        int a = 100;
        int b = 10;

        System.out.println(negate(103));

    }

    private int negate(int num) {
        if (num == 0) return 0;

        int sign = num > 0 ? -1 : 1;
        int add = sign;
        int negatedNum = 0;

        while (true) {
            int nextNum = num + add;
            if (nextNum == 0) {
                negatedNum += add;
                break;
            }

            int currSign = nextNum > 0 ? 1 : -1;
            if (currSign == sign) {
                add = sign;
            } else {
                negatedNum += add;
                add += add;
                num = nextNum;
            }
        }

        return negatedNum;
    }

    private int subtract(int a, int b) {

        return 0;
    }

    private int multiply(int a, int b) {
        if (a == 0 || b == 0) return 0;

        int smaller = Math.min(a, b);
        int bigger = Math.max(a, b);

        for (int i = 0; i < Math.abs(smaller); i++) {
            bigger += bigger;
        }



        if ((a > 0 && b > 0) || (a < 0 && b < 0)) {

        } else {

        }

        return 1;
    }
}
