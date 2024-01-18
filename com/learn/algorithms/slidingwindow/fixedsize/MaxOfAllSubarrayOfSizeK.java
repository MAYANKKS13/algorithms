package com.learn.algorithms.slidingwindow.fixedsize;

import java.util.ArrayList;
import java.util.List;

public class MaxOfAllSubarrayOfSizeK {
    public static void main(String[] args) {

        int[] arr = new int[]{2, -1, 1, -2, 3};
        int k = 2;
        System.out.println(maxOfAllSubArrayBruteForce(arr, k));

    }


    public static List<Integer> maxOfAllSubArrayBruteForce(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        List<Integer> results = new ArrayList<>(arr.length - k + 1);

        for (int i = 0; i < arr.length - k + 1; i++) {
            for (int j = i; j < k + i; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            results.add(max);
            max = 0;
        }
        return results;
    }

}
