package com.company.hard;

//Circus Tower: A circus is designing a tower routine consisting of people standing atop one another's
//        shoulders. For practical and aesthetic reasons, each person must be both shorter and lighter than
//        the person below him or her. Given the heights and weights of each person in the circus, write a
//        method to compute the largest possible number of people in such a tower.

//  2:39

import java.util.ArrayList;
import java.util.HashMap;

public class Question8Review {

    private int count = 0;

    public Question8Review() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(1, 9));
        people.add(new Person(2, 9));
        people.add(new Person(3, 10));
        people.add(new Person(3, 12));
        people.add(new Person(4, 10));
        people.add(new Person(5, 15));
        people.add(new Person(6, 12));
        people.add(new Person(6, 13));
        people.add(new Person(6, 15));
        people.add(new Person(7, 11));
        people.add(new Person(8, 20));
        people.add(new Person(9, 10));

//        HashMap<Person, Integer> memo = new HashMap<>();
//        System.out.println("count: " + calculate(people, memo, people.size() - 1));
        ArrayList<Person>[] memo = new ArrayList[people.size() + 1];
        System.out.println(bestSequence(people, new ArrayList<>(), 0, memo));
        System.out.println("count: " + count);
    }

    private ArrayList<Person> bestSequence(ArrayList<Person> people, ArrayList<Person> sequence, int index, ArrayList<Person>[] memo) {

        if (index >= people.size()) return sequence;
        count++;

        Person above = people.get(index);
        ArrayList<Person> bestWith = null;
        if (canAppend(sequence, above)) {
            if (memo[index] == null) {
                ArrayList<Person> sequenceWith = (ArrayList<Person>) sequence.clone();
                sequenceWith.add(above);
                memo[index] = bestSequence(people, sequenceWith, index + 1, memo);
            }
            bestWith = memo[index];
        }

        ArrayList<Person> bestWithout = bestSequence(people, sequence, index + 1, memo);

        if (bestWith == null || bestWithout.size() > bestWith.size()) {
            return bestWithout;
        } else {
            return bestWith;
        }
    }

    private boolean canAppend(ArrayList<Person> people, Person person) {
        if (people == null) return false;
        if (people.size() == 0) return true;
        Person last = people.get(people.size() - 1);
        return last.canBeOnTopOf(person);
    }

    private int calculate(ArrayList<Person> people, HashMap<Person, Integer> memo, int index) {

        if (index < 0) return 0;

        int sum = calculate(people, memo, index - 1);
        Person below = people.get(index);
        int curr = 1;

        for (int i = index - 1; i >= 0; i--) {
            Person above = people.get(i);
            if (above.canBeOnTopOf(below)) {
                int count = memo.get(above);
                curr = Math.max(curr, count + 1);
            }
        }

        memo.put(below, curr);
        return Math.max(sum, curr);
    }


    class Person {
        public int height;
        public int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public boolean canBeOnTopOf(Person person) {
            return this.height < person.height && this.weight < person.weight;
        }

        @Override public String toString() {
            return "Person{" +
                   "height=" + height +
                   ", weight=" + weight +
                   '}';
        }
    }
}
