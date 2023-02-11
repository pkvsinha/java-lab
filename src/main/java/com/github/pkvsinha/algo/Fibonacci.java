package com.github.pkvsinha.algo;

public class Fibonacci {

  private int fibonacci(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;

    return fibonacci(n - 1) + fibonacci(n - 2);
  }
  
  public static void generate(int n) {

  }
}
