package com.github.pkvsinha.ds;

import java.util.Arrays;

public class UnionFind {

  private int count;

  private int[] nodes;

  private int[] sizes;

  public UnionFind(int size) {
    this.nodes = new int[size];
    this.sizes = new int[size];
    this.count = size;
    Arrays.fill(this.sizes, 1);
    for (int i = 0; i < size; i++) {
      this.nodes[i] = i;
    }
  }

  public void union(int u, int v) {
    int uroot = find(u);
    int vroot = find(v);
    if (uroot == vroot) return;
    if (this.sizes[uroot] < this.sizes[vroot]) {
      this.nodes[uroot] = vroot;
      this.sizes[vroot] += this.sizes[uroot];
    } else {
      this.nodes[vroot] = uroot;
      this.sizes[uroot] += this.sizes[vroot];
    }
    this.count -= 1;
  }

  public int find(int v) {
    var p = v;
    while (p != this.nodes[p]) p = this.nodes[p];
    return p;
  }

  public int count() {
    return count;
  }
  
  public boolean connected(int u, int v) {
    return find(u) == find(v);
  }
}
