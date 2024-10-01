package Test.java.stringCryption.Encryption;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.stringCryption.Encryption.Encryption;

public class EncryptionTest {
  private Encryption encryption;

  @BeforeEach
  public void setUp() {
    encryption = new Encryption();
  }

  @Test
  public void testLevelOneEncryptionDecryption() {
    String input = "This is a test.";
    String encrypted = encryption.levelOneEncryption(input);
    String decrypted = encryption.levelOneDecryption(encrypted);
    assertEquals(input, decrypted);
  }

  @Test
  public void testLevelTwoEncryptionDecryption() {
    String input = "This is a test.";
    String encrypted = encryption.levelTwoEncryption(input);
    String decrypted = encryption.levelTwoDecryption(encrypted);
    assertEquals(input, decrypted);
  }

  @Test
  public void testLevelThreeEncryptionDecryption() {
    String input = "This is a test.";
    String encrypted = encryption.levelThreeEncryption(input);
    String decrypted = encryption.levelThreeDecryption(encrypted);
    assertEquals(input, decrypted);
  }

  @Test
  public void testLevelFourEncryptionDecryption() {
    String input = "This is a test.";
    String encrypted = encryption.levelFourEncryption(input);
    String decrypted = encryption.levelFourDecryption(encrypted);
    assertEquals(input, decrypted);
  }

  @Test
  public void testLevelFiveEncryptionDecryption() {
    String input = "This is a test.";
    String encrypted = encryption.levelFiveEncryption(input);
    String decrypted = encryption.levelFiveDecryption(encrypted);
    assertEquals(input, decrypted);
  }

  @Test
  public void testLongStringEncryptionDecryption() {
    String input = "a".repeat(100000);
    String encrypted = encryption.levelOneEncryption(input);
    String decrypted = encryption.levelOneDecryption(encrypted);
    assertEquals(input, decrypted);
  }
}
