package Test.java.stringCryption.Salt;

import java.util.Base64;
import main.java.stringCryption.Salt.Salt;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SaltTest {

  private Salt inputSalter;
  private String input = "Testing the salt class.";
  private int saltLength = 16;

  @BeforeEach
  public void setUp() {
    inputSalter = new Salt();
  }

  @Test
  public void testAddSalt() {
    String saltedInput = inputSalter.addSalt(input, saltLength);
    
    assertTrue(saltedInput.length() > input.length(), "Salted input should be longer than input.");
  }

  @Test
  public void testGetSalt() {
    inputSalter.addSalt(input, saltLength);
    String salt = inputSalter.getSalt();

    assertEquals(saltLength, Base64.getDecoder().decode(salt).length, "Salt length should be equal to the specified length.");
  }

  @Test
  public void testRemoveSalt() {
    String saltedInput = inputSalter.addSalt(input, saltLength);
    String unsaltedInput = inputSalter.removeSalt(saltedInput);

    assertEquals(input, unsaltedInput, "Unsalted input should be equal to the original input.");
  }

  @Test
  public void testAddSaltWithEmptyInput() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      inputSalter.addSalt("", saltLength);
    });
    assertEquals("Input string must contain atleast one character.", exception.getMessage());
  }

  @Test
  public void testAddSaltWithSpaceInput() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      inputSalter.addSalt(" ", saltLength);
    });
    assertEquals("Input string must contain atleast one character.", exception.getMessage());
  }

  @Test
  public void testAddSaltWithInvalidSaltLength() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      inputSalter.addSalt(input, 0);
    });
    assertEquals("Salt length must be atleast 1.", exception.getMessage());
  }

  @Test
  public void testRemoveSaltWithEmptyInput() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      inputSalter.removeSalt("");
    });
    assertEquals("There is no salt to remove from this input.", exception.getMessage());
  }

  @Test
  public void testRemoveSaltWithSpaceInput() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      inputSalter.removeSalt(" ");
    });
    assertEquals("There is no salt to remove from this input.", exception.getMessage());
  }

  @Test
  public void testRemoveSaltWithInvalidSaltedInputLength() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      inputSalter.removeSalt("");
    });
    assertEquals("There is no salt to remove from this input.", exception.getMessage());
  }

}
