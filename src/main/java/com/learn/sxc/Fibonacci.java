package com.learn.sxc;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-07-04 17:51:58
 */
public class Fibonacci {
    public static long fibonacci1(long n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci1(n - 2) + fibonacci1(n - 1);
    }

    public static long fibonacci2(long n) {
        if (n < 2)
            return n;
        long a = 0, b = 1;
        long num = 0;
        for (int i = 1; i < n; i++) {
            num = a + b;
            a = b;
            b = num;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci1(11));
        System.out.println(fibonacci2(11));
    }

}
