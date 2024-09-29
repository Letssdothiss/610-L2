package main.java.stringCryption.StringManipulator;

public class StringManipulator {
  /**
   * This is the phrase that will be used in the insertPhrase method.
   *
   * @type {String}
   */
  private String phrase = "!#THTRJYDHGS#¤%&UHDAWE35ythrsr563423435ythgfds";

  /**
   * Manipulations.
   */

  /**
   * This method will reverse the input string.
   *
   * To undo the reversed string, call this method again with 
   * the manipulated string as the argument.
   * 
   * @param input - The string to be reversed.
   * @return - The reversed string.
   */
  public String reverseString(String input) {
    String manipulatedString = new StringBuilder(input).reverse().toString();
    return manipulatedString;
  }

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
   * To undo the case swap, call this method again on with
   * the manipulated string as the argument.
   *
   * @param input - The string to be modified.
   * @return - The manipulated string.
   */
  public String swapCase(String input) {
    char[] inputStringToCharacters = input.toCharArray();
    for (int i = 0; i < inputStringToCharacters.length; i++) {
      char characterInInput = inputStringToCharacters[i];
      if (Character.isUpperCase(characterInInput)) {
        inputStringToCharacters[i] = Character.toLowerCase(characterInInput);
      } else if (Character.isLowerCase(characterInInput)) {
        inputStringToCharacters[i] = Character.toUpperCase(characterInInput);
      }
    }
    String manipulatedString = new String(inputStringToCharacters);
    return manipulatedString;
  }

  /**
   * This method will rotate the characters in a string by a specified number of steps.
   * 
   * @param input - The string to be modified.
   * @param stepsToRotate - The number of steps to rotate the characters.
   * @return - The manipulated string.
   */
  public String rotateCharacters(String input, int stepsToRotate) {
    int length = input.length();
    // Modulo is used to prevent unnecessary rotations, 
    // while still modifying the string to the requested position.
    stepsToRotate = stepsToRotate % length;
    // (Characters to move) + (input string - characters to move)
    String manipulatedString = input.substring(length - stepsToRotate) + input.substring(0, length - stepsToRotate);
    return manipulatedString;
  }

  /**
   * This method will replace all vowels in a string with a specified symbol.
   *
   * @param input - The string to be modified.
   * @return - The manipulated string.
   */
  public String vowelsToSymbols(String input) {
    String manipulatedString = input.replace("A", "?")
                                    .replace("a", "=")
                                    .replace("E", ")")
                                    .replace("e", "(")
                                    .replace("I", "!")
                                    .replace("i", "@")
                                    .replace("O", "&")
                                    .replace("o", "/")
                                    .replace("U", "*")
                                    .replace("u", "%");
    return manipulatedString;
  }

  /**
   * This method will insert a pre-defined String into the middle of the input string.
   *
   * @param input - The string to be modified.
   * @return - The manipulated string.
   */
  public String insertPhrase(String input) {
    int middle = input.length() / 2;
    String manipulatedString = input.substring(0, middle) + phrase + input.substring(middle);
    return manipulatedString;
  }

  public String stringToCamelCase(String input) {
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
   * Functions to Undo Manipulations.
   */

  public String undoDuplicateString(String manipulatedString) {
    int removeDuplication = manipulatedString.length() / 2;
    String originalInput = manipulatedString.substring(0, removeDuplication);
    return originalInput;
  }

  /**
   * For this function to work as intended, it is important that the value of stepsToRotate
   * has the same value as it had when used in rotateCharacters.
   */
  public String undoRotateCharacters(String manipulatedString, int stepsToRotate) {
    String originalInput = rotateCharacters(manipulatedString, manipulatedString.length() - stepsToRotate);
    return originalInput;
  }

  public String undoVowelsToSymbols(String manipulatedString) {
    String originalInput = manipulatedString.replace("?", "A")
                                                 .replace("=", "a")
                                                 .replace(")", "E")
                                                 .replace("(", "e")
                                                 .replace("I", "!")
                                                 .replace("@", "i")
                                                 .replace("&", "O")
                                                 .replace("/", "o")
                                                 .replace("*", "U")
                                                 .replace("%", "u");
    return originalInput;
  }

  public String undoInsertPhrase(String manipulatedString) {}

  public String undoStringToCamelCase(String manipulatedString) {}
}
