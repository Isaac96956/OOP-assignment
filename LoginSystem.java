/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginsystem;

import java.util.Scanner;
import java.io.Console;

/**
 * BSD 214 Object-Oriented Programming 2 - Assignment 1
 * This program handles user authentication and provides 3 attempts for successful login.
 */
public class LoginSystem {
    
    // Predefined valid credentials
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";
    
//    login process
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 3;
        boolean loginSuccessful = false;
        
        System.out.println("=== LOGIN SYSTEM WITH THREE ATTEMPTES ONLY ===");
        System.out.println("You have " + attempts + " attempts to login to system.\n");
        
        // Login process with three atempts
        for (int i = 1; i <= attempts; i++) {
            System.out.println("Attempt " + i + " of " + attempts);
            
            // Get username
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            
            // Get password
            String password = getMaskedPassword("Enter password: ");
            
            // Validate credentials
            if (validateCredentials(username, password)) {
                loginSuccessful = true;
                System.out.println("\n Login successful! Access granted.");
                break; // Exit loop on successful login
            } else {
                System.out.println("\n X Invalid credentials.");
                
                // Check if user has attempts remaining
                if (i < attempts) {
                    System.out.println("Please try again.\n");
                } else {
                    System.out.println("No more attempts remaining. System locked.");
                }
            }
        }
        
        scanner.close();
    }
    
//    get password process
    private static String getMaskedPassword(String prompt) {
        Console console = System.console();
        
        if (console != null) {
            // Use Console.readPassword() for proper password masking
            char[] passwordArray = console.readPassword(prompt);
            return new String(passwordArray);
        } else {
            
            System.out.print(prompt);
            Scanner scanner = new Scanner(System.in);
            String password = scanner.nextLine();
            
            
            System.out.print("\r" + prompt);
            for (int i = 0; i < password.length(); i++) {
                System.out.print("*");
            }
            System.out.println();
            
            return password;
        }
    }
    
//    validates user credent
    private static boolean validateCredentials(String username, String password) {
        return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
    }
}