/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;
import java.util.*;
import javax.swing.*;
import java.util.ArrayList;
/**
 *
 * @author RC_Student_lab
 */
public class POEpart1 {
    
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int taskCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Login login = new Login();
        
        /* String name;
         String lastName;
   
        // Capture username
        System.out.print("Enter Username: ");
        String username = scanner.next();
        login.setUsername(username);

        // Capture password
        System.out.print("Enter Password: ");
        String password = scanner.next();
        login.setPassword(password);
        
         
         //name
        System.out.println("Enter NAME");
         name = sc.next();
         //lastname
         System.out.println("Enter SURNAME");
         lastName = sc.next();
        
  // Call the registerUser method and print the result
        String registrationMessage = login.registerUser(username, password);
        System.out.println(registrationMessage);
        
        // Display details if registration was successful
        if (registrationMessage.contains("successfully registered")) {
            login.displayDetails();
        }
        
        // User Login
        System.out.print("\nEnter Username to login: ");
        String loginUsername = scanner.next();
        System.out.print("Enter Password to login: ");
        String loginPassword = scanner.next();
        
        // Call the loginUser method
        boolean isLoginSuccessful = login.loginUser(loginUsername, loginPassword);
        
        if (isLoginSuccessful) {
            System.out.println("Welcome " + name + ""+lastName);
        } else {
            System.out.println("Please try logging in again.");
        }
        
        
        
        
        
        
    }*/
        
       

    
        // Login to the system
        if (login()) {
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban", "Login Successful", JOptionPane.INFORMATION_MESSAGE);

            while (true) {
                // Display menu
                String menu = "====== Menu =======\n"
                        + "1. Add Task\n"
                        + "2. Show Report\n"
                        + "0. Exit";
                
                String choice = JOptionPane.showInputDialog(null, menu, "Choose an option", JOptionPane.QUESTION_MESSAGE);
                
                switch (choice) {
                    case "1":
                        addTask();
                        break;
                    case "2":
                        showReport();
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
        } else {
            JOptionPane.showMessageDialog(null, "Login failed. Exiting program.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Simple login functionality
    private static boolean login() {
        String username = JOptionPane.showInputDialog(null, "Enter username:");
        String password = JOptionPane.showInputDialog(null, "Enter password:");
        return username.equals("admin") && password.equals("1234");
    }

    // Method to add a task
    private static void addTask() {
        String taskName = JOptionPane.showInputDialog(null, "Enter task name:");

        String taskDescription = "";
        while (true) {
            taskDescription = JOptionPane.showInputDialog(null, "Enter task description (max 50 chars):");
            if (taskDescription.length() <= 50) {
                JOptionPane.showMessageDialog(null, "Task successfully captured.", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        String developer = JOptionPane.showInputDialog(null, "Enter developer name:");
        String durationString = JOptionPane.showInputDialog(null, "Enter task duration (in hours):");
        int duration = Integer.parseInt(durationString);

        String taskID = generateTaskID(taskName, taskCount, developer);
        String status = chooseTaskStatus();

        tasks.add(new Task(taskName, taskCount++, taskDescription, developer, duration, taskID, status));
        JOptionPane.showMessageDialog(null, "Task added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Generate Task ID
    private static String generateTaskID(String taskName, int taskNumber, String developer) {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developer.substring(developer.length() - 3).toUpperCase();
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
            report.append(task.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, report.toString(), "Task Report", JOptionPane.INFORMATION_MESSAGE);
    }
}

// Task class to model a task entity
class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskID, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "Task Name: " + taskName + "\nTask Number: " + taskNumber + "\nDescription: " + taskDescription +
                "\nDeveloper: " + developerDetails + "\nDuration: " + taskDuration + " hours\nTask ID: " + taskID + 
                "\nStatus: " + taskStatus + "\n";
    }
}

