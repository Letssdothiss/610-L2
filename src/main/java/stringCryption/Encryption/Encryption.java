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
    return input;
  }

  // Level 1 Decryption.
  public String levelOneDecryption(String encryptedInput) {
    return encryptedInput;
  }

  // Level 2 Encryption.
  public String levelTwoEncryption(String input) {
    return input;
  }

  // Level 2 Decryption.
  public String levelTwoDecryption(String encryptedInput) {
    return encryptedInput;
  }

  // Level 3 Encryption.
  public String levelThreeEncryption(String input) {
    return input;
  }

  // Level 3 Decryption.
  public String levelThreeDecryption(String encryptedInput) {
    return encryptedInput;
  }

  // Level 4 Encryption.
  public String levelFourEncryption(String input) {
    return input;
  }

  // Level 4 Decryption.
  public String levelFourDecryption(String encryptedInput) {
    return encryptedInput;
  }
  
  // Level 5 Encryption.
  public String levelFiveEncryption(String input) {
    return input;
  }

  // Level 5 Decryption.
  public String levelFiveDecryption(String encryptedInput) {
    return encryptedInput;
  }
}
