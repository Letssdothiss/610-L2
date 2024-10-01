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
  public void testCaesarCipherDecryption() {}
}
