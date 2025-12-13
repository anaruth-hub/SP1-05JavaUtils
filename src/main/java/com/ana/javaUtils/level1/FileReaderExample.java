package com.ana.javaUtils.level1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderExample {

     public  static void main(String[] args) {

         if (args.length == 0) {
             System.out.println("Please provide a file path");
             return;

         }

         File file = new File(args[0]);

         if(!file.exists() || !file.isFile()) {
             System.out.println("The provided path is not a valid file");
             return;
         }

         try (Scanner scanner = new Scanner(file)) {
             while (scanner.hasNextLine()) {
                 System.out.println(scanner.nextLine());
             }
         } catch (FileNotFoundException e) {
             System.out.println("Error reading the file");
         }
     }
}
