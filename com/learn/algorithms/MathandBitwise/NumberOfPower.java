package com.learn.algorithms.MathandBitwise;

public class NumberOfPower {
    public static void main(String[] args) {

        System.out.println(noOfPower(100,13));

    }

    public static int noOfPower(int n, int k){
        int sum = 0;
        while (true){
            if(n/k == 0)
                break;

            sum = sum + (n/k);
            k = k*k;
        }
        return sum;
    }
}
