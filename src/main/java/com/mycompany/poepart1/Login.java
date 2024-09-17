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
   private String Username;
   private String Password;
   
   //Constructor
   
  public String getUserName (){
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }
    
 public String getPassword (){
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }   
   
    

   public boolean checkPasswordComplexity(String password) {
         
   int n = password.length();
        boolean hasLower = false, hasUpper = false,
                hasDigit = false, specialChar = false;
                Set<Character> set = new HashSet<>();
                set.addAll(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));

        for (char i : password.toCharArray()){
        
            if (Character.isLowerCase(i))
                hasLower = true;
            if (Character.isUpperCase(i))
                hasUpper = true;
            if (Character.isDigit(i))
                hasDigit = true;
            if (set.contains(i))
                specialChar = true;
        }
        if (hasDigit && hasLower && hasUpper && specialChar&& (n >= 8)){
         System.out.print("Password successfully captured"); return true;
        }
        else
        {
            System.out.println("Password is not correctly formatted please ensure that the password contains at least 8 chracters, a capital letter, a number and a special character");
       return false; 
        }                
   }
                
  
}