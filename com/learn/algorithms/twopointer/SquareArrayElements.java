package com.learn.algorithms.twopointer;
import java.util.Arrays;

/*
 Problem Statement #
Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

Example 1:
Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]

Example 2:
Input: [-3, -1, 0, 1, 2]
Output: [0 1 1 4 9]
 */

public class SquareArrayElements {
    public static void main(String[] args) {
        int[] arr = new int[]{-3, -1, 0, 1, 2};
        System.out.println(Arrays.toString(squareArrayElements(arr)));

    }

    public static int[] squareArrayElements(int[] arr) {
        int i = 0, j = arr.length - 1;
        int[] result = new int[arr.length];
        for (int k = arr.length - 1; k >= 0; k--) {
            if (arr[i] * arr[i] >= arr[j] * arr[j]) {
                result[k] = arr[i] * arr[i];
                i++;
            } else if (arr[i] * arr[i] < arr[j] * arr[j]) {
                result[k] = arr[j] * arr[j];
                j--;
            }
        }
        return result;
    }
}
