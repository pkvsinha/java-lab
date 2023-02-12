package com.github.pkvsinha.ds.graphs.algo;

import java.util.LinkedList;
import java.util.Queue;

import com.github.pkvsinha.ds.graphs.Graph;

public class BreadthFirstPaths extends Paths {
  
  public BreadthFirstPaths(Graph graph, int s) {
    super(graph, s);
  }

  private void bfs(int s) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(s);
    this.visited[s] = true;
    while(!queue.isEmpty()) {
      int v = queue.poll();
      for (int x : graph.adjacent(v)) {
        if (!visited[x]) {
          this.visited[v] = true;
          this.edgeTo[x] = v;
          queue.offer(x);
        }
      }
    }
  }

  @Override
  protected void traverse() {
    bfs(this.source);
  }
}
