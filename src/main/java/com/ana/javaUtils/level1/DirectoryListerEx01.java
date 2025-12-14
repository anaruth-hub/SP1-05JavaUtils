package com.ana.javaUtils.level1;

import java.io.File;
import java.util.Arrays;

public class DirectoryListerEx01 {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please provide a directory path");
            return;

        }

        File directory = new File(args[0]);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The provided path is not a valid directory");
            return;
        }

        String[] content = directory.list();

        if (content == null) {
        System.out.println("Could not read directory content");
        return;

    }
        Arrays.sort(content);

        for (String name : content) {
            System.out.println(name);
        }
    }
}
