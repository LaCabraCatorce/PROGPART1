/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progpart1;


import java.util.Scanner;

/**
 *
 * @author Student
 */

public class PROGPART1 {

   
     public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
        Login auth = new Login();

        System.out.println("--- Registration ---");
        System.out.print("Enter First Name: ");
        String fName = input.nextLine();
        System.out.print("Enter Last Name: ");
        String lName = input.nextLine();
        System.out.print("Enter Username: ");
        String user = input.nextLine();
        System.out.print("Enter Password: ");
        String pass = input.nextLine();
        System.out.print("Enter Cellphone (+27...): ");
        String cell = input.nextLine();

        // Perform registration check
        String registrationMessage = auth.registerUser(user, pass, cell);
        System.out.println("\n" + registrationMessage);

        // Only proceed to login if registration was successful
        if (registrationMessage.contains("successfully")) {
            auth.setUserDetails(user, pass, fName, lName, cell);

            System.out.println("\n--- Login ---");
            System.out.print("Enter Username: ");
            String loginUser = input.nextLine();
            System.out.print("Enter Password: ");
            String loginPass = input.nextLine();

            boolean loginSuccess = auth.loginUser(loginUser, loginPass);
            System.out.println(auth.returnLoginStatus(loginSuccess));
        }
    }
    
    
    
}
    

