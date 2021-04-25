package com.thinking.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author thinking_fioa 04/09/2019
 */
public class GolbalInstance {

  private GolbalInstance() {
    throw new UnsupportedOperationException("static class");
  }

  public static Gson GSON_PRETTY = new GsonBuilder().setPrettyPrinting().create();
}
