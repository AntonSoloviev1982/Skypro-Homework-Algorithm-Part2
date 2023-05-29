package com.example.skyprohomeworkalgorithmpart2;

import java.util.Arrays;
import java.util.Random;

public class ArraySorted {
    public static void main(String[] args) {
//        Integer[] array1 = generateRandomArray();
//        Integer[] array2 = Arrays.copyOf(array1, array1.length);
//        Integer[] array3 = array1.clone();

        Integer[] array4 = {11, 5, 7, 98, 2, 6, 1};
//        sortBubble(array4);
        sortSelection(array4);
        System.out.println(Arrays.toString(array4));

    }

    public static Integer[] generateRandomArray() {
        Random random = new Random();
        Integer[] arr = new Integer[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000);
        }
        return arr;
    }

    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = 0;
            for (int j= 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idxMin = 0;
            int temp = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    idxMin = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[idxMin];
            arr[idxMin] = temp;
        }
    }
}

// 11, 5, 7, 98, 2, 6, 1
//
