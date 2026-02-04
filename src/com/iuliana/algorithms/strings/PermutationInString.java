package com.iuliana.algorithms.strings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo")); // true
        System.out.println(checkInclusion("ab", "eidboaoo")); // false
        System.out.println(checkInclusion("abc", "ccccbbbbaaaa")); // false
        System.out.println(checkInclusion("adc", "dcda")); // true
    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        Deque<Character> window = new ArrayDeque<>();
        Map<Character, Integer> windowCount = new HashMap<>();

        Map<Character, Integer> s1Count = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Count.put(c, s1Count.getOrDefault(c, 0) + 1);
        }

        for(char c : s2.toCharArray()) {
            window.addLast(c);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            if (window.size() > s1.length()) {
                char removed = window.removeFirst();
                windowCount.put(removed, windowCount.get(removed) - 1);
                if (windowCount.get(removed) == 0) {
                    windowCount.remove(removed);
                }
            }

            if (window.size() == s1.length() && windowCount.equals(s1Count)) {
                return true;
            }
        }

        return false;
    }
}
