package com.github.pkvsinha.ds;

public class RedBlackTree<Key extends Comparable<Key>, Value> implements BST<Key, Value> {

  private static enum Color { BLACK, RED };

  private Node root;

  private class Node {
    Key key;
    Value value;
    Node left, right;
    int N;
    Color color;

    Node(Key key, Value value, int N) {
      this.key = key;
      this.value = value;
      this.N = N;
      this.color = Color.RED;
    }
  }

  private boolean isRed(Node node) {
    return node.color == Color.RED;
  }

  private boolean isBlack(Node node) {
    return !isRed(node);
  }

  @Override
  public int size() {
    return size(root);
  }

  private int size(Node node) {
    if (node == null) return 0;
    return node.N;
  }
  
  @Override
  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node node, Key key) {
    if (node == null || key == null) return null;
    int cmp = node.key.compareTo(key);
    if (cmp == 0) {
      return node.value;
    } else if (cmp < 0) {
      return get(node.left, key);
    } else {
      return get(node.right, key);
    }
  }
  
  @Override
  public void put(Key key, Value value) {
    if (key == null) return;
    root = put(root, key, value);
    root.color = Color.BLACK;
  }

  private Node put(Node node, Key key, Value value) {
    if (node == null) return new Node(key, value, 1);
    int cmp = node.key.compareTo(key);
    if (cmp == 0) {
      node.value = value;
    } else if (cmp < 0) {
      node.left = put(node.left, key, value);
    } else {
      node.right = put(node.right, key, value);
    }

    if (isRed(node.right) && isBlack(node.left)) node = rotateLeft(node);
    if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
    if (isRed(node.left) && isRed(node.left)) flipColor(node);

    node.N = 1 + size(node.left) + size(node.right);
    return node;
  }

  private Node rotateLeft(Node h) {
    Node x = h.right;
    h.right = x.left;
    x.left = h;
    x.color = h.color;
    x.N = h.N;
    h.N = 1 + size(h.left) + size(h.right);
    h.color = Color.RED;

    return x;
  }

  private Node rotateRight(Node h) {
    Node x = h.left;
    h.left = x.right;
    x.right = h;
    x.color = h.color;
    x.N = h.N;
    h.N = 1 + size(h.left) + size(h.right);
    h.color = Color.RED;

    return x;
  }

  private void flipColor(Node h) {
    h.color = Color.RED;
    h.left.color = Color.BLACK;
    h.right.color = Color.BLACK;
  }
  @Override
  public void remove(Key key) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Key min() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Key floor(Key key) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Key ceil(Key key) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Key select(int k) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int rank(Key key) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Iterable<Key> keys() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Iterable<Key> keys(Key min, Key max) {
    // TODO Auto-generated method stub
    return null;
  }
}
