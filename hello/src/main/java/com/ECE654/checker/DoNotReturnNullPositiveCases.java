
package com.ECE654.checker;

import com.sun.istack.internal.Nullable;

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

  @Nullable
  public Object mightReturnsNull(boolean random) {
      return null; // this is okey because of the Nullable annotation
  }
}

