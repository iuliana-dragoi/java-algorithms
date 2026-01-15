package com.iuliana.algorithms.strings;

public class FindAndReplaceString {

    static void main() {
        String text = "I love Java and Java is fun";
        String target = "Java";
        String replacement = "Python";

        String result = text.replace(target, replacement);
        System.out.println(result);
    }
}
