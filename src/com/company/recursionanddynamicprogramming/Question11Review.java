package com.company.recursionanddynamicprogramming;

//Coins: Given an infinite number of quarters (25 cents), dimes (1 O cents), nickels (5 cents), and
//        pennies (1 cent), write code to calculate the number of ways of representing n cents.

// 7:42

public class Question11Review {
    public Question11Review() {
        represent(15);
    }

    private void represent(int current) {
        if (current < 0) return;
        if (current < 5) {
            System.out.println("current: " + current);
            return;
        }

        represent(current - 25);
        represent(current - 10);
        represent(current - 5);
        represent(0);
    }
}
