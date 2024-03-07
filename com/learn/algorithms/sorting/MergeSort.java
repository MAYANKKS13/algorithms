package com.learn.algorithms.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 6, 3, 9, 7, 19, 13};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if(l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int a = m - l + 1;
        int b = r - m;
        int[] left = new int[a];
        int[] right = new int[b];
        int p = 0;
        int q = 0;

        for (int i = 0; i < a; i++) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < b; j++) {
            right[j] = arr[m + 1 + j];
        }
        int k = l;
        while (p < a && q < b) {
            if (left[p] < right[q]) {
                arr[k] = left[p];
                p++;
            } else {
                arr[k] = right[q];
                q++;
            }
            k++;
        }
        while (p < a) {
            arr[k] = left[p];
            p++;
            k++;
        }
        while (q < b) {
            arr[k] = right[q];
            q++;
            k++;
        }
    }
}
