/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progpart1;


import java.util.Scanner;

/**
 *
 * @author Student
 */

import java.util.ArrayList;
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

            // CONNECTED: If login works, launch the messaging app features
            if (loginSuccess) {
                System.out.println("\nWelcome back, " + fName + "!");
                runMessagingApp(input);
            }
        }
    }

    // CONNECTED: This contains your messaging menu logic
    public static void runMessagingApp(Scanner scanner) {
        ArrayList<String> messageLimit = new ArrayList<>();
        int characterLimit = 250; // Changed to int for character length comparison
        boolean running = true;

        while (running) {
            System.out.println("\n--- Welcome to quick chat! ---");
            System.out.println("Option 1 = Send message");
            System.out.println("Option 2 = See recent messages");
            System.out.println("Option 3 = Quit app");
            System.out.print("Choose an option (1, 2, or 3): ");
            String choose = scanner.nextLine();

            if (choose.equals("1")) {
                System.out.println("\nYou have selected Option 1 to send messages");
                System.out.print("Send your message: ");
                String message = scanner.nextLine();

                // Validation logic fixed
                if (message.length() <= characterLimit) {
                    messageLimit.add(message); // Saves the message to your list
                    System.out.println("Message sent successfully!");
                } else {
                    System.out.println("Error: Please enter a message less than 250 characters.");
                }

            } else if (choose.equals("2")) {
                System.out.println("\n--- Feature is coming soon! ---");
                if (messageLimit.isEmpty()) {
                    System.out.println("No messages sent yet.");
                } else {
                    // Displays the saved messages from the ArrayList
                    for (String msg : messageLimit) {
                        System.out.println("- " + msg);
                    }
                }
            } else if (choose.equals("3")) {
                System.out.println("Quitting application. Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
