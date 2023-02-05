package com;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileSystem {

  private static ArrayList<String> files = new ArrayList<>();

  public static void main(String[] args) {
    System.out.println("Welcome to File Management System");
    System.out.println("Developed by Talha Shaikh");
    System.out.println("--------------------------------");

    File folder = new File(".");
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
        files.add(listOfFiles[i].getName());
    }

    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("1. Display Files in Ascending Order");
      System.out.println("2. Add/Delete/Search a File");
      System.out.println("3. Close Application");
      System.out.print("Enter your choice: ");

      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          Collections.sort(files, String.CASE_INSENSITIVE_ORDER);
          System.out.println("Files in Ascending Order: ");
          for (String file : files) {
            System.out.println(file);
          }
          break;
        case 2:
          System.out.println("1. Add a File");
          System.out.println("2. Delete a File");
          System.out.println("3. Search a File");
          System.out.println("4. Back to Main Menu");
          System.out.print("Enter your choice: ");

          int innerChoice = sc.nextInt();

          switch (innerChoice) {
            case 1:
              System.out.print("Enter the name of the file to add: ");
              String fileToAdd = sc.next();
              files.add(fileToAdd);
              System.out.println("File added successfully.");
              break;
            case 2:
              System.out.print("Enter the name of the file to delete: ");
              String fileToDelete = sc.next();
              if (files.contains(fileToDelete)) {
                files.remove(fileToDelete);
                System.out.println("File deleted successfully.");
              } else {
                System.out.println("File not found.");
              }
              break;
            case 3:
              System.out.print("Enter the name of the file to search: ");
              String fileToSearch = sc.next();
              if (files.contains(fileToSearch)) {
                System.out.println("File found.");
              } else {
                System.out.println("File not found.");
              }
              break;
            case 4:
              break;
            default:
              System.out.println("Invalid choice.");
              break;
          }
          break;
        case 3:
          System.out.println("Exiting the application...");
      }
    }
  }
}

