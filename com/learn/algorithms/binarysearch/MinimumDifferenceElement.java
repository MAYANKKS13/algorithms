package com.learn.algorithms.binarysearch;

/*
Minimum Difference Element (medium)
Given an array of numbers sorted in ascending order, find the element in the array that has the minimum difference with the given ‘key’.
Input: [4, 6, 10], key = 7
Output: 6
Explanation: The difference between the key '7' and '6' is minimum than any other number in the array
Input: [4, 6, 10], key = 4
Output: 4
Input: [1, 3, 8, 10, 15], key = 12
Output: 10
Input: [4, 6, 10], key = 17
Output: 10
 */

public class MinimumDifferenceElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 8, 10, 13, 15};
        System.out.println(minimumDifferenceElement(arr, 7));

    }

    public static int minimumDifferenceElement(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k)
                return arr[mid];
            else if (arr[mid] < k) {
                low = mid + 1;
            } else if (arr[mid] > k) {
                high = mid - 1;
            }

        }
        if (Math.abs(arr[low] - k) < Math.abs(arr[high] - k))
            return arr[low];
        return arr[high];


//            if (arr[mid]==k) {
//                return arr[mid];
//            } else if (Math.abs(arr[mid] - k) < min && arr[mid] < k) {
//
//                    min = Math.abs(arr[mid] - k);
//                    low = mid + 1;
//
//            } else if (Math.abs(arr[mid] - k) < min && arr[mid] > k) {
//
//                    min = Math.abs(arr[mid] - k);
//                    high = mid + 1;
//                }

    }
}
