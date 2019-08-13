package com.akadatsky;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Group group = new Group("Java", "30 Jun 2019");
        group.addStudent(new Student("Alex", 22));
        group.addStudent(new Student("Ben", 44));
        group.addStudent(new Student("Carl", 33));


        String output = gson.toJson(group);

        try {
            saveToFile(output);
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        readFromFile(sb);
        String json = sb.toString();
        Group restoredGroup = gson.fromJson(json, Group.class);
        System.out.println(restoredGroup);
    }

    private static void readFromFile(StringBuilder sb) {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                sb.append(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveToFile(String output) throws Exception {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("test.txt")))) {
            writer.write(output);
        }
    }

}
