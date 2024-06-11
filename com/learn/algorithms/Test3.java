package com.learn.algorithms;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{48, 87, 26};
        System.out.println(bagOfTokensScore(nums1, 81));

    }

    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        int score = 0;
        while(i <= j){
            if(tokens[i] <= power){
                power = power - tokens[i];
                i++;
                score = score + 1;
            }
            else if(score > 0 && i!=j){
                power = power + tokens[j];
                j--;
                score = score - 1;
            }
            else{
                break;
            }
        }
        return score;
    }
}
