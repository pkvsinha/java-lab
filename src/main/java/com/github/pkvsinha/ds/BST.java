package com.github.pkvsinha.ds;

public interface BST<Key extends Comparable<Key>, Value> {
  
  Value get(Key key);

  void put(Key key, Value value);

  int size();

  void remove(Key key);

  Iterable<Key> keys();

  Iterable<Key> keys(Key min, Key max);

  /**
   * Order methods
   */
  Key min();

  Key floor(Key key);

  Key ceil(Key key);

  Key select(int k);

  int rank(Key key);

}
