package com.iuliana.algorithms.arrays;

import java.util.ArrayList;

public class MissingAndRepeating {

    static void main() {
        int[] arr = {3, 1, 3};

        findMissingAndRepeating(arr);
    }

    static void findMissingAndRepeating(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();

        int[] freq = new int[arr.length + 1];
        int repeating = -1;
        int missing = -1;

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int count = freq[val];
            count = count + 1;
            freq[val] = count;
        }

        for(int i = 1; i <= arr.length; i++) {
            if(freq[i] == 0) {
                missing = i;
            }
            else if(freq[i] == 2) {
                repeating = i;
            }
        }

        System.out.println(repeating + " " + missing);
    }
}
