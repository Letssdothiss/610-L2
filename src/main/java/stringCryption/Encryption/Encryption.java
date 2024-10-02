/**
 * @author Emil Jonasson Östvall
 * @version 1.0.0
 */

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
  public String levelOneDecryption(String encryptedInput) {
    int timesToShift = 9;
    String decryptedInput = salt.removeSalt(encryptedInput);
    decryptedInput = encryptionCipher.caesarCipherDecryption(decryptedInput, timesToShift);
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
  int stepsToRotate = 3;
  public String levelThreeEncryption(String input) {
    String encryptedInput = levelTwoEncryption(input);
    encryptedInput = stringManipulator.rotateCharacters(encryptedInput, stepsToRotate);
    return encryptedInput;
  }

  // Level 3 Decryption.
  public String levelThreeDecryption(String encryptedInput) {
    int stepsToRotate = 3;
    String decryptedInput = stringManipulator.undoRotateCharacters(encryptedInput, stepsToRotate);
    decryptedInput = levelTwoDecryption(decryptedInput);
    return decryptedInput;
  }

  // Level 4 Encryption.
  public String levelFourEncryption(String input) {
    int timesToShift = 6;
    String encryptedInput = levelThreeEncryption(input);
    encryptedInput = encryptionCipher.caesarCipherEncryption(encryptedInput, timesToShift);
    return encryptedInput;
  }

  // Level 4 Decryption.
  public String levelFourDecryption(String encryptedInput) {
    int timesToShift = 6;
    String decryptedInput = encryptionCipher.caesarCipherDecryption(encryptedInput, timesToShift);
    decryptedInput = levelThreeDecryption(decryptedInput);
    return decryptedInput;
  }
  
  // Level 5 Encryption.
  public String levelFiveEncryption(String input) {
    int stepsToRotate = 12;
    String encryptedInput = levelFourEncryption(input);
    encryptedInput = stringManipulator.swapCase(encryptedInput);
    encryptedInput = stringManipulator.rotateCharacters(encryptedInput, stepsToRotate);
    return encryptedInput;
  }

  // Level 5 Decryption.
  public String levelFiveDecryption(String encryptedInput) {
    int stepsToRotate = 12;
    String decryptedInput = stringManipulator.undoRotateCharacters(encryptedInput, stepsToRotate);
    decryptedInput = stringManipulator.swapCase(decryptedInput);
    decryptedInput = levelFourDecryption(decryptedInput);
    return decryptedInput;
  }
}
