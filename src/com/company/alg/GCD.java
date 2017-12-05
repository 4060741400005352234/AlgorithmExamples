package com.company.alg;

public class GCD {

    public static void main(String[] args) {
        int gcd = new GCD().gcdRecursion(100500, 1024);
        System.out.println(gcd);

        int gcd2 = new GCD().gcd(55 * 2010, 55);
        System.out.println(gcd2);
    }

    private int gcdRecursion(int a, int b) {
        System.out.println(a + " : " + b);
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a > b) {
            return gcdRecursion(a % b, b);
        } else {
            return gcdRecursion(a, b % a);
        }
    }

    private int gcd(int a, int b) {
        while (true) {
            System.out.println(a + " : " + b);
            if (a == 0) {
                return b;
            }
            if (b == 0) {
                return a;
            }
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
    }
}
