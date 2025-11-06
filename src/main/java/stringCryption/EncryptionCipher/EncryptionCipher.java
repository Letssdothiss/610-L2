package main.java.stringCryption.EncryptionCipher;

/**
 * Provides encryption and decryption methods for the Caesar Cipher.
 */
public class EncryptionCipher {

  private static final int ALPHABET_LENGTH = 26;

  private void caesarCipherStringValidation(String input) {
    if (input == null || input.trim().isEmpty()) {
      throw new IllegalArgumentException("Input string must contain atleast one character.");
    }
  }

  private void caesarCipherShiftValidation(int timesToShift) {
    if (timesToShift < 1) {
      throw new IllegalArgumentException("Shift value must be atleast 1.");
    }
  }
  
  private char transformCharacter(char characterInInput, int timesToShift) {
    if (Character.isLetter(characterInInput)) {
      return shiftLetter(characterInInput, timesToShift);
    }
    return characterInInput;
  }

  private char determineBaseCharacterCase(char letterToShift) {
    return Character.isLowerCase(letterToShift) ? 'a' : 'A';
  }

  private char shiftLetter(char letterToShift, int timesToShift) {
    char baseCharacter = determineBaseCharacterCase(letterToShift);
    // Using modulo to make sure the letter cant go beyond the alphabet.
    // (letterToShift - baseCharacter) gives the zero-based index of the letter in the alphabet.
    return (char) (((letterToShift - baseCharacter + timesToShift) % ALPHABET_LENGTH) + baseCharacter);
  }

  /**
   * If this cipher is used to create a custom encryption, 
   * the shift value should be remembered and kept secret.
   */
  public String caesarCipherEncryption(String input, int timesToShift) {
    caesarCipherStringValidation(input);
    caesarCipherShiftValidation(timesToShift);
    return transformEachCharacter(input, timesToShift);
  }

  private String transformEachCharacter(String input, int timesToShift) {
    StringBuilder encryptedInput = new StringBuilder();
    for (char characterInInput : input.toCharArray()) {
      encryptedInput.append(transformCharacter(characterInInput, timesToShift));
    }
    return encryptedInput.toString();
  }

  /**
   * If this cipher is used to create a custom encryption,
   * the same shift value used for encryption must be used for decryption. 
   */
  public String caesarCipherDecryption(String encryptedInput, int timesToShift) {
    caesarCipherStringValidation(encryptedInput);
    caesarCipherShiftValidation(timesToShift);

    return caesarCipherEncryption(encryptedInput, 26 - timesToShift);
  }
}