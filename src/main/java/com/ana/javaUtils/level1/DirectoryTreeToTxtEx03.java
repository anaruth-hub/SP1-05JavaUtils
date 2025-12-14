package com.ana.javaUtils.level1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DirectoryTreeToTxtEx03 {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage: java ... DirectoryTreeToTxtEx03 <directoryPath> <outputTxtPath>");
            return;
        }

        File rootDir = new File(args[0]);
        if (!rootDir.exists() || !rootDir.isDirectory()) {
            System.out.println("The provided path is not a valid directory: " + args[0]);
            return;
        }

        File outputFile = new File(args[1]);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writerTree(rootDir, 0, writer);
            System.out.println("TXT generated at: " + outputFile.getPath());
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    private static void writerTree(File dir, int depth, BufferedWriter writer) throws IOException {
        File[] items = dir.listFiles();
        if (items == null) return;

        Arrays.sort(items, (x, y) -> x.getName().compareToIgnoreCase(y.getName()));

        for (File item : items) {
            String type = item.isDirectory() ? "D" : "F";
            String lastModified = DATE_FORMAT.format(new Date(item.lastModified()));
            String indent = " ".repeat(depth);

            writer.write(indent + type + " - " + item.getName() + " - " + lastModified);
            writer.newLine();

            if (item.isDirectory()) {
                writerTree(item, depth + 1, writer);
            }
        }
    }
}
