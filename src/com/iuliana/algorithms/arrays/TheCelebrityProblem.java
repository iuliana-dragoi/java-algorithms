package com.iuliana.algorithms.arrays;

import java.util.HashSet;
import java.util.Set;

public class TheCelebrityProblem {

    static void main() {
        int[][] matrix = {
            {0, 1, 0}, // person 0 knows person 1
            {0, 0, 0}, // person 1 knows no one
            {0, 1, 0} // person 2 knows person 1
        };

        int celebrity = findCelebrity(matrix);
        System.out.println("Celebrity: " + celebrity);
    }

    static Integer findCelebrity(int[][] matrix) {
        int n = matrix.length;
        checkPeople(n);

        int candidate = 0; // assume person 0 is celebrity

        for(int i = 1; i < n; i++) {
            if(matrix[candidate][i] == 1) {
                candidate = i;
            }
        }

        for(int i =0; i < n; i++) {
            if(i != candidate) {
                if(matrix[candidate][i] == 1 || matrix[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }

    static void checkPeople(int n) {
        Set<Integer> people = new HashSet<>();
        for(int i = 0; i < n; i++) { // current person
            for(int j = 0; j < n; j++) { // person that i knows
                people.add(i);
                people.add(j);
            }
        }

        for(Integer person : people.stream().toList()) {
            System.out.println("Person: " + person);
        }
        int numberOfPeople = Math.toIntExact(people.stream().count());
        System.out.println("We have: " + numberOfPeople + " " + people);
    }
}
