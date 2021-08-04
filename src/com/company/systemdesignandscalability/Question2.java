package com.company.systemdesignandscalability;

//  BFS: O(k^q)
//  Bidirectional BFS: 0( k^q/2 + k^q/2), which is just 0( k^q/2)


import java.util.*;

public class Question2 {

    public Question2() {
        HashMap<Integer, Person> people = createPeople();
        LinkedList<Person> links = findPath(people, 0, 9);
        if (links == null) System.out.println("no link");
        else {
            Iterator<Person> iterator = links.iterator();
            while (iterator.hasNext()) {
                Person person = iterator.next();
                System.out.print(person.id + " ==> ");
            }
            System.out.print("END");
            System.out.println();
        }
    }

    private LinkedList<Person> findPath(HashMap<Integer, Person> people, int source, int dest) {
        BSTData startBST = new BSTData(people.get(source));
        BSTData destBST = new BSTData(people.get(dest));

        while (!startBST.isEmpty() && !destBST.isEmpty()) {
            Person collision = search(startBST, destBST, people);

            collision = collision == null ? search(destBST, startBST, people) : collision;

            if (collision != null) {
                LinkedList<Person> left = mergePath(startBST.visited.get(collision.id), false);
                LinkedList<Person> right = mergePath(destBST.visited.get(collision.id), true);
                right.removeFirst();
                left.addAll(right);
                return left;
            }
        }
        return null;
    }

    private LinkedList<Person> mergePath(NodePath nodePath, boolean forward) {
        LinkedList<Person> linkedList = new LinkedList<>();

        while (nodePath != null) {
            if (forward) linkedList.addLast(nodePath.person);
            else linkedList.addFirst(nodePath.person);
            nodePath = nodePath.previous;
        }
        return linkedList;
    }

    private Person search(BSTData start, BSTData dest, HashMap<Integer, Person> people) {

        int size = start.toVisit.size();

        for (int i = 0; i < size; i++) {
            Person person = start.toVisit.poll();
            if (person == null) continue;

            if (dest.visited.containsKey(person.id)) {
                return person;
            }

            NodePath currentNodePath = start.visited.get(person.id);
            for (int friendId : person.friends) {
                if (!start.visited.containsKey(friendId)) {
                    Person friend = people.get(friendId);
                    start.toVisit.add(friend);
                    NodePath nextNodePath = new NodePath(friend, currentNodePath);
                    start.visited.put(friendId, nextNodePath);
                }
            }
        }
        return null;
    }

    class NodePath {
        public Person person;
        public NodePath previous;

        public NodePath(Person person, NodePath previous) {
            this.person = person;
            this.previous = previous;
        }
    }

    class BSTData {
        Queue<Person> toVisit = new LinkedList<>();
        HashMap<Integer, NodePath> visited = new HashMap<>();

        public BSTData(Person person) {
            toVisit.add(person);
            NodePath nodePath = new NodePath(person, null);
            visited.put(person.id, nodePath);
        }

        public boolean isEmpty() {
            return toVisit.isEmpty();
        }
    }

    class Person {
        public int id;
        public List<Integer> friends = new ArrayList<>();

        public Person(int id) {
            this.id = id;
        }
    }


    private HashMap<Integer, Person> createPeople() {
        int size = 10;
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            people.add(new Person(i));
        }
        HashMap<Integer, Person> map = new HashMap<>();
        Random random = new Random();
        for (Person person : people) {
            for (Person friend : people) {
                if (person != friend && random.nextBoolean())
                    person.friends.add(friend.id);
            }
            System.out.println("person " + person.id + " = " + person.friends);
            map.put(person.id, person);
        }
        return map;
    }
}
