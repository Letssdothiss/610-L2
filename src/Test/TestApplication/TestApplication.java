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
      scanner.nextLine();

      try {
        String encryptedString = stringCryption.encryptAtChosenLevel(input, level);
        System.out.println("Original String: " + input);
        System.out.println("Chosen Level of Encryption: " + level);
        System.out.println("Encrypted String: " + encryptedString);

        System.out.println("Press any key to decrypt the string...");
        scanner.nextLine();

        String decryptedString = stringCryption.decryptAtChosenLevel(encryptedString, level);
        System.out.println("Decrypted String: " + decryptedString);
      } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
      }

      System.out.println("Do you want to try again? (y/n):");
      String response = scanner.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        continueRunning = false;
      }
    }

    scanner.close();
  }
}
