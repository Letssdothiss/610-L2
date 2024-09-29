package main.java.stringCryption.StringManipulator;

public class StringManipulator {
  /**
   * This is the phrase that will be used in the insertPhrase method.
   *
   * @type {String}
   */
  private String phrase = "This is a phrase, it will change";

  /**
   * This method will reverse the input string.
   *
   * @param input - The string to be reversed.
   * @return - The reversed string.
   */
  public String reverseString(String input) {}

  /**
   * This method will duplicate the input string.
   *
   * @param input - The string to be duplicated.
   * @return - The duplicated string.
   */
  public String duplicateString(String input) {
    String manipulatedString = input + input;
    return manipulatedString;
  }

  /**
   * Changes upper case to lower case and vice versa.
   * 
   * To undo the swap, call this method again.
   *
   * @param input - The string to be modified.
   * @return - The manipulated string.
   */
  public String swapCase(String input) {}

  /**
   * This method will rotate the characters in a string by a specified number of steps.
   * 
   * @param input - The string to be modified.
   * @param stepsToRotate - The number of steps to rotate the characters.
   * @return - The manipulated string.
   */
  public String rotateCharacters(String input, int stepsToRotate) {}

  /**
   * This method will replace all vowels in a string with a specified symbol.
   *
   * @param input - The string to be modified.
   * @return - The manipulated string.
   */
  public String vowelsToSymbols(String input) {}

  /**
   * This method will insert a pre-defined String into the middle of the input string.
   *
   * @param input - The string to be modified.
   * @return - The manipulated string.
   */
  public String insertPhrase(String input) {}

  public String StringToCamelCase(String input) {}

}
