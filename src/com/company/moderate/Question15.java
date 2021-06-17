package com.company.moderate;


//Master Mind: The Game of Master Mind is played as follows:
//        The computer has four slots, and each slot will contain a ball that is red (R). yellow ( Y ). green (G) or
//        blue (B). For example, the computer might have RGGB (Slot #1 is red, Slots #2 and #3 are green, Slot
//        #4 is blue).
//        You, the user, are trying to guess the solution. You might, for example, guess Y RGB.
//        When you guess the correct color for the correct slot, you get a "hit:' If you guess a color that exists
//        but is in the wrong slot, you get a "pseudo-hit:' Note that a slot that is a hit can never count as a
//        pseudo-hit.
//        For example, if the actual solution is RGBY and you guess GGRR, you have one hit and one pseudo-hit.
//        Write a method that, given a guess and a solution, returns the number of hits and pseudo-hits.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question15 {

    public Question15() {
        Slot[] slots = new Slot[] { Slot.R, Slot.G, Slot.B, Slot.Y};
        Slot[] guesses = new Slot[] { Slot.G, Slot.G, Slot.R, Slot.R};

        int hit = 0;
        int pseudoHit = 0;

        Set<Slot> flags = new HashSet<>();

        for (Slot slot : slots) {
            flags.add(slot);
        }

        for (int i = 0; i < guesses.length; i++) {
            Slot slot = slots[i];
            Slot guess = guesses[i];

            if (slot == guess) {
                hit++;
                flags.remove(guess);
            }
        }

        for (int i = 0; i < guesses.length; i++) {
            Slot slot = slots[i];
            Slot guess = guesses[i];

            if (slot != guess && flags.contains(guess)) {
                pseudoHit++;
                flags.remove(guess);
            }
        }

        System.out.println("hit: " + hit + " | pseudoHit: " + pseudoHit);
    }

    enum Slot {
        R,
        Y,
        G,
        B
    }
}
