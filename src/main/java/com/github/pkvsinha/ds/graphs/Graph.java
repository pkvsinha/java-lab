package com.github.pkvsinha.ds.graphs;

public interface Graph {
  
  public int vertices();

  public int edges();

  public void addEdge(int v);

  public Iterable<Integer> adjacent(int v);
}
