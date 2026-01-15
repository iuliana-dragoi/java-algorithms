package com.iuliana.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class UniqueNumber3 {

    static void main() {
        int[] arr = {1, 10, 1, 1};

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("Rez: " + entry.getKey());
                break;
            }
        }
    }
}
