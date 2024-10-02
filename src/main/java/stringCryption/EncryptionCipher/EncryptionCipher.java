/**
 * @author Emil Jonasson Östvall
 * @version 1.0.0
 */

package main.java.stringCryption.EncryptionCipher;

public class EncryptionCipher {
  /**
   * Caesar Cipher Encryption
   * 
   * A simpler encryption technique that shifts the characters by a specified number of times.
   * 
   * If this cipher is used to create a custom encryption, 
   * the shift value should be remembered and kept secret.
   *
   * @param input The string to encrypt.
   * @param timesToShift The number of times to shift the characters.
   * @return The encrypted string.
   * @throws IllegalArgumentException If the input string is empty or contains only spaces.
   * @throws IllegalArgumentException If the shift value is less than 1.
   */
  public String caesarCipherEncryption(String input, int timesToShift) {
    if (input.length() == 0 || input == " ") {
      throw new IllegalArgumentException("Input string must contain atleast one character.");
    } else if (timesToShift < 1) {
      throw new IllegalArgumentException("Shift value must be atleast 1.");
    }
    StringBuilder encryptedInput = new StringBuilder();
    for (char characterInInput : input.toCharArray()) {
      encryptedInput.append(isCharacterLetter(characterInInput, timesToShift));
    }
    return encryptedInput.toString();
  }

  private char isCharacterLetter(char characterInInput, int timesToShift) {
    if (Character.isLetter(characterInInput)) {
      return shiftLetter(characterInInput, timesToShift);
    } else {
      return characterInInput;
    }
  }

  private char shiftLetter(char letterToShift, int timesToShift) {
    int alphabetLength = 26;
    // Determine the base character based on the case of the letter.
    char baseCharacter = Character.isLowerCase(letterToShift) ? 'a' : 'A';
    // Shifting the letter in the alphabet, using modulo to make sure 
    // the letter cant go beyond the alphabet.
    // (letterToShift - baseCharacter) gives the zero-based index of the letter in the alphabet.
    return (char) (((letterToShift - baseCharacter + timesToShift) % alphabetLength) + baseCharacter);
  }

  /**
   * Caesar Cipher Decryption
   * 
   * A simpler decryption technique that shifts the characters back by a specified number of times.
   * 
   * If this cipher is used to create a custom encryption,
   * the same shift value used for encryption must be used for decryption. 
   *
   * @param encryptedInput The string to decrypt.
   * @param timesToShift The number of times to shift the characters back.
   * @return The decrypted string.
   * @throws IllegalArgumentException If the input string is empty or contains only spaces.
   * @throws IllegalArgumentException If the shift value is less than 1.
   */
  public String caesarCipherDecryption(String encryptedInput, int timesToShift) {
    if (encryptedInput.length() == 0 || encryptedInput == " ") {
      throw new IllegalArgumentException("Input string must contain atleast one character.");
    } else if (timesToShift < 1) {
      throw new IllegalArgumentException("Shift value must be atleast 1.");
    }
    return caesarCipherEncryption(encryptedInput, 26 - timesToShift);
  }
}