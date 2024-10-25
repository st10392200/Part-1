package com.mycompany.poepart1;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class POEpart1 {
    
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int taskCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        
        String name;
        String lastName;
        
        // Capture username and password for registration
        System.out.print("Enter Username: ");
        String username = scanner.next();
        
        System.out.print("Enter Password: ");
        String password = scanner.next();
        
        System.out.println("Enter NAME:");
        name = scanner.next();
        
        System.out.println("Enter SURNAME:");
        lastName = scanner.next();

        // Call the registerUser method and print the result
        String registrationMessage = login.registerUser(username, password, name, lastName);
        System.out.println(registrationMessage);
        
        // Proceed to login only if registration was successful
        if (registrationMessage.contains("successfully registered")) {
            login.displayDetails();

            // User Login
            System.out.print("\nEnter Username to login: ");
            String loginUsername = scanner.next();
            System.out.print("Enter Password to login: ");
            String loginPassword = scanner.next();
            
            // Call the loginUser method
            boolean isLoginSuccessful = login.loginUser(loginUsername, loginPassword);
            
            if (isLoginSuccessful) {
                // Display the welcome message after successful login
                System.out.println("Welcome " + name + " " + lastName);
                displayMenu();
            } else {
                System.out.println("Login failed. Please try again.");
            }
        } else {
            System.out.println("Registration failed. Exiting the program.");
        }
        
        scanner.close(); // Close the scanner
    }

    // Method to display the main menu
    private static void displayMenu() {
        while (true) {
            String menu = "====== Menu =======\n"
                    + "1. Add Task\n"
                    + "2. Show Report\n"
                    + "3. Show Total Task Hours\n"
                    + "0. Exit";

            String choice = JOptionPane.showInputDialog(null, menu, "Choose an option", JOptionPane.QUESTION_MESSAGE);

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    showReport();
                    break;
                case "3":
                    showTotalTaskHours();
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

    // Method to add a task
    private static void addTask() {
        Task newTask = new Task();

        String taskName = JOptionPane.showInputDialog(null, "Enter task name:");
        newTask.setTaskName(taskName);

        String taskDescription;
        while (true) {
            taskDescription = JOptionPane.showInputDialog(null, "Enter task description (max 50 chars):");
            if (taskDescription.length() <= 50) {
                newTask.setTaskDescription(taskDescription);
                JOptionPane.showMessageDialog(null, "Task successfully captured.", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        String developer = JOptionPane.showInputDialog(null, "Enter developer name:");
        newTask.setDeveloperDetails(developer);

        String durationString = JOptionPane.showInputDialog(null, "Enter task duration (in hours):");
        try {
            int duration = Integer.parseInt(durationString);
            newTask.setTaskDuration(duration);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number for task duration.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if input is invalid
        }

        newTask.setTaskNumber(taskCount++); // Increment task count for each new task
        newTask.generateTaskID(); // Automatically generate Task ID

        String status = chooseTaskStatus();
        newTask.setTaskStatus(status);

        tasks.add(newTask); // Add task to the list
        JOptionPane.showMessageDialog(null, "Task added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Choose task status
    private static String chooseTaskStatus() {
        String[] statuses = {"To Do", "Done", "Doing"};
        int statusChoice = JOptionPane.showOptionDialog(null, "Select task status:", "Task Status",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, statuses, statuses[0]);

        switch (statusChoice) {
            case 0:
                return "To Do";
            case 1:
                return "Done";
            case 2:
                return "Doing";
            default:
                return "To Do"; // Default status
        }
    }

    // Show task report
    private static void showReport() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.", "Task Report", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder report = new StringBuilder("Task Report:\n");
        for (Task task : tasks) {
            report.append(task.printTaskDetails()).append("\n");
        }
        JOptionPane.showMessageDialog(null, report.toString(), "Task Report", JOptionPane.INFORMATION_MESSAGE);
    }

    // Show total task hours
    private static void showTotalTaskHours() {
        Task[] taskArray = tasks.toArray(new Task[0]);
        int totalHours = Task.returnTotalHours(taskArray);
        JOptionPane.showMessageDialog(null, "Total Task Hours: " + totalHours, "Total Task Hours", JOptionPane.INFORMATION_MESSAGE);
    }
}
