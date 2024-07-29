package io.blog.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA256Generator {

    public static String generateSHA256Hash(String input) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Convert the input string to bytes and update the MessageDigest
            byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));

            // Convert the byte array into a signum representation
            BigInteger number = new BigInteger(1, hash);

            // Convert the message digest into a hex value
            StringBuilder hexString = new StringBuilder(number.toString(16));

            // Pad with leading zeros to get a 64-character hash
            while (hexString.length() < 64) {
                hexString.insert(0, '0');
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        boolean continueLoop = true;
        do {
            System.out.print("Enter a string to generate its SHA-256 hash: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String hash = generateSHA256Hash(input);
            System.out.println("The SHA-256 hash is: ");
            System.out.println(hash);
            System.out.print("Enter to continue, 'q' to quit: ");
            String next = scanner.nextLine();
            if (next.equals("q")) {
                continueLoop = false;
            }
        } while (continueLoop);
    }
}
