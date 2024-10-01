package main.java.stringCryption.Encryption;

import main.java.stringCryption.EncryptionCipher.EncryptionCipher;
import main.java.stringCryption.Salt.Salt;
import main.java.stringCryption.StringManipulator.StringManipulator;

public class Encryption {
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
    int timesToShift = 9;
    int saltLength = 32;
    String encryptedInput = stringManipulator.reverseString(input);
    encryptedInput = encryptionCipher.caesarCipherEncryption(encryptedInput, timesToShift);
    encryptedInput = salt.addSalt(encryptedInput, saltLength);
    return encryptedInput;
  }

  // Level 1 Decryption.
  int timesToShift = 9;
  int saltLength = 32;
  public String levelOneDecryption(String encryptedInput) {
    return encryptedInput;
  }

  // Level 2 Encryption.
  public String levelTwoEncryption(String input) {
    String encryptedInput = levelOneEncryption(input);
    encryptedInput = stringManipulator.duplicateString(encryptedInput);
    return encryptedInput;
  }

  // Level 2 Decryption.
  public String levelTwoDecryption(String encryptedInput) {
    return encryptedInput;
  }

  // Level 3 Encryption.
  public String levelThreeEncryption(String input) {
    String encryptedInput = levelTwoEncryption(input);
    encryptedInput = stringManipulator.undoVowelsToSymbols(encryptedInput);
    return encryptedInput;
  }

  // Level 3 Decryption.
  public String levelThreeDecryption(String encryptedInput) {
    return encryptedInput;
  }

  // Level 4 Encryption.
  public String levelFourEncryption(String input) {
    int timesToShift = 6;
    String encryptedInput = levelThreeEncryption(input);
    encryptedInput = encryptionCipher.caesarCipherEncryption(encryptedInput, timesToShift);
    return input;
  }

  // Level 4 Decryption.
  public String levelFourDecryption(String encryptedInput) {
    return encryptedInput;
  }
  
  // Level 5 Encryption.
  public String levelFiveEncryption(String input) {
    int saltLength = 16;
    String encryptedInput = levelFourEncryption(input);
    encryptedInput = salt.addSalt(encryptedInput, saltLength);
    encryptedInput = stringManipulator.swapCase(encryptedInput);
    return encryptedInput;
  }

  // Level 5 Decryption.
  public String levelFiveDecryption(String encryptedInput) {
    return encryptedInput;
  }
}
