/**
 Class: CPSC 353-01
 Name: Brewer Slack
 Name1: Quinlan Bingham
 Name2: Jonathan Reid
 GU Username: bslack
 Assignment: Project 1
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the ADFGVX Cipher.");
        System.out.print("Enter a key: ");
        String key = scan.nextLine();
        System.out.println("");

        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.print("Would you like to Encrypt or Decrypt a message? (1-2): ");
        int choice = scan.nextInt();
        if (choice == 1){
            runEncryption(key);
        }
        else{
            runDecryption(key);
        }



    }
    private static void runEncryption(String key){
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.print("Enter a secret code: ");
        String plainText = scan.nextLine();
        Cipher c = new Cipher(plainText, "", key);
        String cipherText = c.encrypt(plainText,key);
        System.out.println(cipherText);



    }

    private static void runDecryption(String key){
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.print("Enter a cipher text: ");
        String cipherText = scan.nextLine();

        Cipher c = new Cipher("", cipherText, key);
        String plainText = c.decrypt(cipherText,key);
        System.out.println(plainText);

    }
}
