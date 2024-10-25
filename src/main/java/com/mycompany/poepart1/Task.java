package com.mycompany.poepart1;

public class Task {

    private String taskName;
    private int taskNumber; // Auto-generated
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID; // Auto-generated
    private String taskStatus;

    // Setters for each attribute
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDeveloperDetails(String developerDetails) {
        this.developerDetails = developerDetails;
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void generateTaskID() {
        this.taskID = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }

    // Method to check if the task description is <= 50 characters
    public boolean checkTaskDescription() {
        return this.taskDescription.length() <= 50;
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
            totalHours += task.getTaskDuration();
        }
        return totalHours;
    }

    // Getters for each attribute
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
