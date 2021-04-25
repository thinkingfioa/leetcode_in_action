package com.thinking.common;

/**
 * @author thinking_fioa 04/09/2019
 */
public class ConsoleOutput {

  private ConsoleOutput() {
    throw new UnsupportedOperationException("static class");
  }

  public static void printf(Object o) {
    System.out.printf(GolbalInstance.GSON_PRETTY.toJson(o));
  }
}
