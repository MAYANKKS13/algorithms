package com.learn.algorithms.MathandBitwise;

/*
Print all prime numbers less than the given number
 */

public class SieveofEratosthenes {
    public static void main(String[] args) {
        System.out.println(isPrime(10));

    }

    public static int isPrime(int n) {
        boolean temp[] = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            temp[i] = true;
        }
        int count = 0;

        for(int i = 2; i*i <= n; i++) {
            if(temp[i] == true){
                for(int j = i*i; j <= n; j = j + i) {
                    temp[j] = false;
                }
            }
        }

        for(int i = 2; i < n; i++) {
            if(temp[i] == true) {
                count = count + 1;
            }
        }
        return count;
    }

}
