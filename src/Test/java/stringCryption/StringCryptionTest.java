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
}
