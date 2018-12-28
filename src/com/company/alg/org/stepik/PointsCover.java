package com.company.alg.org.stepik;

import java.util.Arrays;

public class PointsCover {

    public static void main(String[] args) {
        int[] points = new int[] {1, 2, 5, 6, 9, 11, 13};
        int lines = coverPoints(points, 1);

        System.out.println("Covered with " + lines + " lines");
    }

    // O(nLogN) = T(sort) + O(n)
    //
    private static int coverPoints(int[] points, int lineLength) {
        Arrays.sort(points);
        int min = 1;
        int lines = 0;

        while (min <= points.length) {
            int line = min + lineLength;
            ++lines;
            ++min;
            while (min <= points.length && min <= line) {
                ++min;
            }
        }
        return lines;
    }
}
