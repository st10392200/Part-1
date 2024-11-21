package com.mycompany.poepart1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class POEpart1 {

    
    static ArrayList<String> developers = new ArrayList<>();
    static ArrayList<String> taskNames = new ArrayList<>();
    static ArrayList<String> taskIDs = new ArrayList<>();
    static ArrayList<Integer> taskDurations = new ArrayList<>();
    static ArrayList<String> taskStatuses = new ArrayList<>();

    // Add Task Logic for Testing
    public static void addTask(String taskName, String developerName, String description, int duration, String status) {
        String taskID = taskName.substring(0, 2).toUpperCase() + ":" + taskDurations.size() + ":" + developerName.substring(developerName.length() - 3).toUpperCase();

        // Add task details to lists
        developers.add(developerName);
        taskNames.add(taskName);
        taskIDs.add(taskID);
        taskDurations.add(duration);
        taskStatuses.add(status);
    }

    // Search Task by Name
    public static String searchTaskByName(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                return "Task Found:\n" + "Task Name: " + taskNames.get(i) + "\nDeveloper: " + developers.get(i) + "\nStatus: " + taskStatuses.get(i);
            }
        }
        return "Task not found.";
    }

    // Delete Task
    public static boolean deleteTask(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                developers.remove(i);
                taskNames.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                return true;
            }
        }
                        return true;
    }

    
    
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
        // The rest of your login logic remains the same...
        displayMenu();
    }

    private static void displayMenu() {
        int totalHours = 0;

        while (true) {
            String menu = "====== Menu =======\n"
                    + "1. Add Task\n"
                    + "2. Display Report\n"
                    + "3. Search Task by Name\n"
                    + "4. Search Tasks by Developer\n"
                    + "5. Delete a Task\n"
                    + "6. Display All Tasks\n"
                    + "0. Exit";

            String choice = JOptionPane.showInputDialog(menu, "Choose an option");

            if (choice == null) {
                JOptionPane.showMessageDialog(null, "No option selected. Exiting the program.");
                System.exit(0);
            }

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    displayReport();
                    break;
                case "3":
                    searchTaskByName();
                    break;
                case "4":
                    searchTasksByDeveloper();
                    break;
                case "5":
                    deleteTask();
                    break;
                case "6":
                    displayAllTasks();
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

    private static void addTask() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name", "Task Name");
        String developerName = JOptionPane.showInputDialog("Enter Developer Name", "Developer Name");
        String taskDescription = JOptionPane.showInputDialog("Enter Task Description", "Task Description");

        int taskDuration;
        while (true) {
            try {
                taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration in hours", "0"));
                if (taskDuration <= 0) throw new IllegalArgumentException();
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid positive number for the duration.");
            }
        }

        String taskStatus = chooseTaskStatus();

        // Generate Task ID
        String taskID = taskName.substring(0, 2).toUpperCase() + ":" + taskDurations.size() + ":" + developerName.substring(developerName.length() - 3).toUpperCase();

        // Store task details in arrays
        developers.add(developerName);
        taskNames.add(taskName);
        taskIDs.add(taskID);
        taskDurations.add(taskDuration);
        taskStatuses.add(taskStatus);

        JOptionPane.showMessageDialog(null, "Task added successfully! Task ID: " + taskID);
    }

    private static void displayReport() {
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < taskNames.size(); i++) {
            if ("Done".equalsIgnoreCase(taskStatuses.get(i))) {
                report.append("Developer: ").append(developers.get(i)).append("\n")
                        .append("Task Name: ").append(taskNames.get(i)).append("\n")
                        .append("Task Duration: ").append(taskDurations.get(i)).append(" hours\n\n");
            }
        }
        if (report.length() == 0) {
            JOptionPane.showMessageDialog(null, "No tasks with status 'Done'.");
        } else {
            JOptionPane.showMessageDialog(null, report.toString());
        }
    }

    private static void searchTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name to search for:", "Task Name");
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                JOptionPane.showMessageDialog(null, "Task Found:\n"
                        + "Task Name: " + taskNames.get(i) + "\n"
                        + "Developer: " + developers.get(i) + "\n"
                        + "Task Status: " + taskStatuses.get(i));
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    private static void searchTasksByDeveloper() {
        String developerName = JOptionPane.showInputDialog("Enter Developer Name to search for tasks:", "Developer Name");
        StringBuilder tasks = new StringBuilder();
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(developerName)) {
                tasks.append("Task Name: ").append(taskNames.get(i)).append("\n")
                        .append("Task Status: ").append(taskStatuses.get(i)).append("\n\n");
            }
        }
        if (tasks.length() == 0) {
            JOptionPane.showMessageDialog(null, "No tasks found for this developer.");
        } else {
            JOptionPane.showMessageDialog(null, tasks.toString());
        }
    }

    private static void deleteTask() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name to delete:", "Task Name");
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                developers.remove(i);
                taskNames.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                JOptionPane.showMessageDialog(null, "Task deleted successfully!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }
    public static int calculateTotalHours() {
    int totalHours = 0;
    for (int duration : taskDurations) {
        totalHours += duration;
    }
    return totalHours;
}


    static void displayAllTasks() {
        StringBuilder allTasks = new StringBuilder();
        for (int i = 0; i < taskNames.size(); i++) {
            allTasks.append("Task ID: ").append(taskIDs.get(i)).append("\n")
                    .append("Developer: ").append(developers.get(i)).append("\n")
                    .append("Task Name: ").append(taskNames.get(i)).append("\n")
                    .append("Duration: ").append(taskDurations.get(i)).append(" hours\n")
                    .append("Status: ").append(taskStatuses.get(i)).append("\n\n");
        }
        
        {
        
        }
        if (allTasks.length() == 0) 
        
        {
            JOptionPane.showMessageDialog(null, "No tasks to display.");
        } else {
            JOptionPane.showMessageDialog(null, allTasks.toString());
        }
        
    }

    private static String chooseTaskStatus() {
        Object[] options = {"To Do", "Doing", "Done"};
        String status = (String) JOptionPane.showInputDialog(null, "Choose task status:", "Task Status", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        return status != null ? status : "To Do";
    }

}