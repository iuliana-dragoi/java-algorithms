package com.iuliana.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    static void main() {
        int[] nums = {1, 1, 1};
        int k = 2;

//        int result1 = subArraySumV1(nums, k);
//        System.out.print(result1 + " ");

        int result2 = subArraySumV2(nums, k);
        System.out.print(result2);

    }

    // Complexity: O(n2)
    static int subArraySumV1(int[] nums, int k) {
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            int sum = 0;

            System.out.print("i=" + i + " ");
            for(int j = i; j < nums.length ; j++) {
                System.out.print("j=" + j +" ");

                sum+= nums[j];
                System.out.println("SUM=" + sum + " ");
                if(sum == k) count++;
            }
            System.out.println();
        }

        return count;
    }

    // Complexity: O(n)
    static int subArraySumV2(int[] nums, int k) {

        // 0
        // index = 0 => [1]
        // index = 1 => [1, 1]
        // index = 2 => [1, 1, 1]

        // 1
        // index = 1 => [1]
        // index = 2 => [1, 1]

        // 2 (because nums.length = 3 -> 0,1,2)
        // index = 2 => [1]

        Map<Integer, Integer> counter = new HashMap<>();
        // BASE CASE: Initialize the map with sum 0 appearing once.
        // This is crucial for cases where the sum from the very beginning equals k.
        counter.put(0, 1);
        System.out.println("--- START: Added (0, 1) to Map as the base reference point ---");

        int currentSum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];
            currentSum += val;

            // The logic: If (currentSum - k) exists in the map, it means there is
            // a subarray in the past that, when removed, leaves exactly 'k'.
            int target = currentSum - k;

            System.out.println("\nStep " + i + " (Current Element: " + nums[i] + ")");
            System.out.println("   Current Prefix Sum: " + currentSum);
            System.out.print("   Looking in Map for (currentSum - k): " + currentSum + " - " + k + " = " + target);

            if (counter.containsKey(target)) {
                int occurrences = counter.get(target);
                count += occurrences;
                System.out.println(" -> FOUND! The sum " + target + " appeared " + occurrences + " time(s) before.");
                System.out.println("   => Found " + occurrences + " new valid subarray(s). Total count: " + count);
            } else {
                System.out.println(" -> NOT found.");
            }

            // Save the current sum in the Map to be used as a "past sum" for future indices
            counter.put(currentSum, counter.getOrDefault(currentSum, 0) + 1);
            System.out.println("   Updated Map: " + counter);
        }

        return count;
    }
}
