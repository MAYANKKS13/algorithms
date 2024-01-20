package com.learn.algorithms.binarysearch;

public class BinarySearchExample {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 8, 11, 44};
        int[] arr1 = new int[]{102, 55, 33, 8, 6, 5, 4, 3, 2, 1};
        System.out.println(binarySearch(arr, 4));
        System.out.println(binarySearch(arr1, 5));
    }

    public static int binarySearch(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        if (arr[low] < arr[high]) {
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == k) {
                    return mid;
                } else if (arr[mid] > k) {
                    high = mid - 1;
                } else if (arr[mid] < k) {
                    low = mid + 1;
                }
            }
        } else if (arr[low] > arr[high]) {
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == k) {
                    return mid;
                } else if (arr[mid] > k) {
                    low = mid + 1;
                } else if (arr[mid] < k) {
                    high = mid - 1;
                }
            }
        }
        return 0;
    }
}
