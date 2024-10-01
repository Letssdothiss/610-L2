package Test.java.stringCryption.EncryptionCipher;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.stringCryption.EncryptionCipher.EncryptionCipher;

public class EncryptionCipherTest {
  EncryptionCipher encryption;
  private String testString = "This is a test.";
  private int caesarCipherShift = 3;

  @BeforeEach void setUp() {
    encryption = new EncryptionCipher();
    encryption = new EncryptionCipher();
  }

  @Test
  public void testCaesarCipherEncryption() {
    String expectedOutput = "Wklv lv d whvw.";
    String actualOutput = encryption.caesarCipherEncryption(testString, caesarCipherShift);
    assertEquals(expectedOutput, actualOutput, "The encrypted output should match the expected output.");
  }

  @Test
  public void testCaesarCipherDecryption() {
    String encryptedString = encryption.caesarCipherEncryption(testString, caesarCipherShift);
    String expectedOutput = testString;
    String actualOutput = encryption.caesarCipherDecryption(encryptedString, caesarCipherShift);
    assertEquals(expectedOutput, actualOutput, "The decrypted output should match the expected input.");
  }

  @Test
  public void testCaesarCipherEncryptionWithEmptyString() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      encryption.caesarCipherEncryption("", 3);
  });
  assertEquals("Input string must contain atleast one character.", exception.getMessage());
  }

  @Test
  public void testCaesarCipherEncryptionWithSpaceString() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      encryption.caesarCipherEncryption(" ", 3);
  });
  assertEquals("Input string must contain atleast one character.", exception.getMessage());
  }

  @Test
    public void testCaesarCipherEncryptionWithInvalidShift() {
      Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        encryption.caesarCipherEncryption("Hello World", 0);
    });
    assertEquals("Shift value must be atleast 1.", exception.getMessage());
    }

  @Test
  public void testCaesarCipherEncryptionWithShiftOfAlphabetLength() {
    String expectedOutput = "This is a test.";
    int shiftAlphabethLength = 26;
    String actualOutput = encryption.caesarCipherEncryption(testString, shiftAlphabethLength);
    assertEquals(expectedOutput, actualOutput, "The encrypted output should match the expected output.");
  }

  @Test
  public void testCaesarCipherEncryptionWithShiftGreaterThanAlphabetLength() {
    String expectedOutput = "Wklv lv d whvw.";
    int shiftGreaterThanAlphabetLength = 29;
    String actualOutput = encryption.caesarCipherEncryption(testString, shiftGreaterThanAlphabetLength);
    assertEquals(expectedOutput, actualOutput, "The encrypted output should match the expected output.");
  }

  @Test
  public void testCaesarCipherEncryptionWithAllLetters() {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String expectedOutput = "defghijklmnopqrstuvwxyzabc";
    String actualOutput = encryption.caesarCipherEncryption(alphabet, caesarCipherShift);
    assertEquals(expectedOutput, actualOutput, "The encrypted output should match the expected output.");
  }

  @Test
  public void testCaesarCipherEncryptionWithNonLettercharacters() {
    String nonLetterCharacters = "1234567890!@#$%^&*()_+";
    String expectedOutput = "1234567890!@#$%^&*()_+";
    String actualOutput = encryption.caesarCipherEncryption(nonLetterCharacters, caesarCipherShift);
    assertEquals(expectedOutput, actualOutput, "The encrypted output should match the expected output.");
  }
}