package Test.java.stringCryption.Encryption;

import main.java.stringCryption.Encryption.Encryption;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EncryptionTest {
  
  private Encryption encryption;
  private String testString = "This is a test.";
  private int caesarCipherShift = 3;

  @BeforeEach void setUp() {
    encryption = new Encryption();
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
}
