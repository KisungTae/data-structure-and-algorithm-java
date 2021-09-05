package com.company.hard;

//Shuffle: Write a method to shuffle a deck of cards. It must be a perfect shuffle-in other words, each
//        of the 52! permutations of the deck has to be equally likely. Assume that you are given a random
//        number generator which is perfect.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Question2 {
    public Question2() {
        int cardSize = 52;
        int[] cards = new int[cardSize];
        for (int i = 0; i < cardSize; i++) {
            cards[i] = i;
        }
        shuffle(cards);
    }

    private void shuffle(int[] cards) {
        Random random = new Random();
        for (int i = 1; i < cards.length; i++) {
            int k = random.nextInt(i);
            int temp = cards[k];
            cards[k] = cards[i];
            cards[i] = temp;
        }
    }
}
