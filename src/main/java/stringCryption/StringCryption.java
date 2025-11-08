package main.java.stringCryption;

import main.java.stringCryption.Encryption.Encryption;

/**
 * The StringCryption class is the main class that the user will interact with.
 */
public class StringCryption {
  private static final int MIN_LEVEL = 1;
  private static final int MAX_LEVEL = 5;
  
  private Encryption encryption;

  public StringCryption() {
    this.encryption = new Encryption();
  }

  private void validateLevel(int level, String errorMessage) {
    if (level < MIN_LEVEL || level > MAX_LEVEL) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  private void validateInput(String input) {
    if (input == null || input.trim().isEmpty()) {
      throw new IllegalArgumentException("Input string must contain atleast one character.");
    }
  }

  private String encryptAtLevel(String input, int level) {
    switch (level) {
      case 1:
        return encryption.levelOneEncryption(input);
      case 2:
        return encryption.levelTwoEncryption(input);
      case 3:
        return encryption.levelThreeEncryption(input);
      case 4:
        return encryption.levelFourEncryption(input);
      case 5:
        return encryption.levelFiveEncryption(input);
      default:
        throw new IllegalArgumentException("Invalid level chosen. Please choose a level between 1-5.");
    }
  }

  private String decryptAtLevel(String encryptedInput, int level) {
    switch (level) {
      case 1:
        return encryption.levelOneDecryption(encryptedInput);
      case 2:
        return encryption.levelTwoDecryption(encryptedInput);
      case 3:
        return encryption.levelThreeDecryption(encryptedInput);
      case 4:
        return encryption.levelFourDecryption(encryptedInput);
      case 5:
        return encryption.levelFiveDecryption(encryptedInput);
      default:
        throw new IllegalArgumentException("Invalid level chosen. Please choose a level between 1-5.");
    }
  }

  /**
   * Encrypts the input at the chosen level.
   * Higher level number means more complex encryption algorithm.
   * 
   * Current implementation supports a level argument between 1-5.
   * 1 being the simplest and 5 being the most complex.
   * 
   * Important: When decrypting the input, the same level argument must be used to decrypt the input.
   */
  public String encryptAtChosenLevel(String input, int levelOfEncryption) {
    validateLevel(levelOfEncryption, "Invalid encryption level chosen. Please choose a level between 1-5.");
    validateInput(input);
    
    String encryptedInput = "";
    try {
      encryptedInput = encryptAtLevel(input, levelOfEncryption);
    } catch (IllegalArgumentException e) {
      System.out.println("Error when trying to encrypt the input." + e.getMessage());
    } catch (Exception e) {
      System.out.println("Error when trying to encrypt the input." + e.getMessage());
    }
    return encryptedInput;
  }

  /**
   * Decrypts the input at the chosen level.
   */
  public String decryptAtChosenLevel(String encryptedInput, int levelOfDecryption) {
    validateLevel(levelOfDecryption, "Invalid decryption level chosen. Please choose a level between 1-5.");
    validateInput(encryptedInput);
    
    String decryptedInput = "";
    try {
      decryptedInput = decryptAtLevel(encryptedInput, levelOfDecryption);
    } catch (IllegalArgumentException e) {
      System.out.println("Error when trying to decrypt the input." + e.getMessage());
    } catch (Exception e) {
      System.out.println("Error when trying to decrypt the input." + e.getMessage());
    }
    return decryptedInput;
  }
}
