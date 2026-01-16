package com.iuliana.algorithms.arrays;

import java.util.Arrays;
import java.util.List;
public class CountNumberBalancedPermutations {

    public static String countBalancedNumbers(List<Integer> p) {

        StringBuilder stringBuilder = new StringBuilder();
        int n = p.size();
        int[] pos = new int[n + 1];
        for(int i = 0; i < n; i++) {
             pos[p.get(i)] = i;
        }

        int maxPos = -1;
        int minPos = n;
        for(int k = 1; k <= n; k++) {
            int index = pos[k];

            maxPos = Math.max(maxPos, index);
            minPos = Math.min(minPos, index);

            if(maxPos - minPos + 1 == k) {
                stringBuilder.append("1");
            }
            else {
                stringBuilder.append("0");
            }
        }

        return stringBuilder.toString();
    }

    static void main() {
        List<Integer> p1 = Arrays.asList(5, 3, 1, 2, 4);
        List<Integer> p2 = Arrays.asList(3, 1, 2, 5, 4);

        String result1 = countBalancedNumbers(p1);
        String result2 = countBalancedNumbers(p2);

        System.out.println("Result1: " + result1);
        System.out.println("Result2: " + result2);
    }
}
