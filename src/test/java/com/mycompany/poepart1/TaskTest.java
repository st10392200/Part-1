package com.mycompany.poepart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testTaskCreationAndDetails() {
        Task task = new Task();

        // Setting task details
        task.setTaskName("Add Task Feature");
        task.setTaskDescription("Create Add Task feature to add task users.");
        task.setDeveloperName("Mike Smith");
        task.setTaskDuration(10);
        task.setTaskStatus("Doing");

        // Testing Task ID creation
        String expectedTaskID = "AD:1:ITH"; // "AD" from "Add", "1" is task number, "ITH" from "Mike Smith"
        assertEquals(expectedTaskID, task.createTaskID(1));

        // Testing printed task details
        String expectedDetails = "Task Name: Add Task Feature\n"
                + "Description: Create Add Task feature to add task users.\n"
                + "Developer: Mike Smith\n"
                + "Duration: 10 hours\n"
                + "Status: Doing\n"
                + "Task ID: " + expectedTaskID;

        assertEquals(expectedDetails, task.printTaskDetails(1));
    }

    @Test
    void testTaskWithRobynHarrison() {
        Task task = new Task();

        // Setting task details
        task.setTaskName("Login Feature");
        task.setTaskDescription("Create login to authenticate users.");
        task.setDeveloperName("Robyn Harrison");
        task.setTaskDuration(8);
        task.setTaskStatus("Doing");

        // Testing Task ID creation
        String expectedTaskID = "LO:1:SON"; // "LO" from "Login", "1" is task number, "SON" from "Robyn Harrison"
        assertEquals(expectedTaskID, task.createTaskID(1));

        // Testing printed task details
        String expectedDetails = "Task Name: Login Feature\n"
                + "Description: Create login to authenticate users.\n"
                + "Developer: Robyn Harrison\n"
                + "Duration: 8 hours\n"
                + "Status: Doing\n"
                + "Task ID: " + expectedTaskID;

        assertEquals(expectedDetails, task.printTaskDetails(1));
    }

    @Test
    void testSettersWithInvalidInput() {
        Task task = new Task();

        // Testing exception for invalid task name
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName("");
        });
        assertEquals("Task name cannot be null or empty.", exception.getMessage());

        // Testing exception for invalid task duration
        exception = assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDuration(-1);
        });
        assertEquals("Duration must be positive.", exception.getMessage());
    }
}
