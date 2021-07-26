package com.company.recursionanddynamicprogramming;

public class Question3Review {

    public Question3Review() {
//        int[] arr = {-2, -1, 1, 2, 5, 6, 7, 9, 10, 14, 16, 20, 30};
        int[] arr = {-1, 5, 5, 5, 5, 5, 7, 9, 10, 12, 14, 14, 14};
//        System.out.println("magic index: " + magicIndex(arr, 0, arr.length - 1));
//        System.out.println("magic index: " + magicIndexWithDuplicate(arr, 0, arr.length - 1));
//        System.out.println("magic index: " + findMagicIndex(arr, 0, arr.length - 1));
        System.out.println("magic index: " + findMagicIndexWithDuplicates(arr, 0, arr.length - 1));
    }

    private int findMagicIndex(int[] arr, int left, int right) {
        if (left > right) return -1;

        int middleIndex = (left + right) / 2;
        int middleValue = arr[middleIndex];

        if (middleValue == middleIndex) return middleIndex;
        if (middleValue > middleIndex) return findMagicIndex(arr, left, middleIndex - 1);
        return findMagicIndex(arr, middleIndex + 1, right);
    }

    private int findMagicIndexWithDuplicates(int[] arr, int left, int right) {
        if (left > right) return -1;

        int midIndex = (left + right) / 2;
        int midValue = arr[midIndex];

        if (midIndex == midValue) return midIndex;

        int leftIndex = Math.min(midIndex - 1, midValue);
        int leftValue = findMagicIndexWithDuplicates(arr, left, leftIndex);
        if (leftValue > 0) return leftValue;

        int rightIndex = Math.max(midIndex + 1, midValue);
        return findMagicIndexWithDuplicates(arr, rightIndex, right);
    }































    private int magicIndex(int[] arr, int left, int right) {
        if (left > right) return -1;

        int midIndex = (left + right) / 2;
        int midNum = arr[midIndex];

        if (midNum == midIndex) return arr[midIndex];
        else if (midNum >= midIndex) return magicIndex(arr, left, midIndex - 1);
        else return magicIndex(arr, midIndex + 1, right);
    }

    private int magicIndexWithDuplicate(int[] arr, int left, int right) {
        if (left > right) return -1;

        int midIndex = (left + right) / 2;
        int midNum = arr[midIndex];

        if (midNum == midIndex) return arr[midIndex];

        int leftIndex = midIndex - 1;

        while (leftIndex >= 0 && arr[leftIndex] == midNum) {
            if (arr[leftIndex] == leftIndex) return arr[leftIndex];
            leftIndex--;
        }

        int leftNum = magicIndexWithDuplicate(arr, left, leftIndex);
        if (leftNum != -1) return leftNum;

        int rightIndex = midIndex + 1;
        while (rightIndex < arr.length && arr[rightIndex] == midNum) {
            if (arr[rightIndex] == rightIndex) return rightIndex;
            rightIndex++;
        }


        int rightNum = magicIndexWithDuplicate(arr, rightIndex, right);
        if (rightNum != -1) return rightNum;

        return  -1;
    }

}
