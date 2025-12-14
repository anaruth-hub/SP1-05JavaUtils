package com.ana.javaUtils.level1;

import java.io.*;

public class SerializationEx05 {
    public static void main(String[] args) {

        PersonEx05 personEx05 = new PersonEx05("Ana bonita", 37);
        String fileName = "personEx05.ser";

        try (ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(personEx05);
            System.out.println("Object serialized to " + fileName);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
            return;
        }

        try (ObjectInputStream in =
                new ObjectInputStream(new FileInputStream(fileName))) {
            PersonEx05 restored = (PersonEx05) in.readObject();
            System.out.println("Desearilized object: " + restored);

        } catch (IOException| ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}
