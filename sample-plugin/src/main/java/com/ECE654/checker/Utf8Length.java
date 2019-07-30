package com.ECE654.checker;

import com.google.common.base.Utf8;
import com.google.errorprone.refaster.annotation.AfterTemplate;
import com.google.errorprone.refaster.annotation.BeforeTemplate;

import java.nio.charset.StandardCharsets;

class Utf8Length { // A name for the refactoring
  @BeforeTemplate
    // This is what the code looks like before the refactoring
  int toUtf8Length( // the method name is unimportant
      String string /* the string parameter stands in for any expression of type String */) {
    return /* this is here just to make the compiler happy */
        string.getBytes(StandardCharsets.UTF_8).length;
    // this is what the code looks like before the refactoring
  }

  @AfterTemplate
    // replace code with this pattern
  int optimizedMethod(
      String string /* substitute in the original String expression */) {
    return Utf8.encodedLength(string);
  }
}
