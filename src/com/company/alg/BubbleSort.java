package com.company.alg;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] input = new int[] {7, 2, 4, 8, 1, 0, 9};
//        sort(input);
//        sort2(input);
        sort3(input);

        System.out.println(Arrays.toString(input));
    }

    private static void sort(int[] input) {
        int length = input.length;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - 1; j++) {
                if (input[j - 1] > input[j]) {
                    swap(j, j - 1, input);
                }
            }
        }
    }

    private static void sort2(int[] input) {
        for (int barrier = input.length - 1; barrier >= 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (input[index] > input[index + 1]) {
                    swap(index, index + 1, input);
                }
            }
        }
    }

    private static void sort3(int[] input) {
        int length = input.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (input[j] > input[j + 1]) {
                    swap(j, j + 1, input);
                }
            }
        }
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void swap(int i, int j) {
        i = i ^ j;
        j = i ^ j;
        i = i ^ j;
        System.out.println(i + " " + j);
    }
}
