package com.iuliana.algorithms.strings;

import java.util.HashSet;

public class RemoveDuplicates {

    public static String removeDuplicates(String input) {
        HashSet<Character> exists = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for(char c : input.toCharArray()) {
            if(!exists.contains(c)) {
                result.append(c);
                exists.add(c);
            }
        }

        return result.toString();
    }

    static void main() {
        String input = "geeksforgeeks";
        System.out.println(removeDuplicates(input));
    }
}
