package com;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileSystem {

  // ArrayList to store the names of files
  private static ArrayList<String> files = new ArrayList<>();

  public static void main(String[] args) {
    // Print welcome message and developer information
    System.out.println("Welcome to File Management System");
    System.out.println("Developed by Talha Shaikh");
    System.out.println("--------------------------------");

    // Get all the files in the current folder and add them to the ArrayList
    File folder = new File(".");
    File[] listOfFiles = folder.listFiles();
    for (int i = 0; i < listOfFiles.length; i++) {
        files.add(listOfFiles[i].getName());
    }

    // Scanner to read user input
    Scanner sc = new Scanner(System.in);

    // Run the menu loop
    while (true) {
      // Main menu options
      System.out.println("1. Display Files in Ascending Order");
      System.out.println("2. Add/Delete/Search a File");
      System.out.println("3. Close Application");
      System.out.print("Enter your choice: ");

      int option = 0;
      boolean validOption = false;

      // Validate user input and only accept integer inputs
      if (sc.hasNextInt()) {
          option = sc.nextInt();
          sc.nextLine(); // to consume the newline character

          // Check if the input is between 1 and 3
          if (option >= 1 && option <= 4) {
            validOption = true;
          } else {
            System.out.println("Invalid option. Please try again.");
          }
        } else {
          System.out.println("Invalid input. Only integers are allowed.");
          sc.nextLine(); // to consume the invalid input
        }

      // Main menu switch case
      switch (option) {
        case 1:
          // Sort the files in ascending order and print them
          Collections.sort(files, String.CASE_INSENSITIVE_ORDER);
          System.out.println("Files in Ascending Order: ");
          for (String file : files) {
            System.out.println(file);
          }
          break;
        case 2:
          // Inner menu options
          System.out.println("1. Add a File");
          System.out.println("2. Delete a File");
          System.out.println("3. Search a File");
          System.out.println("4. Back to Main Menu");
          System.out.print("Enter your choice: ");

          int innerChoice = sc.nextInt();

          // Inner menu switch case
          switch (innerChoice) {
            case 1:
              // Add a file to the ArrayList
              System.out.print("Enter the name of the file to add: ");
              String fileToAdd = sc.next();
              files.add(fileToAdd);
              System.out.println("File added successfully.");
              break;
            case 2:
              // Delete a file from the ArrayList
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
            // Search a file from the ArrayList
              System.out.print("Enter the name of the file to search: ");
              String fileToSearch = sc.next();
              if (files.contains(fileToSearch)) {
                System.out.println("File found.");
              } else {
                System.out.println("File not found.");
              }
              break;
            case 4:
            // Take back to main menu
              break;
            default:
              System.out.println("Invalid choice.");
              break;
          }
          break;
        case 3:
        // Exiting the application
          System.out.println("Exiting the application...");
          System.exit(0);
          break;
      }
    }
  }
}

