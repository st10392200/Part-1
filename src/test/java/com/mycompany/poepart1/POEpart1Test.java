package com.mycompany.poepart1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class POEpart1Test {

   

    /**
     * Test of addTask method, of class POEpart1.
     */
    @Test
    public void testAddTask() {
        System.out.println("Testing addTask...");
        
        // Add Task
        POEpart1.addTask("Code Review", "Alice", "Review team's code for bugs", 3, "To Do");
        
        // Verify Task Addition
        assertEquals(1, POEpart1.taskNames.size());
        assertEquals("Code Review", POEpart1.taskNames.get(0));
        assertEquals("Alice", POEpart1.developers.get(0));
        assertEquals(3, POEpart1.taskDurations.get(0));
        assertEquals("To Do", POEpart1.taskStatuses.get(0));
    }

    /**
     * Test of searchTaskByName method, of class POEpart1.
     */
    @Test
    public void testSearchTaskByName() {
        System.out.println("Testing searchTaskByName...");
        
        // Add Task
        POEpart1.addTask("Bug Fix", "Bob", "Fix critical bugs", 5, "In Progress");
        
        // Search for the Task
        String result = POEpart1.searchTaskByName("Bug Fix");
        
        // Verify Search Result
        assertTrue(result.contains("Task Found"));
        assertTrue(result.contains("Bug Fix"));
        assertTrue(result.contains("Bob"));
        assertTrue(result.contains("In Progress"));
    }

    /**
     * Test of searchTaskByName when task does not exist.
     */
    @Test
    public void testSearchTaskByNameNotFound() {
        System.out.println("Testing searchTaskByName (Task Not Found)...");
        
        // Search for a non-existent task
        String result = POEpart1.searchTaskByName("NonExistentTask");
        
        // Verify the result
        assertEquals("Task not found.", result);
    }

    /**
     * Test of deleteTask method, of class POEpart1.
     */
    @Test
    public void testDeleteTask() {
        System.out.println("Testing deleteTask...");
        
        // Add Task
        POEpart1.addTask("Code Merge", "Charlie", "Merge feature branch", 2, "Completed");
        
        // Delete the Task
        boolean result = POEpart1.deleteTask("Code Merge");
        
        // Verify Task Deletion
        assertTrue(result);
        assertEquals(0, POEpart1.taskNames.size());
    }

    /**
     * Test of deleteTask when task does not exist.
     */
    @Test
    public void testDeleteTaskNotFound() {
        System.out.println("Testing deleteTask (Task Not Found)...");
        
        // Attempt to delete a non-existent task
        boolean result = POEpart1.deleteTask("NonExistentTask");
        
        // Verify the result
        assertFalse(result);
    }

    /**
     * Test of calculateTotalHours method, of class POEpart1.
     */
    @Test
    public void testCalculateTotalHours() {
        System.out.println("Testing calculateTotalHours...");
        
        // Add multiple tasks with durations
        POEpart1.addTask("Task 1", "Developer 1", "Description 1", 4, "To Do");
        POEpart1.addTask("Task 2", "Developer 2", "Description 2", 6, "Completed");
        
        // Calculate total hours
        int totalHours = POEpart1.calculateTotalHours();
        
        // Verify the total hours
        assertEquals(10, totalHours);
    }

    /**
     * Test of displayAllTasks method, of class POEpart1.
     */
    @Test
public void testDisplayAllTasks() {
    System.out.println("Testing displayAllTasks...");
    
    // Add sample tasks
    POEpart1.addTask("Task 1", "Dev A", "Description A", 4, "To Do");
    POEpart1.addTask("Task 2", "Dev B", "Description B", 6, "In Progress");
    
    // Call the displayAllTasks method
    try {
        POEpart1.displayAllTasks();
    } catch (Exception e) {
        fail("displayAllTasks method threw an exception: " + e.getMessage());
    }

    // If no exception is thrown, the test passes
    assertTrue(true, "displayAllTasks executed successfully.");
}


    /**
     * Test of main method, of class POEpart1.
     */
    @Test
    public void testMain() {
        System.out.println("Testing main method (basic sanity check)...");
        
        String[] args = {};
        try {
            POEpart1.main(args);
        } catch (Exception e) {
            fail("Main method threw an exception: " + e.getMessage());
        }
    }
}
