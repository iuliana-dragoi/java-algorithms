package com.iuliana.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarraySumAtMostK {

    static void main() {
        int[] arr = {1, 2, 3, 4};
        int k = 10;

        maxSubArraySumV1(arr, k);
        System.out.println();
        maxSubArraySumV2(arr, k);
    }

    // O(n^2)
    public static void maxSubArraySumV1(int[] arr, int k) {

        int maxSum = Integer.MIN_VALUE;
        String maxSubarray = "";

        for (int i = 0; i < arr.length; i++) {
            System.out.println("For index: " + i);
            int sum = 0;

            String text = "[ ";
            for (int j = i; j < arr.length; j++) {
                text += arr[j] + " ]";
                sum += arr[j];

                if (j == arr.length - 1) {
                    text += " = " + sum;
                }

                if (sum > maxSum) {
                    maxSum = sum;
                    maxSubarray = text.trim();
                }

                System.out.println("Subarray: " + text);
                text = text.substring(0, text.length() - 1);
            }
            System.out.println();
        }

        System.out.println("Max: " + maxSum);
        System.out.println("Subarray with max sum: " + maxSubarray);
    }

    // O(n)
    public static void maxSubArraySumV2(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int target = sum - k; // If sum-k = 0 -> we found a match. ->  count ++

            if (map.containsKey(target)) {
                count += map.get(target);
            }

            if(sum > maxSum) {
                maxSum = sum;
            }

            map.put(target, map.getOrDefault(target, 0) + 1);
        }

        System.out.println("Number of subarrays with sum k = " + count);
        System.out.println("Max: " + maxSum);    }
}
