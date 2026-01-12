package com.iuliana.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int currentIndex = i;
            int currentValue = nums[i];

            int result = target - currentValue;
            if(seen.containsKey(result)) {
                return new int[] { seen.get(result), currentIndex };
            }

            seen.put(currentValue, currentIndex);
        }

        throw new IllegalArgumentException("No valid solution found");
    }

    static void main() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println(result[0] + ", " + result[1]);
    }
}
