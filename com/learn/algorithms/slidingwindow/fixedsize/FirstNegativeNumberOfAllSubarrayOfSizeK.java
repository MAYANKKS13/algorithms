package com.learn.algorithms.slidingwindow.fixedsize;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeNumberOfAllSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = new int[]{-8, 2, 3, -6, 10, 5, 7, -1, -3, -6, 8, 7};
        System.out.println(firstNegativeInSubArray(arr, 2));

    }

    public static List<Integer> firstNegativeInSubArray(int[] arr, int k) {
        List<Integer> results = new ArrayList<>(arr.length - k + 1);
        boolean t = false;
        for (int i = 0; i < arr.length - k + 1; i++) {
            for (int j = i; j < k + i; j++) {
                if (arr[j] < 0) {
                    results.add(arr[j]);
                    t = true;
                    break;
                }
            }
            if (t == false)
                results.add(0);
            t = false;
        }
        return results;
    }
}
