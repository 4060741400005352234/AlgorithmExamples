package com.company.alg;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] input = new int[] {8, 7, 2, 0, 4, 5, 7, 9};
        sort(input);
        System.out.println(Arrays.toString(input));
    }

    private static void sort(int[] input) {
        for (int i = 0; i < input.length; ++i) {
            int min = i;
            for (int j = i + 1; j < input.length; ++j) {
                if (input[j] < input[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(i, min, input);
            }
        }
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
