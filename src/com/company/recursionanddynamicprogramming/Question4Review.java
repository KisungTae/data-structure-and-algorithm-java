package com.company.recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


//8.4 Power Set: Write a method to return all subsets of a set.

//it is either in the set or it is not. For the second, there are two, etc. So, doing { 2 * 2 * . . . } n times gives us 2" subsets.

//There are 2" subsets and each of the n elements will be
//        contained in half of the subsets (which 2n- 1 subsets). Therefore, the total number of elements across all of
//        those subsets is n * 2n-1.
//        We will not be able to beat 0( n2") in space or time complexity.

public class Question4Review {

    public Question4Review() {
        int[] arr = {1, 2, 3};
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
//        arrayList.add(4);
        ArrayList<ArrayList<Integer>> arrayLists = doSubset(arrayList, arrayList.size() -1);
        print(arrayLists);
    }

    private void print(ArrayList<ArrayList<Integer>> arrayLists) {
        arrayLists.forEach(System.out::println);
    }

    public ArrayList<ArrayList<Integer>> doSubset(ArrayList<Integer> set, int index) {
        if (index == -1) {
            ArrayList<Integer> element = new ArrayList<>();
            ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
            subsets.add(element);
            return subsets;
        } else {
            ArrayList<ArrayList<Integer>> subsets = doSubset(set, index - 1);
            ArrayList<ArrayList<Integer>> newSubsets = new ArrayList<>(subsets);
            for (ArrayList<Integer> arrayList : subsets) {
                ArrayList<Integer> temp = new ArrayList<>(arrayList);
                temp.add(set.get(index));
                newSubsets.add(temp);
            }
            return newSubsets;
        }
    }












    private ArrayList<ArrayList<Integer>> subset(int[] arr, int index) {
        if (index >= arr.length) return new ArrayList<>();

        ArrayList<ArrayList<Integer>> arrayLists = subset(arr, index + 1);

        ArrayList<ArrayList<Integer>> newArrayLists = new ArrayList<>();

        for (ArrayList<Integer> arrayList : arrayLists) {
            newArrayLists.add(arrayList);
            ArrayList<Integer> elements = new ArrayList<>(arrayList);
            elements.add(0, arr[index]);
            newArrayLists.add(elements);
        }
        ArrayList<Integer> curr = new ArrayList<>();
        curr.add(arr[index]);
        newArrayLists.add(curr);

        return newArrayLists;
    }

}
