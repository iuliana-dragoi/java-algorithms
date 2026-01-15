package com.iuliana.algorithms.strings;

import java.util.Arrays;

public class AnagramSubstringSearch {

    static void main() {

        String text = "BACDGABCDA";
        String pat = "ABCD";

        int windowSize = pat.length();
        String window = "";

        char[] patChars = pat.toCharArray();
        Arrays.sort(patChars);
        for(int i = 0; i <= text.length() - windowSize; i++) {
            window = text.substring(i, i + windowSize);
            char[] windowChars = window.toCharArray();
            Arrays.sort(windowChars);

            if(Arrays.equals(patChars, windowChars)) {
                System.out.println("Anagram found at index " + i + ": " + window);
            }
        }
    }
}
