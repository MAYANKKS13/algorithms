package com.learn.algorithms;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Long t1 = System.currentTimeMillis();
        System.out.println(fib2(1500));
        Long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1));

        Long t3 = System.currentTimeMillis();
        System.out.println(fib3(1500));
        Long t4 = System.currentTimeMillis();
        System.out.println((t4 - t3));
    }

    public static int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fib1(n - 1) + fib1(n - 2);
        }
    }

    public static int fib3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }


    static Map<Integer, Integer> cache = new HashMap<>();

    public static int fib2(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n == 0 || n == 1) {
            return n;
        } else {
            int k = fib2(n - 1);
            int p = fib2(n - 2);
            cache.put(n - 1, k);
            cache.put(n - 2, p);
            return k + p;
        }
    }
}
