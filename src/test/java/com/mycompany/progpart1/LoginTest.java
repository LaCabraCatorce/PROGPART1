/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progpart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */

    

    
    
    



/**
 * Unit tests based on the POE requirements table.
 */
public class LoginTest {
    
    Login login = new Login();

    @Test
    public void testUsernameCorrectlyFormatted() {
        // Test Data: "kyl_1" -> True
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        // Test Data: "kyle!!!!!!" -> False
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testPasswordComplexitySuccess() {
        // Test Data: "Ch&&sec@ke99!" -> True
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordComplexityFailure() {
        // Test Data: "password" -> False
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellNumberFormatted() {
        // Test Data: +27838968976 -> True
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellNumberIncorrect() {
        // Test Data: 08966553 -> False
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testLoginSuccess() {
        login.setUserDetails("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailure() {
        login.setUserDetails("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith", "+27838968976");
        assertFalse(login.loginUser("bad_user", "wrong_pass"));
    }
}

