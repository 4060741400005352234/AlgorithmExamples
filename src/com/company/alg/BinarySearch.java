package com.company.alg;

public class BinarySearch {

    public static void main(String[] args) {
        int[] input = new int[] {0, 1, 2, 3, 5, 5, 7, 9, 10, 13};

        int foundIndex = search(input, 7);
        System.out.println("Found index: " + foundIndex);

        int foundIndexRecursively = searchRecursively(input, 7, 0, input.length);
        System.out.println("Recursively found index: " + foundIndexRecursively);
    }

    private static int search(int[] input, int key) {
        int left = 0;
        int right = input.length;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (input[middle] == key) {
                return middle;
            }
            if (key < input[middle]) {
                right = middle - 1;
            } else if (key > input[middle]) {
                left = middle + 1;
            }
        }
        return -1;
    }

    private static int searchRecursively(int[] input, int key, int left, int right) {
        if (left >= right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        if (key == input[middle]) {
            return middle;
        }
        if (key < input[middle]) {
            return searchRecursively(input, key, left, middle - 1);
        } else {
            return searchRecursively(input, key, middle + 1, right);
        }
    }
}
