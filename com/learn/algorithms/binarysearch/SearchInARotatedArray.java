package com.learn.algorithms.binarysearch;

public class SearchInARotatedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{9,1,2,3,4,5,6,7,8};
        System.out.println(searchInRotatedArray(arr, 9));
        int[] arr1 = new int[]{2,4,6,8,10};
        System.out.println(searchInRotatedArray(arr1, 8));
        int[] arr2 = new int[]{4,5,6,7,8,1,2,3};
        System.out.println(searchInRotatedArray(arr2, 1));

    }
    public static int searchInRotatedArray(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k)
                return mid;
            else if (arr[low] < arr[mid]) {  // when left array is sorted
                if (k >= arr[low] && k <= arr[mid - 1])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {  //when right array is sorted
                if (k >= arr[mid + 1] && k <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return low;
    }
}
