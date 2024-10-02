/**
 * @author Emil Jonasson Östvall
 * @version 1.0.0
 */

package main.java.stringCryption.Salt;

import java.security.SecureRandom;
import java.util.Base64;

public class Salt {
  private String salt;

  /**
   * Generate a random salt at specified length.
   * Using secure random and base64 encoding.
   */
  private void generateSalt(int lengthOfSalt) {
    if (lengthOfSalt < 1) {
      throw new IllegalArgumentException("Salt length must be greater than 0.");
    }
    SecureRandom randomSalt = new SecureRandom();
    byte[] saltBytes = new byte[lengthOfSalt];
    randomSalt.nextBytes(saltBytes);
    this.salt = Base64.getEncoder().encodeToString(saltBytes);
  }

  /**
   * Get the salt.
   *
   * Not used in current implementation, could be used to store salt 
   * for later decoding.
   */
  public String getSalt() {
    return this.salt;
  }

  private String combineSaltAndInput(String salt, String input) {
    return salt + input;
  }

  private String removeSaltFromInput(String salt, String saltedInput) {
    if (saltedInput.length() == 0 || !saltedInput.startsWith(salt)) {
       throw new IllegalArgumentException("Invalid ");
    }
    if (saltedInput.startsWith(salt)) {
      return saltedInput.substring(salt.length());
    } else {
      return "No salt found in the given input.";
    }
  }

  public String addSalt(String input, int lengthOfSalt) {
    if (input.length() < 1 || input == " ") {
      throw new IllegalArgumentException("Input string must contain atleast one character.");
    } else if (lengthOfSalt < 1) {
      throw new IllegalArgumentException("Salt length must be atleast 1.");
    }
    generateSalt(lengthOfSalt);
    return combineSaltAndInput(salt, input);
  }

  public String removeSalt(String saltedInput) {
    if (saltedInput.length() < 1 || saltedInput == " ") {
      throw new IllegalArgumentException("There is no salt to remove from this input.");
    }
    return removeSaltFromInput(salt, saltedInput);
  }
}
