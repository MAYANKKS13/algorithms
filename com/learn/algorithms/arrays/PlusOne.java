package com.learn.algorithms.arrays;

import java.util.Arrays;
import java.util.Collections;

public class PlusOne {
    public static void main(String[] args) {
        int[] arr = {2, 4, 7};
        int[] arr1 = {1, 5, 9};
        int[] arr2 = {9, 9, 9};
        int[] arr3 = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(plusOne(arr)));
        System.out.println(Arrays.toString(plusOne(arr1)));
        System.out.println(Arrays.toString(plusOne(arr2)));
        System.out.println();
        System.out.println(Arrays.toString(plusOneEasy(arr)));
        System.out.println(Arrays.toString(plusOneEasy(arr1)));
        System.out.println(Arrays.toString(plusOneEasy(arr2)));

    }

    public static int[] plusOneEasy(int[] arr){
        for(int i = arr.length - 1; i >= 0 ; i--){
            if(arr[i] < 9){
                arr[i] = arr[i] + 1;
                return arr;
            }
            else{
                arr[i] = 0;
            }
        }
        arr = new int[arr.length + 1];
        arr[0] = 1;
        return arr;
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        int[] result = new int[n+1];
        int[] result1 = new int[n];

        int carry = 1;
        for(int i = n-1; i >= 0; i--) {
            result[i+1] = (digits[i] + carry)%10;
            result1[i] = (digits[i] + carry)%10;
            carry = (digits[i] + carry)/10;
        }
        if(carry > 0) {
            result[0] = carry;
        } else {
            return result1;
        }
        return result;
    }
}
