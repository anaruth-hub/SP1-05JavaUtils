package com.ana.javaUtils.level1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx04 {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java FileReaderEx04 <filePath>");
            return;
        }

        File file = new File(args[0]);

        if (!file.exists() || !file.isFile()) {
            System.out.println("the provided path is not a valid file");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
