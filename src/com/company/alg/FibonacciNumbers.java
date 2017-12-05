package com.company.alg;

public class FibonacciNumbers {

    public static void main(String[] args) {
        int n = 7;
        for (int next = 1; next <= n ; next++) {
            System.out.println(fib(next) + " ");
        }
        for (int next = 1; next <= n ; next++) {
            System.out.println(fibLoop(next) + " ");
        }
    }

    private static long fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    private static int fibLoop(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        int next = 1;
        for (int i = 2; i <= n; i++) {
            next = first + second;
            first = second;
            second = next;
        }
        return next;
    }
}
