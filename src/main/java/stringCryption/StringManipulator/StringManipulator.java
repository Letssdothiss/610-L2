package main.java.stringCryption.StringManipulator;

/**
 * This class is used to manipulate strings.
 */
public class StringManipulator {

  // Phrase used in insertPhrase method.
  private static final String phrase = "!#THTRJYDHGS#¤%&UHDAWE35ythrsr563423435ythgfds";

  // Note: To undo the reversed string, call this method again with the manipulated string as the argument.
  public String reverseString(String input) {
    validateInput(input, 2, "Cannot reverse a string with less than 2 characters.");
    return new StringBuilder(input).reverse().toString();
  }

  public String duplicateString(String input) {
    validateInput(input, 1, "Cannot duplicate a string with less than 1 character/s.");
    return input + input;
  }


  // Note: To undo the case swap, call this method again on with the manipulated string as the argument.
  public String swapCase(String input) {
    validateInput(input, 1, "Cannot swap case of a string with less than 1 character/s.");
    char[] inputStringToCharacters = input.toCharArray();
    for (int i = 0; i < inputStringToCharacters.length; i++) {
      inputStringToCharacters[i] = swapCharacterCase(inputStringToCharacters[i]);
    }
    return new String(inputStringToCharacters);
  }

  private char swapCharacterCase(char character) {
    if (Character.isUpperCase(character)) {
      return Character.toLowerCase(character);
    } else if (Character.isLowerCase(character)) {
      return Character.toUpperCase(character);
    }
    return character;
  }

  // This method will rotate the characters in a string by a specified number of steps.
  public String rotateCharacters(String input, int stepsToRotate) {
    validateInput(input, 2, "Cannot rotate a string with less than 2 characters.");
    int normalizedSteps = normalizeRotationSteps(stepsToRotate, input.length());
    return rotateStringBySteps(input, normalizedSteps);
  }

  private int normalizeRotationSteps(int stepsToRotate, int length) {
    stepsToRotate = stepsToRotate % length;
    if (stepsToRotate < 0) {
      stepsToRotate += length;
    }
    return stepsToRotate;
  }

  private String rotateStringBySteps(String input, int stepsToRotate) {
    int length = input.length();
    return input.substring(length - stepsToRotate) + input.substring(0, length - stepsToRotate);
  }

  public String vowelsToSymbols(String input) {
    validateInput(input, 1, "Cannot replace vowels in a string with less than 1 character/s.");
    return input.replace("A", "?")
                .replace("a", "=")
                .replace("E", ")")
                .replace("e", "(")
                .replace("I", "!")
                .replace("i", "@")
                .replace("O", "&")
                .replace("o", "/")
                .replace("U", "*")
                .replace("u", "%");
  }

  public String insertPhrase(String input) {
    validateInput(input, 2, "Cannot insert a phrase into a string with less than 2 characters.");
    int middle = calculateMiddleIndex(input.length());
    return insertPhraseAtPosition(input, middle);
  }

  private int calculateMiddleIndex(int length) {
    return length / 2;
  }

  private String insertPhraseAtPosition(String input, int position) {
    return input.substring(0, position) + phrase + input.substring(position);
  }

  /**
   * Note: This method (and its undo counter part) is flawed at the moment and requires a specific input format to be restored correctly.
   * The original string must be in a format where all words are lower cased and words are separated by spaces.
   * 
   * This method is subject to change in future iterations.
   */
  public String stringToCamelCase(String input) {
    validateInput(input, 1, "Cannot convert a string with less than 1 character/s to camel case.");
    // Regular expression is intended to match one or more white space occurances.
    String[] words = input.split("\\s+");
    // First word in camelCase is lower case.
    StringBuilder manipulatedString = new StringBuilder(words[0].toLowerCase());
    for (int i = 1; i < words.length; i++) {
      manipulatedString.append(words[i].substring(0, 1).toUpperCase());
      manipulatedString.append(words[i].substring(1).toLowerCase());
    }
    return manipulatedString.toString();
  }

  /**
   * 
   * Functions to Undo Manipulations.
   * 
   */

  public String undoDuplicateString(String manipulatedString) {
    validateInput(manipulatedString, 2, "Cant remove duplication from a string with less than 2 characters.");
    int halfLength = manipulatedString.length() / 2;
    return manipulatedString.substring(0, halfLength);
  }

  /**
   * For this function to work as intended, it is important that the value of stepsToRotate
   * has the same value as it had when used in rotateCharacters.
   */
  public String undoRotateCharacters(String manipulatedString, int stepsToRotate) {
    validateInput(manipulatedString, 2, "Cannot rotate a string with less than 2 characters.");
    int length = manipulatedString.length();
    int normalizedSteps = normalizeRotationSteps(stepsToRotate, length);
    return rotateCharacters(manipulatedString, length - normalizedSteps);
  }

  public String undoVowelsToSymbols(String manipulatedString) {
    validateInput(manipulatedString, 1, "Cannot replace vowels in a string with less than 1 character/s.");
    return manipulatedString.replace("?", "A")
                            .replace("=", "a")
                            .replace(")", "E")
                            .replace("(", "e")
                            .replace("!", "I")
                            .replace("@", "i")
                            .replace("&", "O")
                            .replace("/", "o")
                            .replace("*", "U")
                            .replace("%", "u");
  }

  public String undoInsertPhrase(String manipulatedString) {
    validateInput(manipulatedString, 2, "Cannot insert a phrase into a string with less than 2 characters.");
    return manipulatedString.replace(phrase, "");
  }

  /**
   * This method will undo the camel case manipulation.
   *
   * It splits the string att upper case letters and joins the with spaces,
   * converting the words to lower case.
   *
   * Note: This method is flawed and cannot guarantee that the original string will be restored exactly
   * as it was before the camel case conversion. It returns a readable sentence with spaces
   * between words and the first word in lowercase.
   * 
   * This method is subject to change in future iterations.
   *
   * @param manipulatedString - The string to be restored.
   * @return - Intended: The original String, else: readable string.
   */
  public String undoStringToCamelCase(String manipulatedString) {
    validateInput(manipulatedString, 1, "Cannot convert a string with less than 1 character/s to camel case.");
    // Regular expression intended to split string at each upper case letter.
    String[] words = manipulatedString.split("(?=[A-Z])");
    // Appends all the words in lower case as a regular sentence,
    // without a capital letter at the start.
    StringBuilder originalString = new StringBuilder(words[0]);
    for (int i = 1; i < words.length; i++) {
      originalString.append(" ").append(words[i].toLowerCase());
    }
    return originalString.toString();
  }

  private void validateInput(String input, int minLength, String errorMessage) {
    if (input == null || input.length() < minLength || input.trim().isEmpty()) {
      throw new IllegalArgumentException(errorMessage);
    }
  }
}
