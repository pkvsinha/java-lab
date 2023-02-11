package com.github.pkvsinha.parallel;

import java.util.function.Consumer;

public class Threads {
  
  public static <T> void spawn(final Consumer<T> consumer, final T param) {
    Thread th = new Thread() {
      @Override
      public void run() {
        consumer.accept(param);
      }
    };
    th.start();
  }
}
