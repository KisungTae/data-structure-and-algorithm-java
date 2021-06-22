package com.company.hard;

//Baby Names: Each year, the government releases a list of the 10000 most common baby names
//        and their frequencies (the number of babies with that name). The only problem with this is that
//        some names have multiple spellings. For example, "John" and ''.Jon" are essentially the same name
//        but would be listed separately in the list. Given two lists, one of names/frequencies and the other
//        of pairs of equivalent names, write an algorithm to print a new list of the true frequency of each
//        name. Note that if John and Jon are synonyms, and Jon and Johnny are synonyms, then John and
//        Johnny are synonyms. (It is both transitive and symmetric.) In the final list, any name can be used
//        as the "real" name.
//        EXAMPLE
//        Input:
//        Names: John (15), Jon (12), Chris (13), Kris (4), Christopher (19)
//        Synonyms: (Jon, John), (John, Johnny), (Chris, Kris), (Chris, Christopher)
//        Output: John (27), Kris (36)


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Question7Review {
    public Question7Review() {

        ArrayList<NameFrequency> nameFrequencies = new ArrayList<>();
        nameFrequencies.add(new NameFrequency("John", 15));
        nameFrequencies.add(new NameFrequency("Jon", 12));
//        nameFrequencies.add(new NameFrequency("Johnny", 13));
        nameFrequencies.add(new NameFrequency("Chris", 13));
        nameFrequencies.add(new NameFrequency("Kris", 4));
        nameFrequencies.add(new NameFrequency("Christopher", 19));
        nameFrequencies.add(new NameFrequency("Michael", 19));

        ArrayList<Synonym> synonyms = new ArrayList<>();
        synonyms.add(new Synonym("Jon","John"));
        synonyms.add(new Synonym("John", "Johnny"));
        synonyms.add(new Synonym("Chris", "Kris"));
        synonyms.add(new Synonym("Chris", "Christopher"));

        System.out.println(nameFrequencies.toString());
        System.out.println(synonyms.toString());


        Map<String, String> dic = new HashMap<>();
        for (Synonym synonym : synonyms) {
            if (dic.containsKey(synonym.firstName)) {
                String parentName = dic.get(synonym.firstName);
                dic.put(synonym.secondName, parentName);
            } else {
                dic.put(synonym.firstName, synonym.firstName);
                dic.put(synonym.secondName, synonym.firstName);
            }
        }

//        dic.forEach((key, value) -> System.out.println(key + " - " + value));

        Map<String, NameFrequency> nameFrequencyMap = new HashMap<>();
        for (NameFrequency nameFrequency : nameFrequencies) {
            String key = dic.get(nameFrequency.name);
            if (key == null) key = nameFrequency.name;

            NameFrequency newNameFrequency = nameFrequencyMap.get(key);
            if (newNameFrequency == null) newNameFrequency = new NameFrequency(key);
            newNameFrequency.frequency += nameFrequency.frequency;
            nameFrequencyMap.put(key, newNameFrequency);
        }

        nameFrequencyMap.forEach((key, value) -> System.out.println(value.name + " - " + value.frequency));
    }

    class Node {
        public String name;

    }

    class NameFrequency {
        public String name;
        public int frequency;

        public NameFrequency(String name, int frequency) {
            this.name = name;
            this.frequency = frequency;
        }

        public NameFrequency(String name) {
            this.name = name;
        }

        @Override public String toString() {
            return "NameFrequency{" +
                   "name='" + name + '\'' +
                   ", frequency=" + frequency +
                   '}';
        }
    }

    class Synonym {
        public String firstName;
        public String secondName;

        public Synonym(String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
        }

        @Override public String toString() {
            return "Synonym{" +
                   "firstName='" + firstName + '\'' +
                   ", secondName='" + secondName + '\'' +
                   '}';
        }
    }
}
