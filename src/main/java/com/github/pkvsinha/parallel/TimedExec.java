package com.github.pkvsinha.parallel;

import java.util.function.Consumer;

public class TimedExec {
  
  public static <T> void every(final Consumer<T> consumer, final T param, int interval) {
    Threads.spawn(t -> {
      int i = 0;
      while(i < 5) {
        try {
          Thread.sleep(interval);
          Threads.spawn(consumer, param);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } finally {
          i++;
        }
      }
      
    }, null);
  }
}
