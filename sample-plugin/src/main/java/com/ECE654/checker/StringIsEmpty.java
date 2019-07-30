package com.ECE654.checker;

import com.google.errorprone.refaster.annotation.AfterTemplate;
import com.google.errorprone.refaster.annotation.AlsoNegation;
import com.google.errorprone.refaster.annotation.BeforeTemplate;

public class StringIsEmpty { // A name for the refactoring
  @BeforeTemplate // This is what the code looks like before the refactoring
  boolean equalsEmptyString( // the method name is unimportant
      String string /* the string parameter stands in for any expression of type String */) {
    return string.equals(""); // this is what the code looks like before the refactoring
  }

  @BeforeTemplate
  boolean lengthEquals0(String string) {
    return string.length() == 0;
  }

  @AfterTemplate // replace code with this pattern
  boolean optimizedMethod(String string  /* substitute in the original String expression */) {
    return string.isEmpty();
  }
}

