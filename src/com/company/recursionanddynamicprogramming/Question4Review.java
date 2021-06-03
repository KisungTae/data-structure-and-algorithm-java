package com.company.recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Question4Review {

    public Question4Review() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
//        ArrayList<int[]> first = new ArrayList<>();
//
//        list.add(first);
//        for (ArrayList<int[]> level: list) {
//            for (int[] element: level) {
//                System.out.print(Arrays.toString(element));
//                System.out.print(" ");
//            }
//            System.out.println("");
//        }

        subset(arr, list, 1);
    }

    private void subset(int[] arr, ArrayList<ArrayList<int[]>> list, int index) {

    }

    private void newLevel(int arr, ArrayList<ArrayList<int[]>> list, int level) {

    }


}
