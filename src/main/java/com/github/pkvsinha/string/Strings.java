package com.github.pkvsinha.string;

import com.github.pkvsinha.array.Arrays;

public class Strings {
  
  public static String reverse(String s) {
    var i = 0;
    var j = s.length() - 1;
    char[] charArray = s.toCharArray();
    while (i < j) {
      Arrays.swap(charArray, i++, j--);
    }
    return new String(charArray);
  }

  /**
   * Knuth-Morris-Pratt (KMP)
   * @param text
   * @param pattern
   */
  public static void kmp(String text, String pattern) {

  }

  /**
   * Boyer-Moore
   * @param text
   * @param pattern
   */
  public static void bm(String text, String pattern) {

  }

  /**
   * Rabin-Karp
   * @param text
   * @param pattern
   */
  public static void rk(String text, String pattern) {

  }

  /**
   * https://www.geeksforgeeks.org/z-algorithm-linear-time-pattern-searching-algorithm/
   * 
   * @param text
   * @param pattern
   */
  public static void zAlgo(String text, String pattern) {

  }
}
