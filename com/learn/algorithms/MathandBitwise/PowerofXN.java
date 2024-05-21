package com.learn.algorithms.MathandBitwise;

public class PowerofXN {
    public static void main(String[] args) {
        System.out.println(power(2.0, 5));
        System.out.println(power(-1, -2845824));
        System.out.println(power(4, -3));

    }

    public static double power(double x, int n){
        if(n == Integer.MIN_VALUE){
            if(x == 1.0 || x == -1.0){
                return (double) 1;
            }
            else{
                x = 1/x;
                n = Integer.MAX_VALUE;
            }
        }
        double answer = 1.0;
        long m = Math.abs((long)n);
        while(m > 0){
            if(m % 2 == 0){
                x = x*x;
                m = m/2;
            }
            if(m % 2 != 0){
                answer = x * answer;
                m = m - 1;
            }
        }
        if(n < 0){
            return (double) 1/answer;
        }
        if (n == Integer.MIN_VALUE) {
            answer *= 1 / x;
        }
        return answer;
    }
}
