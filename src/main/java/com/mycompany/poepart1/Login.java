/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

import java.util.*;
/**
 *
 * @author RC_Student_lab
 */
public class Login {
  
   private String username;
   private String password;
   
   // Constructor
   public Login() {
   }

   // Getter and Setter for Username
   public String getUsername() {
       return username;
   }

   public void setUsername(String username) {
       this.username = username;
   }

   // Getter and Setter for Password
   public String getPassword() {
       return password;
   }

   public void setPassword(String password) {
       this.password = password;
   }
 // Check if username contains an underscore and has more than 5 characters
   public boolean checkUsername(String username) {
        return username.contains("_") && username.length() > 5;
   }


   // Method to check password complexity
   public boolean checkPasswordComplexity(String password) {
       int n = password.length();
       boolean hasLower = false, hasUpper = false, hasDigit = false, specialChar = false;

       Set<Character> specialCharacters = new HashSet<>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));

       for (char ch : password.toCharArray()) {
           if (Character.isLowerCase(ch)) hasLower = true;
           if (Character.isUpperCase(ch)) hasUpper = true;
           if (Character.isDigit(ch)) hasDigit = true;
           if (specialCharacters.contains(ch)) specialChar = true;
            
       } 
       return hasLower && hasUpper && hasDigit && specialChar && n >= 8;
   }
    public String registerUser(String username, String password) {
       boolean isUsernameValid = checkUsername(username);
       boolean isPasswordValid = checkPasswordComplexity(password);

       if (!isUsernameValid && !isPasswordValid) {
           return "Username is incorrectly formatted, and password does not meet the complexity requirements.";
       } else if (!isUsernameValid) {
           return "Username is incorrectly formatted.";
       } else if (!isPasswordValid) {
           return "Password does not meet the complexity requirements.";
       } else {
           // If both conditions are met
           setUsername(username);
           setPassword(password);
           return "The two above conditions have been met and the user has been successfully registered.";
       }
   }
    
public boolean loginUser(String enteredUsername, String enteredPassword) {
       // Check if entered credentials match the stored ones
       if (this.username.equals(enteredUsername) && this.password.equals(enteredPassword)) {
           System.out.println("Login successful!");
           return true;
       } else {
           System.out.println("Login failed. Incorrect username or password.");
           return false;
       }
   }
 // New method to return login status
   public String returnLoginStatus(String enteredUsername, String enteredPassword) {
       // Call loginUser method to verify credentials
       if (loginUser(enteredUsername, enteredPassword)) {
           return "Login successful!";
       } else {
           return "Login failed. Incorrect username or password.";
       }
   }
   // Method to display details
   public void displayDetails() {
       System.out.println("Username: " + username);
       System.out.println("Password: " + password);
   }
}

