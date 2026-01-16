package com.iuliana.algorithms.strings;

public class FizzBuzz {

    class Result {

        public static void fizzBuzz(int n) {
            int ct = 1;
            while(n > 0) {

                if(ct % 3 == 0 && ct % 5 == 0) {
                    System.out.println("FizzBuzz");
                }
                else if(ct % 3 == 0) {
                    System.out.println("Fizz");
                }
                else if(ct % 5 == 0) {
                    System.out.println("Buzz");
                }
                else System.out.println(ct);

                ct++;
                n--;
            }
        }
    }

    static void main(String[] args) {
        int n = 15;
        Result.fizzBuzz(n);
    }
}
