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
  public void testRotateCharacters() {
    assertEquals("eRotat", manipulator.rotateCharacters("Rotate", 1));
    assertEquals("ateRot", manipulator.rotateCharacters("Rotate", 3));
    assertEquals("tateRo", manipulator.rotateCharacters("Rotate", 10));

    assertEquals("Rotate", manipulator.rotateCharacters("Rotate", 6));
    assertEquals("Rotate", manipulator.rotateCharacters("Rotate", 0));
    assertEquals("Rotate", manipulator.rotateCharacters("Rotate", 12));
  }

  @Test
  public void testVowelsToSymbols() {
    assertEquals("?", manipulator.vowelsToSymbols("A"));
    assertEquals("=", manipulator.vowelsToSymbols("a"));
    assertEquals(")", manipulator.vowelsToSymbols("E"));
    assertEquals("(", manipulator.vowelsToSymbols("e"));
    assertEquals("!", manipulator.vowelsToSymbols("I"));
    assertEquals("@", manipulator.vowelsToSymbols("i"));
    assertEquals("&", manipulator.vowelsToSymbols("O"));
    assertEquals("/", manipulator.vowelsToSymbols("o"));
    assertEquals("*", manipulator.vowelsToSymbols("U"));
    assertEquals("%", manipulator.vowelsToSymbols("u"));
    assertEquals("M=n@p%l=t( = s(nt(nc(.", manipulator.vowelsToSymbols("Manipulate a sentence."));
    assertEquals("V/c=b%l=ry", manipulator.vowelsToSymbols("Vocabulary"));

    // Non-vowel characters should not be changed.
    assertEquals("Rhythm", manipulator.vowelsToSymbols("Rhythm"));
    assertEquals("r", manipulator.vowelsToSymbols("r"));
    assertEquals("R", manipulator.vowelsToSymbols("R"));
    assertEquals("!", manipulator.vowelsToSymbols("!"));
  }

  @Test
  public void testInsertPhrase() {
    String phrase = "TESTPHRASE";
    assertEquals("In a se" + phrase + "ntence.", manipulator.insertPhrase("In a sentence."));
    assertEquals("Wo" + phrase + "rd", manipulator.insertPhrase("Word"));

    assertEquals("a", manipulator.insertPhrase("a"));
    assertEquals("!", manipulator.insertPhrase("!"));
    assertEquals("", manipulator.insertPhrase(""));
  }

  @Test
  public void testStringToCamelCase() {
    assertEquals("camelCaseThisString.", manipulator.stringToCamelCase("Camel case this string."));
    assertEquals("camelCase", manipulator.stringToCamelCase("CAMELcase"));

    assertEquals("a", manipulator.stringToCamelCase("a"));
    assertEquals("!", manipulator.stringToCamelCase("!"));
    assertEquals("", manipulator.stringToCamelCase(""));
  }

  @Test
  public void testUndoDuplicateString() {
    assertEquals("Duplicated string.", manipulator.undoDuplicateString("Duplicated string.Duplicated String."));
    assertEquals("Duplicated", manipulator.undoDuplicateString("DuplicatedDuplicated"));

    assertEquals("A", manipulator.undoDuplicateString("AA"));
    assertEquals("a", manipulator.undoDuplicateString("aa"));
    assertEquals("!", manipulator.undoDuplicateString("!!"));

    assertEquals("a", manipulator.undoDuplicateString("a"));
    assertEquals("", manipulator.undoDuplicateString(""));
  }

  @Test
  public void testUndoRotateCharacters() {
    assertEquals("Rotate", manipulator.undoRotateCharacters("eRotat", 1));
    assertEquals("Rotate", manipulator.undoRotateCharacters("ateRot", 3));
    assertEquals("Rotate", manipulator.undoRotateCharacters("tateRo", 10));

    assertEquals("eRotat", manipulator.undoRotateCharacters("eRotat", 6));
    assertEquals("eRotat", manipulator.undoRotateCharacters("eRotat", 0));
    assertEquals("eRotat", manipulator.undoRotateCharacters("eRotat", 12));
  }

  @Test
  public void testUndoVowelsToSymbols() {}

  @Test
  public void testUndoInsertPhrase() {}

  @Test
  public void testUndoStringToCamelCase() {}

}
