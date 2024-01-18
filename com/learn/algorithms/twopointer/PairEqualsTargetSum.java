package com.learn.algorithms.twopointer;

import java.util.HashSet;
import java.util.Set;

public class PairEqualsTargetSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-10,10,20,30,60};
        int targetSum = 50;

        FindPairUsingSet(arr,targetSum);
        FindPairUsingTwoPointer(arr,targetSum);

    }


    public static void FindPairUsingTwoPointer(int[] arr, int target)
    {
        int j=arr.length-1;
        for(int i = 0;i<j;i++) {
            if (arr[i] + arr[j] > target)
            {
                j--;
            }
            else if (arr[i] + arr[j] < target)
            {
                i++;
            }
            else
            {
                System.out.println(arr[i] + " " + arr[j]);
            }
        }
    }

    public static void FindPairUsingSet(int[] arr, int target)
    {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i<arr.length; i++)
        {
            if(!set.contains(target-arr[i]))
            {
                set.add(arr[i]);
            }
            else if (set.contains(target-arr[i]))
            {
                System.out.println((target-arr[i])+" "+arr[i]);
            }
        }
    }

}
