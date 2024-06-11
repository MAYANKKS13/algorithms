package com.learn.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] arr3 = {28,6,22,8,44,17};
        int[] arr4 = {22,28,8,6};
        int[] result = relativeSort(arr1, arr2);
        int[] result1 = relativeSort(arr3, arr4);
        for(int num: result) {
            System.out.print(num+" ");
        }
        System.out.println();
        for(int num: result1) {
            System.out.print(num+" ");
        }

    }

    public static int[] relativeSort(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int[] result = new int[arr1.length];
        for(int i = 0; i < arr2.length; i++) {
            for(int j = 0; j < arr1.length; j++) {
                if(arr2[i] == arr1[j]) {
                    list.add(arr1[j]);
                    arr1[j] = -1;
                }
            }
        }
        Arrays.sort(arr1);
        for(int j = 0; j < arr1.length; j++) {
            if(arr1[j] != -1) {
                list.add(arr1[j]);
            }
        }
        Iterator it = list.iterator();
        int k = 0;
        while (it.hasNext()) {
            result[k] = (int)it.next();
            k++;
        }
        return result;
    }
}
