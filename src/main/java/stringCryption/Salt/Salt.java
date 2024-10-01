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
   * Get the salt.
   */
  public String getSalt() {
    return this.salt;
  }

  /**
   * Combine input with salt.
   */
  private String combineSaltAndInput(String salt, String input) {
    return salt + input;
  }

  /**
   * Remove salt from input.
   */
  private String removeSaltFromInput(String salt, String saltedInput) {
    if (saltedInput.startsWith(salt)) {
      return saltedInput.substring(salt.length());
    } else {
      return "No salt found in the given input.";
    }
  }

  /**
   * Add Salt.
   */
  public String addSalt(String input, int lengthOfSalt) {
    generateSalt(lengthOfSalt);
    return combineSaltAndInput(salt, input);
  }

  /**
   * Remove Salt.
   */
  public String removeSalt(String saltedInput) {
    return removeSaltFromInput(salt, saltedInput);
  }
}
