package com.iuliana.algorithms.strings;

public class DrawCircle {

    static void main() {
        drawCircle(5);
    }

    // For each position (x, y) in the grid, if x^2 + y^2 ≈ r^2, it is on c
    static void drawCircle(int r) {

        int n = 15;
        int x, y;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                x = i - r;
                y = j - r;

                if(x * x + y * y <= r * r + 1) {
                    System.out.print("x");
                }
                else {
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
