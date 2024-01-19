package com.learn.algorithms.fastslowpointer;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(13));
        System.out.println(isHappy(15));
        System.out.println(isHappy(145));
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = digitSquare(n);
        while (slow != fast) {
            slow = digitSquare(slow);
            fast = digitSquare(digitSquare(fast));
        }
        if (slow == 1)
            return true;
        return false;
    }

    public static int digitSquare(int n) {
        int sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            sum += lastDigit * lastDigit;
            n = n / 10;
        }
        return sum;
    }
}
