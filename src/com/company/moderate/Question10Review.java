package com.company.moderate;

//Living People: Given a list of people with their birth and death years, implement a method to
//        compute the year with the most number of people alive. You may assume that all people were born
//        between 1900 and 2000 (inclusive). If a person was alive during any portion of that year, they should
//        be included in that year's count. For example, Person (birth= 1908, death= 1909) is included in the
//        counts for both 1908 and 1909.

// 3:09

import java.util.ArrayList;
import java.util.List;

public class Question10Review {

    public Question10Review() {
        List<Person> people = new ArrayList<>();
        people.add(new Person(1900, 1965));
        people.add(new Person(1980, 1985));
        people.add(new Person(1970, 1980));
        people.add(new Person(1960, 1980));

    }



    class Person {
        public int birth;
        public int death;

        public Person(int birth, int death) {
            this.birth = birth;
            this.death = death;
        }
    }
}
