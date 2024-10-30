package com.mycompany.poepart1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class POEpart1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        // User Registration
        System.out.print("Enter Username: ");
        String username = scanner.next();

        System.out.print("Enter Password: ");
        String password = scanner.next();

        System.out.print("Enter First Name: ");
        String firstName = scanner.next();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.next();

        String registrationMessage = login.registerUser(username, password, firstName, lastName);
        System.out.println(registrationMessage);

        if (registrationMessage.contains("successfully registered")) {
            login.displayDetails();

            // User Login
            System.out.print("\nEnter Username to login: ");
            String loginUsername = scanner.next();
            System.out.print("Enter Password to login: ");
            String loginPassword = scanner.next();

            boolean isLoginSuccessful = login.loginUser(loginUsername, loginPassword);

            // Console output for login result
            if (isLoginSuccessful) {
                System.out.println("Welcome to EasyKanban, " + firstName + " " + lastName + "!");
                displayMenu(); // Show menu after successful login
            } else {
                System.out.println("Login failed. Please try again.");
            }
        } else {
            System.out.println("Registration failed. Exiting the program.");
        }

        scanner.close();
    }

    private static void displayMenu() {
        ArrayList<Task> tasks = new ArrayList<>();
        int totalHours = 0; // Track total hours as an int

        while (true) {
            String menu = "====== Menu =======\n"
                    + "1. Add Task\n"
                    + "2. Show Report\n"
                    + "0. Exit";

            String choice = JOptionPane.showInputDialog(menu, "Choose an option");

            if (choice == null) {
                JOptionPane.showMessageDialog(null, "No option selected. Exiting the program.");
                System.exit(0);
            }

            switch (choice) {
                case "1":
                    String taskCountString = JOptionPane.showInputDialog("How many tasks would you like to add?", "Task Count");
                    int numberOfTasks;

                    try {
                        numberOfTasks = Integer.parseInt(taskCountString);
                        if (numberOfTasks <= 0) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid number greater than 0.");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                        continue;
                    }

                    for (int i = 0; i < numberOfTasks; i++) {
                        Task task = new Task(); // Create a new Task instance

                        String taskName = JOptionPane.showInputDialog("Enter Task Name for Task " + (i + 1), "Task Name");
                        String taskDescription = JOptionPane.showInputDialog("Enter Task Description for Task " + (i + 1), "Task Description");
                        String developerName = JOptionPane.showInputDialog("Enter Developer Name for Task " + (i + 1), "Developer Name");

                        int taskDuration;
                        while (true) {
                            String durationString = JOptionPane.showInputDialog("Enter Duration (in hours) for Task " + (i + 1), "Task Duration");
                            try {
                                taskDuration = Integer.parseInt(durationString);
                                if (taskDuration <= 0) {
                                    JOptionPane.showMessageDialog(null, "Please enter a valid duration greater than 0.");
                                    continue;
                                }
                                break; // Exit the loop if valid duration is entered
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                            }
                        }

                        String taskStatus = chooseTaskStatus();

                        // Use setter methods to initialize the task
                        task.setTaskName(taskName);
                        task.setTaskDescription(taskDescription);
                        task.setDeveloperName(developerName);
                        task.setTaskDuration(taskDuration);
                        task.setTaskStatus(taskStatus);

                        // Add the task's duration to the total
                        totalHours += taskDuration;

                        // Add the task to the list
                        tasks.add(task);

                        JOptionPane.showMessageDialog(null, task.printTaskDetails(i + 1));

                    }
                    break;

                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;

                case "0":
                    JOptionPane.showMessageDialog(null, "Exiting the program...");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice! Please select a valid option.");
                    break;
            }
        }
    }

    private static String chooseTaskStatus() {
        Object[] options = {"To Do", "Doing", "Done"};
        String status = (String) JOptionPane.showInputDialog(null, "Choose task status:", "Task Status", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        return status != null ? status : "To Do";
    }
}
