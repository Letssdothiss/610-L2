package Test.java.stringCryption.StringManipulator;

import main.java.stringCryption.StringManipulator.StringManipulator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringManipulatorTest {

  private StringManipulator manipulator;

  @BeforeEach
  public void setUp() {
    manipulator = new StringManipulator();
  }
    
  // Test both ways to exhaust test, since the method is used for both encryption and decryption.
  @Test
  public void testReverseString() {}

  @Test
  public void testDuplicateString() {}

  // Test both ways to exhaust test, since the method is used for both encryption and decryption.
  @Test
  public void testSwapCase() {}

  @Test
  public void testRotateCharacters() {}

  @Test
  public void testVowelsToSymbols() {}

  @Test
  public void testInsertPhrase() {}

  @Test
  public void testStringToCamelCase() {}

  @Test
  public void testUndoDuplicateString() {}

  @Test
  public void testUndoRotateCharacters() {}

  @Test
  public void testUndoVowelsToSymbols() {}

  @Test
  public void testUndoInsertPhrase() {}

  @Test
  public void testUndoStringToCamelCase() {}

}
