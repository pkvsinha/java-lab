package com.github.pkvsinha.collections;

import java.util.Collection;

public class Array {

  public static int[] toIntArray(Collection<Integer> integerArray) {
    return integerArray.stream().mapToInt(Integer::intValue).toArray();
  }
}
