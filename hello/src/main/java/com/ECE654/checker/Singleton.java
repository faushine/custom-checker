package com.ECE654.checker;

public class Singleton {

  private volatile static Singleton instance = null;

  private Singleton() {
  }

  public static Singleton getSingleton() {
    if (instance == null) {
      synchronized (Singleton.class) {
        if (instance == null) {
          instance = new Singleton();
        }
      }
    }
    return instance ;
  }
}
