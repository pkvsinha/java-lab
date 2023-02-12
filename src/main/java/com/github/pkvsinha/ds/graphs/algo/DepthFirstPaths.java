package com.github.pkvsinha.ds.graphs.algo;

import com.github.pkvsinha.ds.graphs.Graph;

public class DepthFirstPaths extends Paths {

  public DepthFirstPaths(Graph graph, int s) {
    super(graph, s);
  }

  private void dfs(int v) {
    this.visited[v] = true;
    for (int x : this.graph.adjacent(v)) {
      if (!visited[x]) {
        edgeTo[x] = v;
        dfs(x);
      }
    }
  }

  @Override
  protected void traverse() {
    dfs(this.source);
  }
}
