package com.learn.algorithms.twopointer;

/*
Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.

The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.

Example 1:

Input: [1, 0, 2, 1, 0]
Output: [0 0 1 1 2]
Example 2:

Input: [2, 2, 0, 1, 2, 0]
Output: [0 0 1 2 2 2 ]
 */

import java.util.Arrays;
import java.util.List;

public class DutchNationalFlag {

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 2, 0, 1, 2, 0, 2, 2};
        System.out.println(Arrays.toString(sortedArray(arr1)));
        int[] arr2 = new int[]{1, 0, 0, 1, 2, 1};
        System.out.println(Arrays.toString(sortedArray(arr2)));
        int[] arr3 = new int[]{2, 2, 0, 1, 2, 0};
        System.out.println(Arrays.toString(sortedArray(arr3)));
        int[] arr4 = new int[]{1, 1, 1, 2, 2, 2, 0, 0, 0, 1, 1, 1, 2, 2, 2, 0, 1, 2, 0, 1, 2, 2};
        System.out.println(Arrays.toString(sortedArray(arr4)));

    }

    public static int[] sortedArray(int[] arr) {
        int j = arr.length - 1;
        int i = 0;
        int k = i;
        while (k <= j) {
            if (arr[k] == 0) {
                swap(arr, i, k);
                i++;
                k++;
            } else if (arr[k] == 1) {
                k++;
            } else if (arr[k] == 2) {
                swap(arr, k, j);
                j--;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
