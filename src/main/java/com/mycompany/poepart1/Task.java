/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

/**
 *
 * @author RC_Student_lab
 */
public class Task {
       private String taskName;
    private int taskNumber; // Auto-generated
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID; // Auto-generated
    private String taskStatus;

    // Constructor
    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID(); // Auto-generate the task ID
    }

    // Method to check if the task description is <= 50 characters
    public boolean checkTaskDescription() {
        return this.taskDescription.length() <= 50;
    }

    // Method to create a unique task ID
    public String createTaskID() {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }

    // Method to print the task details
    public String printTaskDetails() {
        return "Task Name: " + taskName +
                "\nTask Number: " + taskNumber +
                "\nTask Description: " + taskDescription +
                "\nDeveloper: " + developerDetails +
                "\nTask Duration: " + taskDuration + " hours" +
                "\nTask ID: " + taskID +
                "\nTask Status: " + taskStatus + "\n";
    }

    // Static method to return total task duration
    public static int returnTotalHours(Task[] tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }

    // Getters and Setters
    public String getTaskName() {
        return taskName;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskID() {
        return taskID;
    }

    public String getTaskStatus() {
        return taskStatus;
    }
    
}
