package com.mycompany.poepart1;

import java.util.HashSet;
import java.util.Set;

public class Login {

    private String username;
    private String password;
    private String name;
    private String lastName;

    // Getter for Username
    public String getUsername() {
        return username;
    }

    // Getter for Password
    public String getPassword() {
        return password;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Getter for Last Name
    public String getLastName() {
        return lastName;
    }

    // Setters for Username and Password
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Check if username contains an underscore and has at least 5 characters
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check password complexity
    public boolean checkPasswordComplexity(String password) {
        int n = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false, specialChar = false;

        Set<Character> specialCharacters = new HashSet<>(Set.of('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));

        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) hasLower = true;
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isDigit(ch)) hasDigit = true;
            if (specialCharacters.contains(ch)) specialChar = true;
        }
        return hasLower && hasUpper && hasDigit && specialChar && n >= 8;
    }

    // Method to register user with validations
    public String registerUser(String username, String password, String name, String lastName) {
        boolean isUsernameValid = checkUsername(username);
        boolean isPasswordValid = checkPasswordComplexity(password);

        if (!isUsernameValid && !isPasswordValid) {
            return "Username is incorrectly formatted, and password does not meet the complexity requirements.";
        } else if (!isUsernameValid) {
            return "Username is incorrectly formatted. It should contain an underscore and be at least 5 characters long.";
        } else if (!isPasswordValid) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        } else {
            // Directly set the user details
            this.username = username;
            this.password = password;
            this.name = name;
            this.lastName = lastName;
            return "User successfully registered.";
        }
    }

    // Method to log in user by checking entered credentials
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return this.username != null && this.password != null && 
               this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    // Method to display user details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Last Name: " + lastName);
        System.out.println("Username: " + username);
    }
}
