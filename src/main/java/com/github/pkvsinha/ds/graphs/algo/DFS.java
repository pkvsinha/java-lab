package com.github.pkvsinha.ds.graphs.algo;

import com.github.pkvsinha.ds.graphs.Graph;

public class DFS {

  private Graph graph;

  private boolean[] marked;

  private int count;

  public DFS(Graph graph, int s) {
    this.graph = graph;
    this.marked = new boolean[graph.vertices()];
    dfs(s);
  }
  
  private void dfs(int v) {
    marked[v] = true;
    count++;
    for (var u : graph.adjacent(v)) {
      if (!marked[u]) dfs(u);
    }
  }

  public boolean marked(int u) {
    return marked[u];
  }

  public int count() {
    return count;
  }
}
