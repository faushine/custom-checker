package com.ECE654.checker;


public class NoSynchronizedPositiveCases {

  private static int count = 0;

  public static synchronized int getCount(){
    // BUG: Diagnostic contains: Used synchronized modifier in public method
    return count;
  }

  public void setCount(int count){
    // BUG: Diagnostic contains: Used instance variable as synchronization lock
    synchronized (this){
      NoSynchronizedPositiveCases.count = count;
    }
  }

}
