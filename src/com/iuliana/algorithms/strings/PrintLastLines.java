package com.iuliana.algorithms.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Stream;

public class PrintLastLines {

    static void printLastLinesV1(String filePath, int numberOfLines) {

        try(Stream<String> lines = Files.lines(Paths.get(filePath))) {

            List<String> allLines = lines.toList();
            System.out.println(allLines);

            int totalLines = allLines.size();
            int start = Math.max(0, totalLines - numberOfLines);

            System.out.println("Ultimele " + numberOfLines + " linii ale fișierului:");
            for (int i = start; i < totalLines; i++) {
                System.out.println(allLines.get(i));
            }

        }
        catch (IOException e) {
            System.err.println(e);
        }
    }

    static void printLastLinesV2(String filePath, int numberOfLines) {

        Deque<String> buffer = new ArrayDeque<>();

        try(Stream<String> lines = Files.lines(Paths.get(filePath))) {

            // Window circular buffer
            lines.forEach(line -> {
                buffer.addLast(line);
                if(buffer.size() > numberOfLines) {
                    buffer.removeFirst();
                }
            });

            System.out.println("Ultimele " + numberOfLines + " linii ale fișierului:");
            buffer.forEach(System.out::println);
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }

    static void main() {
        String filePath = "test.txt";
//        populateFileWithData(filePath, 1_000_000);

//        printLastLinesV1(filePath, 3);
        printLastLinesV2(filePath, 20);
    }

    static void populateFileWithData(String filePath, int numberOfLines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 1; i <= numberOfLines; i++) {
                writer.write("Aceasta este linia numarul " + i);
                if (i < numberOfLines) writer.newLine();
            }
            System.out.println("Fișierul test.txt cu "+ numberOfLines +" de linii a fost generat!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
