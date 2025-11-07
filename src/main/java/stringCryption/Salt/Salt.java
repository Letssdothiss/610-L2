package main.java.stringCryption.Salt;

import java.security.SecureRandom;
import java.util.Base64;

/**
 * This class is used to add and remove salt from a string.
 */
public class Salt {
  private String salt;

  private void validateInputString(String input, String errorMessage) {
    if (input == null || input.trim().isEmpty()) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  private void validateSaltLength(int lengthOfSalt, String errorMessage) {
    if (lengthOfSalt < 1) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  private void validateSaltedInput(String salt, String saltedInput) {
    if (saltedInput == null || saltedInput.length() == 0 || !saltedInput.startsWith(salt)) {
      throw new IllegalArgumentException("Invalid salted input.");
    }
  }

  private void generateSalt(int lengthOfSalt) {
    validateSaltLength(lengthOfSalt, "Salt length must be greater than 0.");
    byte[] saltBytes = generateRandomBytes(lengthOfSalt);
    this.salt = encodeToBase64(saltBytes);
  }

  // Generate random bytes using SecureRandom.
  // Seems appropriate in this case to break the rule of small functions, keeping this logic at the same place.
  private byte[] generateRandomBytes(int length) {
    SecureRandom randomSalt = new SecureRandom();
    byte[] saltBytes = new byte[length];
    randomSalt.nextBytes(saltBytes);
    return saltBytes;
  }

  private String encodeToBase64(byte[] bytes) {
    return Base64.getEncoder().encodeToString(bytes);
  }

  private String combineSaltAndInput(String salt, String input) {
    return salt + input;
  }

  private String removeSaltFromInput(String salt, String saltedInput) {
    validateSaltedInput(salt, saltedInput);
    return saltedInput.substring(salt.length());
  }

  public String addSalt(String input, int lengthOfSalt) {
    validateInputString(input, "Input string must contain atleast one character.");
    validateSaltLength(lengthOfSalt, "Salt length must be atleast 1.");
    generateSalt(lengthOfSalt);
    return combineSaltAndInput(salt, input);
  }

  public String removeSalt(String saltedInput) {
    validateInputString(saltedInput, "There is no salt to remove from this input.");
    return removeSaltFromInput(salt, saltedInput);
  }
}
