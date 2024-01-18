package com.learn.algorithms.twopointer;

/*Problem Statement #
Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the new length of the array.

Example 1:

Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
Example 2:

Input: [2, 2, 2, 11]
Output: 2
Explanation: The first two elements after removing the duplicates will be [2, 11].
 */


public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 3, 6, 9, 9};
        System.out.println(lengthAfterRemovingDuplicates(arr));

    }


    public static int lengthAfterRemovingDuplicates(int[] arr) {

        int i = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] != arr[j + 1]) {
                arr[i] = arr[j];
                i++;
            }
        }
        arr[i] = arr[arr.length - 1];

        return i + 1;


//        int length=0;
//        for (int i=0;i<arr.length-1;i++)
//        {
//            if(arr[i]==arr[i+1])
//                length++;
//        }
//
//        return (arr.length-length);
    }
}
