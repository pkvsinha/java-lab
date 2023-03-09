package com.github.pkvsinha.array;

public class Arrays {
  
  public static void swap(char[] array, int i, int j) {
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
