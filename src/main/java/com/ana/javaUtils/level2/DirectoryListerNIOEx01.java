package com.ana.javaUtils.level2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DirectoryListerNIOEx01 {

    private static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java DirectoryListerNIOEX01 <directoryPath>");
            return;
        }

        Path startPath = Paths.get(args[0]);

        if (!Files.exists(startPath) || !Files.isDirectory(startPath)) {
            System.out.println("The provided path is not a valid directory");
            return;
        }

        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<>() {

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                    printEntry("D", dir, attrs);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    printEntry("F", file, attrs);
                    return FileVisitResult.CONTINUE;
                }
            });

        } catch (IOException e) {
            System.out.println("Error reading directory tree: " + e.getMessage());
        }
    }

    private static void printEntry(String type, Path path, BasicFileAttributes attrs) {
        String date = DATE_FORMAT.format(new Date(attrs.lastModifiedTime().toMillis()));
        System.out.println(type + " - " + path.getFileName() + " - " + date);
    }
}
