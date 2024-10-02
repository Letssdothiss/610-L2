package main.java.stringCryption;

import main.java.stringCryption.Encryption.Encryption;

public class StringCryption {
  private Encryption encryption;

  public StringCryption() {
    this.encryption = new Encryption();
  }

  /**
   * Encrypts the input at the chosen level.
   * Higher level number means more complex encryption algorithm.
   * 
   * Current implementation supperts a level argument between 1-5.
   * 1 being the simplest and 5 being the most complex.
   * 
   * Important: When decrypting the input, the same level argument must be used to decrypt the input.
   * 
   * @param input - the string to be encrypted.
   * @param level - the level of encryption complexity.
   * @return - the encrypted string.
   */
  public String encryptAtChosenLevel(String input, int level) {
    String encryptedInput= "";
    try {
      switch (level) {
        case 1:
          encryptedInput = encryption.levelOneEncryption(input);
          break;
        case 2:
          encryptedInput = encryption.levelTwoEncryption(input);
          break;
        case 3:
          encryptedInput = encryption.levelThreeEncryption(input);
          break;
        case 4:
          encryptedInput = encryption.levelFourEncryption(input);
          break;
        case 5:
          encryptedInput = encryption.levelFiveEncryption(input);
          break;
        default:
          throw new IllegalArgumentException("Invalid level chosen. Please choose a level between 1-5.");
      }
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
  
}
