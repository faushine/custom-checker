
package com.ECE654.checker;

public class DoNotReturnNullPositiveCases {
  // BUG: Diagnostic contains: Do not return null.
  public Object returnsNull() {
    return null;
  }

  // BUG: Diagnostic contains: Do not return null.
  public Object sometimesReturnsNull(boolean random) {
    if (random) {
      return null;
    }
    return new Object();
  }
}

