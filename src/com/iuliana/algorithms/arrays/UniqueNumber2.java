package com.iuliana.algorithms.arrays;

public class UniqueNumber2 {

    static void main() {
        int[] arr = {2, 3, 5, 4, 5, 3, 4};

        int result = 0;
        for(int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }

        System.out.println("Rez: " + result);
    }
}
