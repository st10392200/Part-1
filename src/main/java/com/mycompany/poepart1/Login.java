package com.mycompany.poepart1;

import java.util.*;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
  
 /*  private String username;
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
       return username.contains("_") && username.length() >= 5; // Fix: username length should be at least 5
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

   // Method to register user with validations
   public String registerUser(String username, String password) {
       boolean isUsernameValid = checkUsername(username);
       boolean isPasswordValid = checkPasswordComplexity(password);

       if (!isUsernameValid && !isPasswordValid) {
           return "Username is incorrectly formatted, and password does not meet the complexity requirements.";
       } else if (!isUsernameValid) {
           return "Username is incorrectly formatted. It should contain an underscore and be at least 5 characters long.";
       } else if (!isPasswordValid) {
           return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
       } else {
           setUsername(username);
           setPassword(password);
           return "User successfully registered.";
       }
   }

   // Method to log in user by checking entered credentials
   public boolean loginUser(String enteredUsername, String enteredPassword) {
       if (this.username.equals(enteredUsername) && this.password.equals(enteredPassword)) {
           System.out.println("login successful!");
           return true;
       } else {
           System.out.println("login failed. Incorrect username or password.");
           return false;
       }
   }

   // New method to return login status
   public String returnLoginStatus(String enteredUsername, String enteredPassword) {
       if (loginUser(enteredUsername, enteredPassword)) {
           return "login successful!";
       } else {
           return "login failed. Incorrect username or password.";
       }
   }

   // Method to display user details
   public void displayDetails() {
       System.out.println("Username: " + username);
   }
*/
    
    
}
