# StringCryption Library
# version 1.0.0

## Introduction

The `StringCryption` library is intended to provide a comprehensive suite of methods for encrypting and decrypting strings at various levels of complexity. Designed with flexibility in mind, this library allows users to choose from multiple encryption levels, each offering a different degree of complexity.

The library is now at its first release and there are known issues and conflicts present that will be resolved in future versions. Not to say that the library is unsafe to use, the known conflicts and issues are worked around and the lib is well tested to avoid side-effects.

## Unique Selling Points (USP)

- **Multiple Encryption Levels:** Choose from different levels of encryption complexity, ranging from simple to highly complex algorithms.
- **Ease of Use:** Simple and intuitive API that makes it easy to integrate encryption and decryption functionalities into your projects.
- **Customizable:** The user can either download the .jar file to simply use the implemented interface or clone the entire project and discover their own customization.
- **Comprehensive String Manipulation:** Includes additional string manipulation methods like reversing, duplicating, rotating characters, and swapping cases.
- **More to come** future iterations will add more options to expand the customization, security and flexibility.

## How to Use

### Option 1: Clone the Entire Project

1. **Navigate to Your Desired Directory:**
  - Open a terminal and navigate to the directory where you want to clone the repository. For example:
  ```sh
  cd path/to/your/desired/directory
  ```

2. **Clone the Repository:**
  - Press the `<> Code` button in the GitHub repository and copy the URL.
  - Or Use the following command to clone the repository:
  ```sh
  git clone https://github.com/Letssdothiss/610-L2.git
  ```

3. **Navigate to the Cloned Repository:**
  - Change the directory to the cloned repository:
  ```sh
  cd 610-L2
  ```

4. **Use the JAR File:**
   - The `StringCryption.jar` file is already included in the cloned repository. You can directly add it to your project as described in option 2.

### Option 2: Download the JAR File

1. **Download the JAR File:**
   - Download the `StringCryption.jar` file from the releases section or directly from the repository.

2. **Add the JAR File to Your Project:**

#### Using an IDE

- **IntelliJ IDEA:**
  - Follow the instructions in the [IntelliJ IDEA documentation](https://www.jetbrains.com/help/idea/library.html#add-library).

- **Eclipse:**
  - Follow the instructions in the [Eclipse documentation](https://help.eclipse.org/latest/index.jsp).
  - Search for ´SWT Java Project Wizard´ and click on the topic that matches the search query.(For some reason the direct link wont load the proper page.)

- **Visual Studio Code(VS code):**
  - Follow the instructions in the [VS Code documentation](https://code.visualstudio.com/docs/java/java-project#_working-with-jar-files).

#### Using the Command Line

1. **Compile Your Project with the JAR File:**
   - Ensure the `StringCryption.jar` file is in your project's directory.
   - Compile your project with the JAR file in the classpath.
   ```sh
   javac -cp .;StringCryption.jar YourMainClass.java
   ```

2. **Run Your Project with the JAR File:**
   - Run your project with the JAR file in the classpath.
   ```sh
   java -cp .;StringCryption.jar YourMainClass
   ```

### 3. Using the library in your code
   - Import the StringCryption class and use its methods in your code.

```java
import main.java.stringCryption.StringCryption;

public class YourMainClass {
  public static void main(String[] args) {
    StringCryption stringCryption = new StringCryption();

    String exampleInput = "The string to encrypt."
    int exampleLevel = 3 // A number between 1-5 in current implementation.

    // Encrypting a string.
    String encryptedInput = stringCryption.encryptAtChosenLevel(exampleInput, exampleLevel)
    System.out.println("Encrypted Input: " + encryptedInput)

    // Decrypting a string
    String decryptedInput = stringCryption.decryptAtChosenLevel(encryptedInput, exampleLevel)
    System.out.println("Decrypted Input: " + decrypted)
  }
}
```
#### Methods in the public interface
   - The public interface contains two usable methods which can result in five different outcomes each.

### `public String encryptAtChosenLevel(String input, int levelOfEncryption)`
   - Description: This method takes a string to encrypt as its first arguemnt and the second is a choice of 1-5 to which level the desired encryption should be. Where one is the least complex and five is the most complex encryption.
   - Returns: It returns the input string but encrypted to the chosen level.

### `public String decryptAtChosenLevel(String encryptedInput, int levelOfDecryption)`
   - Description: This method takes an encrypted string as its first argument and an integer between 1-5 as its second argument. There are two conditions that need to be met for the decryption to be successful, the encrypted string must be a returned string from the encryptAtChosenLevel() method and the decryption level must be the same level used to encrypt the original input. 
   - Returns: The decrypted string, original input.


#### Notes
   - Make sure to enter a valid encryption level (1-5 in current implementation.)
   - The same level of encryption used on an input have to be used when decrypting, else the result wont be the same.
   - If these five options are not enough, the option to create custom methods for encryption is possible if the project is cloned.

## Issues and bugs

### Issues

#### vowelTosymbol & undoVowelToSymbol
   - These two methods will cause issues if used on a string which has been salted first. Either direction the methods are used, if both are used on a salted string, the output will either be more or less of either symbols or vowels. This is because the salt encryption adds both letters(vowels) and symbols, this will most likely interfere with the vowel-to-symbol conversion.

#### stringToCamelCase & undoStringToCamelCase 
   - The stringToCamelCase method correctly transforms a string to camel case, but the undoStringToCamelCase method only creates a readable string with spaces between words.  It does not guarantee that the original string will be restored exactly as it was before the camel case conversion.

### Potential bugs

#### Duplicate String and Rotate Characters
   - If you duplicate a string and then rotate the characters, the undo methods must be called in the exact reverse order with the correct parameters to restore the original string. Any deviation in the order or parameters can result in an incorrect output.

#### Swap Case and Insert Phrase
   - If you swap the case of a string and then insert a phrase, the undo methods must be called in the exact reverse order to restore the original string. Any deviation in the order can result in an incorrect output.

## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE.txt) file for details.

### MIT License