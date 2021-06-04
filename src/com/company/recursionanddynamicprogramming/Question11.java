package com.company.recursionanddynamicprogramming;

//Coins: Given an infinite number of quarters (25 cents), dimes (1 O cents), nickels (5 cents), and
//        pennies (1 cent), write code to calculate the number of ways of representing n cents.

// 4:57

public class Question11 {
    public Question11() {
        represent(0, 10);
    }

    private void represent(int current, int target) {
        if (current > target) return;

        if (current == target) {
            System.out.println("one way");
            return;
        }

        represent(current + 1, target);
        represent(current + 5, target);
        represent(current + 10, target);
        represent(current + 25, target);
    }
}
