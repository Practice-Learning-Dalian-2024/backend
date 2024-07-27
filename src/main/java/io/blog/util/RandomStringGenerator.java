package io.blog.util;

import java.util.Random;
import java.util.Scanner;

public class RandomStringGenerator {

    // Define the character set to use for generating the random string
    private static final String CHARACTERS =
            "QWERTYUIOPASDFGHJKLZXCVBNM" +
                    "qwertyuiopasdfghjklzxcvbnm" +
                    "0123456789`~!@#$%^&*()_-+=<>?:\"{}|,./;'[]\\";

    // Method to generate a random string of given length
    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        // Append random characters from the character set to the StringBuilder
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Generate a random string of length 10
        boolean continueLoop = true;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the length of the random string: ");
            int length = scanner.nextInt();
            scanner.nextLine();
            String randomString = generateRandomString(length);
            System.out.println("Random String: " + randomString);
            System.out.print("Enter to continue, 'q' to quit: ");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                continueLoop = false;
            }
        } while (continueLoop);
    }
}
