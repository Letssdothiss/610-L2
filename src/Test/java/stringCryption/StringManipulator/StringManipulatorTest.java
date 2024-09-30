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
    
  @Test
  public void testReverseString() {
    // Testing both ways to exhaust test, since the method is used for both encryption and decryption.
    assertEquals(".ecnetnes a esreveR", manipulator.reverseString("Reverse a sentence."));
    assertEquals("Reverse a sentence.", manipulator.reverseString(".ecnetnes a esreveR"));
    assertEquals("abcde", manipulator.reverseString("edcba"));
    assertEquals("edcba", manipulator.reverseString("abcde"));
    assertEquals("a", manipulator.reverseString("a"));
    assertEquals("A", manipulator.reverseString("A"));
    assertEquals("", manipulator.reverseString(""));
  }

  @Test
  public void testDuplicateString() {
    assertEquals("Duplicate a sentence.Duplicate a sentence.", manipulator.duplicateString("Duplicate a sentence."));
    assertEquals("DuplicateDuplicate", manipulator.duplicateString("Duplicate"));
    assertEquals("a", manipulator.duplicateString("a"));
    assertEquals("A", manipulator.duplicateString("A"));
    assertEquals("", manipulator.duplicateString(""));
  }

  // Testing both ways to exhaust test, since the method is used for both encryption and decryption.
  @Test
  public void testSwapCase() {
    assertEquals("iN A SENTENCE.", manipulator.swapCase("In a sentence."));
    assertEquals("In a sentence.", manipulator.swapCase("iN A SENTENCE."));
    assertEquals("sWAPcASE", manipulator.swapCase("SwapCase"));
    assertEquals("SwapCase", manipulator.swapCase("sWAPcASE"));
    assertEquals("A", manipulator.swapCase("a"));
    assertEquals("a", manipulator.swapCase("A"));
    assertEquals("!", manipulator.swapCase("!"));
    assertEquals("", manipulator.swapCase(""));
  }

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
