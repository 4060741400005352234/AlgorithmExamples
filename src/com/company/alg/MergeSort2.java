package com.company.alg;

import java.util.Arrays;

public class MergeSort2 {

    public static void main(String[] args) {
        int[] input = new int[] {5, 8, 1, 4, 2, 0, 9, 7};
        int[] tmp = new int[input.length];

        mergeSort(input, tmp, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

    private static void mergeSort(int[] a, int[] tmp, int left, int right){
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    private static void merge(int[] a, int[] tmp, int left, int right, int rightEnd ) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd) {
            if (a[left] < a[right]) {
                tmp[k++] = a[left++];
            } else {
                tmp[k++] = a[right++];
            }
        }

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
}
