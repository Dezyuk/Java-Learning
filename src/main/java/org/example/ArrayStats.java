package org.example;

import java.util.Arrays;

public class ArrayStats {


    private static void validate(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
    }

    public static int min(int[] arr) {
        validate(arr);
        return Arrays.stream(arr).min().getAsInt();
    }

    public static int max(int[] arr) {
        validate(arr);
        return Arrays.stream(arr).max().getAsInt();
    }

    public static double average(int[] arr) {
        validate(arr);
        return Arrays.stream(arr).average().getAsDouble();
    }

    public static double median(int[] arr) {
        validate(arr);
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        int n = copy.length;
        if (n % 2 == 1) {
            return copy[n / 2];
        } else {
            return (copy[n / 2 - 1] + copy[n / 2]) / 2.0;
        }
    }
}
