package com.company.hard;

//Circus Tower: A circus is designing a tower routine consisting of people standing atop one another's
//        shoulders. For practical and aesthetic reasons, each person must be both shorter and lighter than
//        the person below him or her. Given the heights and weights of each person in the circus, write a
//        method to compute the largest possible number of people in such a tower.

//  2:39

import java.util.ArrayList;

public class Question8Review {
    public Question8Review() {
        ArrayList<Person> people = new ArrayList<>();
    }

    class Person {
        public int height;
        public int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
}
