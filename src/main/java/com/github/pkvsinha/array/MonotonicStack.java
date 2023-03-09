package com.github.pkvsinha.array;

import java.util.Stack;

public class MonotonicStack<T extends Comparable<T>> extends Stack<T>{

  @Override
  public T push(T el) {
    if (el == null) return el;
    while(!this.isEmpty() && el.compareTo(this.peek()) < 1) {
      this.pop();
    }
    
    return super.push(el);
  }
}
