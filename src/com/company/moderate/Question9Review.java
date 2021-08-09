package com.company.moderate;

//Operations: Write methods to implement the multiply, subtract, and divide operations for integers.
//        The results of all of these are integers. Use only the add operator.

// 1:10

public class Question9Review {
    public Question9Review() {
        int a = 22;
        int b = 10;

        System.out.println(negateAnswer(23));
//        System.out.println(multiply(20, -1));
//        System.out.println(divide(-20, 7));
    }

    private int negateAnswer(int num) {
        int sign = num > 0 ? -1 : 1;
        int delta = sign;
        int negate = 0;
        while (num != 0) {
            System.out.println("delta: " + delta);
            boolean differentSign = (num + delta > 0) != (num > 0);
            if (num + delta != 0 && differentSign) {
                delta = sign;
            }

            num += delta;
            negate += delta;
            delta += delta;
        }
        return negate;
    }

    private int negate(int num) {
        int sign = num > 0 ? -1 : 1;
        int countSign = num > 0 ? 1 : -1;
        int count = 0;
        int negate = 0;
        while (count != num) {
            negate += sign;
            count += countSign;
        }
        return negate;
    }

    private int minus(int a, int b) {
        return a + negate(b);
    }

    private int multiply(int a, int b) {
        int count = abs(b);
        int sign = 0;

        if (a > 0 && b > 0) sign = a;
        else if (a < 0 && b > 0) sign = a;
        else if (a > 0 && b < 0) sign = negate(a);
        else sign = negate(a);

        int multiply = 0;
        while (count > 0) {
            multiply += sign;
            count--;
        }
        return multiply;
    }

    private int divide(int a, int b) {
        int sign = (a > 0 && b > 0) || (a < 0 && b < 0) ? 1 : -1;
        int quotient = 0;
        int absA = abs(a);
        int absB = abs(b);
        int countB = absB;

        while (countB <= absA) {
            countB += absB;
            quotient += sign;
        }

        return quotient;
    }

    private int abs(int num) {
        if (num >= 0) return num;
        else return negate(num);
    }


}
