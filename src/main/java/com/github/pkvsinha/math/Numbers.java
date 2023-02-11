package com.github.pkvsinha.math;

public class Numbers {
  
  public static int[] digits() {
    return new int[] {};
  }

  public static int sumOfSquares(int n) {
    var sum = 0;
    var place = 1;
    int digit;
    while (n != 0) {
        digit = (n % (place * 10)) / place;
        sum += (digit * digit);
        n /= 10;
    }
    return sum;
  }
}
