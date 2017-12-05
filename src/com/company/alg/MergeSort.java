package com.company.alg;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort main = new MergeSort();

        int[] sorted = main.mergeSort(new int[]{5, 8, 1, 4, 2, 0, 9, 7});
        System.out.println(Arrays.toString(sorted));
    }

    private int[] mergeSort(int[] input) {
        if (input.length == 1) {
            return input;
        }
        int middle = input.length >> 1;
        int[] left = new int[middle];
        int[] right = new int[input.length - middle];
        System.arraycopy(input, 0, left, 0, left.length);
        System.arraycopy(input, middle, right, 0, right.length);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private int[] merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int[] merged = new int[a.length + b.length];
        for (int k = 0; k < merged.length; k++) {
            if (j == b.length || (i < a.length && a[i] <= b[j])) {
                merged[k] = a[i];
                i++;
            } else {
                merged[k] = b[j];
                j++;
            }
        }
        return merged;
    }
}
