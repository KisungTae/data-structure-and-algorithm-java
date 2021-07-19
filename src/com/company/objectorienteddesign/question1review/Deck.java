package com.company.objectorienteddesign.question1review;

import java.util.ArrayList;
import java.util.List;

abstract class Deck {
    public List<Card> cards = new ArrayList<>();

    protected void generate() {
        // generate deck of cards
    }

    protected void shuffle() {
        // shuffle cards
    }


}
