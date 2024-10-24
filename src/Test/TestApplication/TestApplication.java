/**
 * The String Cryption testing application.
 * 
 * @author Emil Jonasson Östvall
 * @version 1.0.0
 */

package Test.TestApplication;

import main.java.stringCryption.StringCryption;
import java.util.Scanner;

public class TestApplication {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StringCryption stringCryption = new StringCryption();
    boolean continueRunning = true;

    while (continueRunning) {
      System.out.println("Enter a string to encrypt:");
      String input = scanner.nextLine();

      System.out.println("Enter the level of encryption complexity (1-5):");
      int level = scanner.nextInt();
      // Consume the newline character
      scanner.nextLine();

      try {
        // Encrypt the string at the chosen level.
        String encryptedString = stringCryption.encryptAtChosenLevel(input, level);

        // Print the results. Original string, chosen level of encryption, and the encrypted string.
        System.out.println("Original String: " + input);
        System.out.println("Chosen Level of Encryption: " + level);
        System.out.println("Encrypted String: " + encryptedString);

        // Prompt the user to decrypt the string.
        System.out.println("Press any key to decrypt the string...");
        scanner.nextLine();

        // Decrypt the string at the chosen level and print the decrypted string.
        String decryptedString = stringCryption.decryptAtChosenLevel(encryptedString, level);
        System.out.println("Decrypted String: " + decryptedString);

        // Catch any exceptions that might occur and print the error message.
      } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
      }

      // Ask the user if they want to try again, if not, exit the application.
      System.out.println("Do you want to try again? (y/n):");
      String response = scanner.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        continueRunning = false;
      }
    }

    // Close the scanner when the application is done.
    scanner.close();
  }
}
