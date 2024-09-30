/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepart1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class LoginTest {

   


    /**
     * Test of getUsername method, of class Login.
     */
   
    @Test
public void testGetUsername() {
    System.out.println("getUsername");
    Login instance = new Login();
    String expResult = "kyl_1";
    instance.setUsername(expResult); 
    String result = instance.getUsername();
    assertEquals(expResult, result);
}
@Test
public void testSetUsername() {
    System.out.println("setUsername");
    String username = "kyl_1"; 
    Login instance = new Login();
    instance.setUsername(username);
    assertEquals(username, instance.getUsername()); 
}
@Test
public void testGetPassword() {
    System.out.println("getPassword");
    Login instance = new Login();
    String expResult = "Ch&&sec@ke9g!"; 
    instance.setPassword(expResult); 
    String result = instance.getPassword();
    assertEquals(expResult, result);
}
@Test
public void testSetPassword() {
    System.out.println("setPassword");
    String password = "Ch&&sec@ke9g!"; 
    Login instance = new Login();
    instance.setPassword(password);
    assertEquals(password, instance.getPassword()); 
}
@Test
public void testCheckUsername() {
    System.out.println("checkUsername");
    String validUsername = "kyl_1"; 
    String invalidUsername = "kyle!!!!!";
    Login instance = new Login();
    assertTrue(instance.checkUsername(validUsername));
    assertFalse(instance.checkUsername(invalidUsername)); 
}
@Test
public void testCheckPasswordComplexity() {
    System.out.println("checkPasswordComplexity");
    String validPassword = "Ch&&sec@ke9g!";
    String invalidPassword = "password"; 
    Login instance = new Login();
    assertTrue(instance.checkPasswordComplexity(validPassword));
    assertFalse(instance.checkPasswordComplexity(invalidPassword)); 
}
@Test
public void testRegisterUser() {
    System.out.println("registerUser");
    String username = "kyl_1";
    String password = "Ch&&sec@ke9g!";
    Login instance = new Login();
    String expResult = "User successfully registered.";
    String result = instance.registerUser(username, password);
    assertEquals(expResult, result);
}
@Test
public void testLoginUser() {
    System.out.println("loginUser");
    String enteredUsername = "kyl_1";
    String enteredPassword = "Ch&&sec@ke9g!";
    Login instance = new Login();
    instance.registerUser(enteredUsername, enteredPassword); 
    assertTrue(instance.loginUser(enteredUsername, enteredPassword));
    assertFalse(instance.loginUser("invalidUser", "invalidPass")); 
}
@Test
public void testReturnLoginStatus() {
    System.out.println("returnLoginStatus");
    String enteredUsername = "kyl_1";
    String enteredPassword = "Ch&&sec@ke9g!";
    Login instance = new Login();
    instance.registerUser(enteredUsername, enteredPassword); 
    String expResult = "login successful!";
    String result = instance.returnLoginStatus(enteredUsername, enteredPassword);
    assertEquals(expResult, result);
}
@Test
public void testDisplayDetails() {
    System.out.println("displayDetails");
    Login instance = new Login();
    instance.setUsername("kyl_1");
    instance.setPassword("Ch&&sec@ke9g!");
    instance.displayDetails(); 
}

    
}
