/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progpart1;

/**
 *
 * @author Student
 */
import java.util.regex.Pattern;

public class Login {
    
    


/**
 * The Login class handles the logic for user registration and authentication.
 * It includes methods for validation and status reporting.
 */


    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String cellNumber;

    // Methods to set user data (simulating registration input)
    public void setUserDetails(String user, String pass, String first, String last, String cell) {
        this.username = user;
        this.password = pass;
        this.firstName = first;
        this.lastName = last;
        this.cellNumber = cell;
    }

    /**
     * Checks if the username contains an underscore and is no more than 5 characters long.
     */
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    /**
     * Checks if the password meets complexity rules:
     * - At least 8 characters
     * - Contains a capital letter
     * - Contains a number
     * - Contains a special character
     */
    public boolean checkPasswordComplexity(String password) {
        boolean hasCap = !password.equals(password.toLowerCase());
        boolean hasNum = password.matches(".*\\d.*");
        boolean hasSpecial = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE).matcher(password).find();
        boolean hasLength = password.length() >= 8;

        return hasCap && hasNum && hasSpecial && hasLength;
    }

    /**
     * Checks if the cellphone number contains the international country code (+27)
     * and is exactly 10 characters long (excluding the code).
     */
    public boolean checkCellPhoneNumber(String cell) {
        // Condition: International code (+27) and length check
        // Pattern: starts with +27 followed by exactly 9 digits (total 12 chars)
        return cell.startsWith("+27") && cell.length() == 12;
    }

    /**
     * Returns registration status message based on validation.
     */
    public String registerUser(String username, String password, String cell) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cell)) {
             return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        return "Username successfully captured.\nPassword successfully captured.\nCell number successfully added.";
    }

    /**
     * Verifies if entered credentials match stored ones.
     */
    public boolean loginUser(String enteredUser, String enteredPass) {
        return enteredUser.equals(this.username) && enteredPass.equals(this.password);
    }

    /**
     * Returns the login status message.
     */
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}

