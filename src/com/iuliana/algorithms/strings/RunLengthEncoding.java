package com.iuliana.algorithms.strings;

public class RunLengthEncoding {

    static void main() {
        String input= "aabbaa"; // a2b2a2
        System.out.println("Compressed: " + compress(input));
    }

    static String compress(String input) {

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 0; i < input.length(); i++) {
            if(i + 1 < input.length() &&  input.charAt(i) ==  input.charAt(i + 1)) {
                count++;
            }
            else {
                sb.append(input.charAt(i)).append(count);
                count = 1;
            }
        }

        return sb.toString();
    }
}
