package com.learn.algorithms.binarysearch;

public class SearchInARotatedArray {
    public static void main(String[] args) {

        int[] arr2 = new int[]{4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(searchInRotatedArray(arr2, 9));

//        int[] arr3 = new int[]{7, 8, 5, 3, 3, 3, 3, 5, 7};
//        System.out.println(searchInRotatedArrayDuplicates(arr3, 7));
//        System.out.println(searchInRotatedArrayDuplicates(arr3, 5));
    }

    public static int searchInRotatedArrayDuplicates(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k)
                while (arr[mid - 1] == k)
                    mid--;
            else if (arr[low] <= arr[mid]) {  // when left array is sorted
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

        if (arr[low] == k)
            return low;
        return -1;

    }


    public static int searchInRotatedArray(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int con = -1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                con = 1;
                return mid;
            }
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
        return con;
    }
}
