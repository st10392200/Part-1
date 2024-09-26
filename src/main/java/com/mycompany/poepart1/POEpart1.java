/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;
import java.util.*;
/**
 *
 * @author RC_Student_lab
 */
public class POEpart1 {
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        
        // Capture username
        System.out.print("Enter Username: ");
        String username = scanner.next();
        login.setUsername(username);

        // Capture password
        System.out.print("Enter Password: ");
        String password = scanner.next();
        login.setPassword(password);
        
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
            System.out.println("Welcome " + loginUsername + "!");
        } else {
            System.out.println("Please try logging in again.");
        }
        
        
        
        
        
        
    }
}