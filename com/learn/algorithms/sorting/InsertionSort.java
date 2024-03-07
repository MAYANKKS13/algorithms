package com.learn.algorithms.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 6, 3, 9, 7, 19, 13};
        insertionSort(arr);
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}
