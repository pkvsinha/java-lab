package com.github.pkvsinha.ds.graphs.algo;

import com.github.pkvsinha.ds.graphs.Graph;

public class ConnectedComponents {

  private boolean[] visited;

  private int[] id;
  
  private int count;

  private Graph graph;

  public ConnectedComponents(Graph graph) {
    this.graph = graph;
    id = new int[graph.vertices()];
    for (int s = 0; s < graph.vertices(); s++) {
      if (!visited[s]) {
        dfs(s);
        count++;
      }
    }
  }

  private void dfs(int v) {
    this.visited[v] = true;
    id[v] = count;
    for (int x : graph.adjacent(v)) {
      if (!visited[x]) dfs(x);
    }
  }

  public boolean connected(int u, int v) {
    return id[u] == id[v];
  }

  public int count() {
    return this.count;
  }

  public int id(int v) {
    return id[v];
  }
}
