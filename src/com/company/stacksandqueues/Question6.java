package com.company.stacksandqueues;


import java.util.LinkedList;

public class Question6 {
    public Question6() {
        Shelter shelter = new Shelter();
        shelter.pushCat("cat1");
        shelter.pushDog("dog1");
        shelter.pushDog("dog2");
        shelter.pushCat("cat2");
        shelter.pushCat("cat3");
        shelter.pushCat("cat4");
        shelter.pushDog("dog3");
        shelter.pushDog("dog4");
    }

    class Shelter {
        LinkedList<Cat> cats = new LinkedList<>();
        LinkedList<Dog> dogs = new LinkedList<>();
        int arrival = 0;

        public void pushDog(String name) {
            arrival++;
            dogs.add(new Dog(arrival, name));
        }

        public void pushCat(String name) {
            arrival++;
            cats.add(new Cat(arrival, name));
        }

        public Dog dequeueDog() {
            return dogs.pop();
        }

        public Cat dequeueCat() {
            return cats.pop();
        }

        public Animal dequeueAny() {
            if (dogs.peek().arrival > cats.peek().arrival)
                return dogs.pop();
            return cats.pop();
        }
    }

    class Animal {
        int arrival;
        String name;

        public Animal(int arrival, String name) {
            this.arrival = arrival;
            this.name = name;
        }
    }

    class Dog extends Animal {
        public Dog(int arrival, String name) {
            super(arrival, name);
        }
    }

    class Cat extends Animal {

        public Cat(int arrival, String name) {
            super(arrival, name);
        }
    }
}
