package com.learn.algorithms.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 6, 3, 9, 7, 19, 13};
        bubbleSort(arr);
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n -1 -i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
