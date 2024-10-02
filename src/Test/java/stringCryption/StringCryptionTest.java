package Test.java.stringCryption;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.stringCryption.StringCryption;

public class StringCryptionTest {
  private StringCryption stringCryption;
  private String testInput = "This is a test string. It should be encrypted and decrypted. Some symbols and white spaces: !@#$%^&*()_+{}|:\"<>?[];',./\\      ";

  @BeforeEach
  public void setUp() {
    stringCryption = new StringCryption();
  }

  @Test
  public void testEncryptDecryptLevel1() {
    String encrypted = stringCryption.encryptAtChosenLevel(testInput, 1);
    String decrypted = stringCryption.decryptAtChosenLevel(encrypted, 1);
    assertEquals(testInput, decrypted);
  }

  @Test
  public void testEncryptDecryptLevel2() {
    String encrypted = stringCryption.encryptAtChosenLevel(testInput, 2);
    String decrypted = stringCryption.decryptAtChosenLevel(encrypted, 2);
    assertEquals(testInput, decrypted);
  }

  @Test
  public void testEncryptDecryptLevel3() {
    String encrypted = stringCryption.encryptAtChosenLevel(testInput, 3);
    String decrypted = stringCryption.decryptAtChosenLevel(encrypted, 3);
    assertEquals(testInput, decrypted);
  }

  @Test
  public void testEncryptDecryptLevel4() {
    String encrypted = stringCryption.encryptAtChosenLevel(testInput, 4);
    String decrypted = stringCryption.decryptAtChosenLevel(encrypted, 4);
    assertEquals(testInput, decrypted);
  }

  @Test
  public void testEncryptDecryptLevel5() {
    String encrypted = stringCryption.encryptAtChosenLevel(testInput, 5);
    String decrypted = stringCryption.decryptAtChosenLevel(encrypted, 5);
    assertEquals(testInput, decrypted);
  }

  @Test
  public void testInvalidEncryptionLevelTooHigh() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      stringCryption.encryptAtChosenLevel(testInput, 6);
    });
    assertTrue(exception.getMessage().contains("Invalid encryption level chosen."));
  }

  @Test
  public void testInvalidEncryptionLevelToLow() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      stringCryption.encryptAtChosenLevel(testInput, 0);
    });
    assertTrue(exception.getMessage().contains("Invalid encryption level chosen."));
  }

  @Test
  public void testInvalidDecryptionLevelToHigh() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      stringCryption.decryptAtChosenLevel(testInput, 6);
    });
    assertTrue(exception.getMessage().contains("Invalid decryption level chosen."));
  }

  @Test
  public void testInvalidDecryptionLevelToLow() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      stringCryption.decryptAtChosenLevel(testInput, 0);
    });
    assertTrue(exception.getMessage().contains("Invalid decryption level chosen."));
  }

  @Test
  public void testInvalidEncryptionInput() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      stringCryption.encryptAtChosenLevel("", 1);
    });
    assertTrue(exception.getMessage().contains("Input string must contain atleast one character."));
  }

  @Test
  public void testInvalidDecryptionInput() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      stringCryption.decryptAtChosenLevel("", 1);
    });
    assertTrue(exception.getMessage().contains("Input string must contain atleast one character."));
  }
}
