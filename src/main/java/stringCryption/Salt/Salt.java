package main.java.stringCryption.Salt;

import java.security.SecureRandom;
import java.util.Base64;

public class Salt {
  private String salt;

  /**
   * Generate a random salt at specified length.
   */
  private void generateSalt(int lengthOfSalt) {
    SecureRandom randomSalt = new SecureRandom();
    byte[] saltBytes = new byte[lengthOfSalt];
    randomSalt.nextBytes(saltBytes);
    this.salt = Base64.getEncoder().encodeToString(saltBytes);
  }

  /**
   * Combine input with salt.
   */
  private String combineSaltAndInput(String salt, String input) {
    String saltedInput = salt + input;
    return saltedInput;
  }

  /**
   * Remove salt from input.
   */
  private String removeSaltFromInput(String salt, String saltedInput) {
    String originalInput = saltedInput.replace(salt, "");
    return originalInput;
  }

  /**
   * Add Salt.
   */
  public String addSalt(String input, int lengthOfSalt) {
    return input;
  }

  /**
   * Remove Salt.
   */
  public String removeSalt(String saltedInput) {
    return input;
  }
}
