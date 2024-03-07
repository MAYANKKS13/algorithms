package com.learn.algorithms.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 6, 3, 9, 7, 19, 13};
        selectionSort(arr);
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static void selectionSort(int[] arr){
        int n = arr.length;
        int k = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(arr[j] < arr[i]){
                    k = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }

    }
}
