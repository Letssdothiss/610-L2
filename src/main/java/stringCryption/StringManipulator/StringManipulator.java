package main.java.stringCryption.StringManipulator;

public class StringManipulator {
  /**
   * This is the phrase that will be used in the insertPhrase method.
   *
   * @type {String}
   */
  private String phrase = "!#THTRJYDHGS#¤%&UHDAWE35ythrsr563423435ythgfds";

  /**
   * Functions to Perform Manipulations.
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
    if (input.length() < 2) {
      throw new IllegalArgumentException("Cannot reverse a string with less than 2 characters.");
    }
    String manipulatedString = new StringBuilder(input).reverse().toString();
    return manipulatedString;
  }

  public String duplicateString(String input) {
    if (input.length() < 1) {
      throw new IllegalArgumentException("Cannot duplicate a string with less than 1 character/s.");
    }
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
    if (input.length() < 1) {
      throw new IllegalArgumentException("Cannot swap case of a string with less than 1 character/s.");
    }

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
    if (input.length() < 2) {
      throw new IllegalArgumentException("Cannot rotate a string with less than 2 characters.");
    }

    int length = input.length();
    // Modulo is used to prevent unnecessary rotations, 
    // while still modifying the string to the requested position.
    stepsToRotate = stepsToRotate % length;
    if (stepsToRotate < 0) {
      stepsToRotate += length;
    }
    // (Characters to move) + (input string - characters to move)
    String manipulatedString = input.substring(length - stepsToRotate) + input.substring(0, length - stepsToRotate);
    return manipulatedString;
  }

  public String vowelsToSymbols(String input) {
    if (input.length() < 1) {
      throw new IllegalArgumentException("Cannot replace vowels in a string with less than 1 character/s.");
    }

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

  public String insertPhrase(String input) {
    if (input.length() < 2) {
      throw new IllegalArgumentException("Cannot insert a phrase into a string with less than 2 characters.");
    }

    int middle = input.length() / 2;
    String manipulatedString = input.substring(0, middle) + phrase + input.substring(middle);
    return manipulatedString;
  }

  /**
   * Note: This method (and its undo counter part) is flawed at the moment and requires a specific input format to be restored correctly.
   * The original string must be in a format where all words are lower cased and words are separated by spaces.
   * 
   * This method is subject to change in future iterations.
   */
  public String stringToCamelCase(String input) {
    if (input.length() < 1) {
      throw new IllegalArgumentException("Cannot convert a string with less than 1 character/s to camel case.");
    }

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
    if(manipulatedString.length() < 2) {
      throw new IllegalArgumentException("Cant remove duplication from a string with less than 2 characters.");
    }

    int removeDuplication = manipulatedString.length() / 2;
    String originalInput = manipulatedString.substring(0, removeDuplication);
    return originalInput;
  }

  /**
   * For this function to work as intended, it is important that the value of stepsToRotate
   * has the same value as it had when used in rotateCharacters.
   */
  public String undoRotateCharacters(String manipulatedString, int stepsToRotate) {
    if (manipulatedString.length() < 2) {
      throw new IllegalArgumentException("Cannot rotate a string with less than 2 characters.");
    }

    int length = manipulatedString.length();
    stepsToRotate = stepsToRotate % length;
    if (stepsToRotate < 0) {
      stepsToRotate += length;
    }
    String originalInput = rotateCharacters(manipulatedString, length - stepsToRotate);
    return originalInput;
  }

  public String undoVowelsToSymbols(String manipulatedString) {
    if (manipulatedString.length() < 1) {
      throw new IllegalArgumentException("Cannot replace vowels in a string with less than 1 character/s.");
    }

    String originalInput = manipulatedString.replace("?", "A")
                                                 .replace("=", "a")
                                                 .replace(")", "E")
                                                 .replace("(", "e")
                                                 .replace("!", "I")
                                                 .replace("@", "i")
                                                 .replace("&", "O")
                                                 .replace("/", "o")
                                                 .replace("*", "U")
                                                 .replace("%", "u");
    return originalInput;
  }

  public String undoInsertPhrase(String manipulatedString) {
    String originalInput = manipulatedString.replace(phrase, "");
    return originalInput;
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
    if (manipulatedString.length() < 1) {
      throw new IllegalArgumentException("Cannot convert a string with less than 1 character/s to camel case.");
    }

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
}
