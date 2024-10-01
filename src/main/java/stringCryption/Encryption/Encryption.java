package main.java.stringCryption.Encryption;

public class Encryption {
  // Substitution List for Substitution Cipher
  private final String SUBSTITUTION_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=[]{}|;':,.<>?";

  // Keyword for Vigenere Cipher
  private final String VIGENERE_KEYWORD = "ehCHrDGqvhtrBmF";

  /**
   * Caesar Cipher Encryption
   */
  public String caesarCipherEncryption(String input, int timesToShift) {}

  public String caesarCipherDecryption(String input, int timesToShift) {}
  /**
   * Substitution Cipher Encryption
   */
  public String substitutionCipherEncryption(String input) {}

  public String substitutionCipherDecryption(String input) {}

  /**
   * Vigenere Cipher Encryption
   */
  public String vigenereCipherEncryption(String input, String keyword) {}

  public String vigenereCipherDecryption(String input, String keyword) {}
}
