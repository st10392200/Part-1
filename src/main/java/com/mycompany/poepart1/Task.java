package com.mycompany.poepart1;

public class Task {
    private String taskName;
    private String taskDescription;
    private String developerName;
    private int taskDuration; // Duration in hours
    private String taskStatus;

    // Getters
    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    // Setters
    public void setTaskName(String taskName) {
        if (taskName == null || taskName.isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be null or empty.");
        }
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public void setTaskDuration(int taskDuration) {
        if (taskDuration <= 0) {
            throw new IllegalArgumentException("Duration must be positive.");
        }
        this.taskDuration = taskDuration;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    // Create a unique Task ID based on the task name, developer name, and task number
    public String createTaskID(int taskNumber) {
        String id = (taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase()) + ":" +
                    taskNumber + ":" +
                    (developerName.length() >= 3 ? developerName.substring(developerName.length() - 3).toUpperCase() : developerName.toUpperCase());
        return id;
    }

    // Print task details
    public String printTaskDetails(int taskNumber) {
        return "Task Name: " + taskName + 
               "\nDescription: " + taskDescription +
               "\nDeveloper: " + developerName + 
               "\nDuration: " + taskDuration + " hours" +
               "\nStatus: " + taskStatus + 
               "\nTask ID: " + createTaskID(taskNumber);
    }
}
