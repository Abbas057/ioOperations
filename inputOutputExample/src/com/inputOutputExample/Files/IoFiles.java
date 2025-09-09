package com.inputOutputExample.Files;

import java.io.File;

public class IoFiles {

    // Recursive method to delete directory and all contents
    public static boolean deleteDir(File dir) {
        File[] files = dir.listFiles();
        if (files != null) { // not null = directory exists and accessible
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDir(file); // recursive call for subdirectory
                } else {
                    file.delete(); // delete file
                }
            }
        }
        return dir.delete(); // finally delete the directory itself
    }

    public static void main(String[] args) {
        try {
            // Initial file
            File file = new File("D:\\eclipse-workspace\\inputOutputExample\\src\\com\\inputOutputExample\\abc.txt");
            if (!file.exists()) {
                boolean fileCreate = file.createNewFile(); 
                System.out.println(fileCreate + " File created successfully");
            } else {
                System.out.println("File already exists");
            }

            // File length
            long length = file.length();  
            System.out.println("File length: " + length);

            // Rename file
            File newFile = new File("D:\\eclipse-workspace\\inputOutputExample\\src\\com\\inputOutputExample\\abd.txt");
            boolean rename = file.renameTo(newFile);
            System.out.println(rename + " File renamed successfully");

            // Delete file using simple delete
            if (rename) {
                boolean deleteFile = newFile.delete();
                System.out.println(deleteFile + " file deleted successfully");
            }

            // Example: Delete a directory with all files
            File dir = new File("D:\\eclipse-workspace\\inputOutputExample\\src\\com\\inputOutputExample\\testDir");
            if (!dir.exists()) {
                dir.mkdir(); // create a sample directory
                System.out.println("Sample directory created: " + dir.getAbsolutePath());
            }
            boolean deleted = deleteDir(dir);
            System.out.println(deleted + " directory deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
