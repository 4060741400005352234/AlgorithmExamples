package com.company.alg;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort main = new InsertionSort();
        int[] input = new int[] {5, 0, 7, 9, 4, 7, 2, 3, 1};
        int[] sorted = main.sort(input);
        System.out.println(Arrays.toString(sorted));
    }

    private int[] sort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int currentValue = input[i];
            int j = i;
            while (j > 0 && input[j - 1] > currentValue) {
                input[j] = input[j - 1];
                j--;
            }
            input[j] = currentValue;
        }
        return input;
    }
}
