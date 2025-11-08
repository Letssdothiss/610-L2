package main.java.stringCryption.Encryption;

import main.java.stringCryption.EncryptionCipher.EncryptionCipher;
import main.java.stringCryption.Salt.Salt;
import main.java.stringCryption.StringManipulator.StringManipulator;

/**
 * The Encryption class is responsible for encrypting and decrypting the input string.
 */
public class Encryption {
  private static final int LEVEL_ONE_SHIFT = 9;
  private static final int LEVEL_ONE_SALT_LENGTH = 32;
  private static final int LEVEL_THREE_ROTATION_STEPS = 3;
  private static final int LEVEL_FOUR_SHIFT = 6;
  private static final int LEVEL_FIVE_ROTATION_STEPS = 12;

  private EncryptionCipher encryptionCipher;
  private Salt salt;
  private StringManipulator stringManipulator;

  public Encryption() {
    this.encryptionCipher = new EncryptionCipher();
    this.salt = new Salt();
    this.stringManipulator = new StringManipulator();
  }

  // Level 1 Encryption.
  public String levelOneEncryption(String input) {
    String encryptedInput = stringManipulator.reverseString(input);
    encryptedInput = encryptionCipher.caesarCipherEncryption(encryptedInput, LEVEL_ONE_SHIFT);
    encryptedInput = salt.addSalt(encryptedInput, LEVEL_ONE_SALT_LENGTH);
    return encryptedInput;
  }

  // Level 1 Decryption.
  public String levelOneDecryption(String encryptedInput) {
    String decryptedInput = salt.removeSalt(encryptedInput);
    decryptedInput = encryptionCipher.caesarCipherDecryption(decryptedInput, LEVEL_ONE_SHIFT);
    decryptedInput = stringManipulator.reverseString(decryptedInput);
    return decryptedInput;
  }

  // Level 2 Encryption.
  public String levelTwoEncryption(String input) {
    String encryptedInput = levelOneEncryption(input);
    encryptedInput = stringManipulator.duplicateString(encryptedInput);
    return encryptedInput;
  }

  // Level 2 Decryption.
  public String levelTwoDecryption(String encryptedInput) {
    String decryptedInput = stringManipulator.undoDuplicateString(encryptedInput);
    decryptedInput = levelOneDecryption(decryptedInput);
    return decryptedInput;
  }

  // Level 3 Encryption.
  public String levelThreeEncryption(String input) {
    String encryptedInput = levelTwoEncryption(input);
    encryptedInput = stringManipulator.rotateCharacters(encryptedInput, LEVEL_THREE_ROTATION_STEPS);
    return encryptedInput;
  }

  // Level 3 Decryption.
  public String levelThreeDecryption(String encryptedInput) {
    String decryptedInput = stringManipulator.undoRotateCharacters(encryptedInput, LEVEL_THREE_ROTATION_STEPS);
    decryptedInput = levelTwoDecryption(decryptedInput);
    return decryptedInput;
  }

  // Level 4 Encryption.
  public String levelFourEncryption(String input) {
    String encryptedInput = levelThreeEncryption(input);
    encryptedInput = encryptionCipher.caesarCipherEncryption(encryptedInput, LEVEL_FOUR_SHIFT);
    return encryptedInput;
  }

  // Level 4 Decryption.
  public String levelFourDecryption(String encryptedInput) {
    String decryptedInput = encryptionCipher.caesarCipherDecryption(encryptedInput, LEVEL_FOUR_SHIFT);
    decryptedInput = levelThreeDecryption(decryptedInput);
    return decryptedInput;
  }
  
  // Level 5 Encryption.
  public String levelFiveEncryption(String input) {
    String encryptedInput = levelFourEncryption(input);
    encryptedInput = stringManipulator.swapCase(encryptedInput);
    encryptedInput = stringManipulator.rotateCharacters(encryptedInput, LEVEL_FIVE_ROTATION_STEPS);
    return encryptedInput;
  }

  // Level 5 Decryption.
  public String levelFiveDecryption(String encryptedInput) {
    String decryptedInput = stringManipulator.undoRotateCharacters(encryptedInput, LEVEL_FIVE_ROTATION_STEPS);
    decryptedInput = stringManipulator.swapCase(decryptedInput);
    decryptedInput = levelFourDecryption(decryptedInput);
    return decryptedInput;
  }
}
