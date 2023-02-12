package com.github.pkvsinha.ds.graphs.algo;

import java.util.Stack;

import com.github.pkvsinha.ds.graphs.Graph;

public abstract class Paths {

  protected Graph graph;

  protected int source;

  protected int[] edgeTo;

  protected boolean[] visited;

  public Paths(Graph graph, int s) {
    this.graph = graph;
    this.source = s;
    this.edgeTo = new int[graph.vertices()];
    this.visited = new boolean[graph.vertices()];
    traverse();
  }

  protected abstract void traverse();

  boolean hasPathTo(int v) {
    return visited[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) return null;
    Stack<Integer> path = new Stack<>();
    for (int x = v; x != source; x = edgeTo[x]) {
      path.push(x);
    }
    path.push(source);
    return path;
  }
}
