package com.virtualpairprogrammers.isbntools;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

import org.junit.Test;

public class ValidateISBNTest {

  @Test
  public void checkAValid10DigitISBN() {
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("0143039954");
    assertTrue("first value", result);

    result = validator.checkISBN("0140177396");
    assertTrue("second value", result);
  }

  @Test
  public void checkAValid13DigitISBN() {
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("9781503280786");
    assertTrue("first value", result);

    result = validator.checkISBN("9780099908401");
    assertTrue("second value", result);
  }

  @Test
  public void tenDigitISBNNumbersEndingInAnXAreValid() {
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("012000030X");
    assertTrue(result);
  }

  @Test
  public void checkAnInvalidValid10DigitISBN() {
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("0143039955");
    assertFalse(result);
  }

  @Test
  public void checkAnInvalidValid13DigitISBN() {
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("9781503280787");
    assertFalse(result);
  }

  @Test(expected = NumberFormatException.class)
  public void nineDigitISBNAreNotAllowed() {
    ValidateISBN validator = new ValidateISBN();
    validator.checkISBN("123456789");
  }

  @Test(expected = NumberFormatException.class)
  public void nonNumericISBNAreNotAllowed() {
    ValidateISBN validator = new ValidateISBN();
    validator.checkISBN("helloworld");
  }

}
