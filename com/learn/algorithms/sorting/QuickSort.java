package com.learn.algorithms.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 6, 3, 9, 7, 19, 13};
        quickSort(arr, 0, arr.length - 1);
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high) {
            int index = findPartition(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    public static int findPartition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for(int j = 0; j < high; j++){
            if(arr[j] < pivot){
                i++;
//                swap(arr, i, j);
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return (i + 1);
    }

//    public static void swap(int[] arr, int i, int j){
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
}
