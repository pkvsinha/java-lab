package com.github.pkvsinha.ds;

import java.util.Arrays;

public class MaxPriorityQueue {
      
  private int size;

  private int heapSize;

  private int[] data;

  public MaxPriorityQueue(int size) {
      this.size = size;
      this.data = new int[size];
  }

  private int parent(int i) {
      return (i - 1) / 2;
  }

  private int left(int i) {
      return (2 * i) + 1;
  }

  private int right(int i) {
      return left(i) + 1;
  }

  private void swap(int i, int j) {
      this.data[i] += this.data[j];
      this.data[j] = this.data[i] - this.data[j];
      this.data[i] -= this.data[j];
  }

  private int value(int i) {
      return this.data[i];
  }

  private void swim(int index) {
      var i = index;
      var parentIndex = parent(i);
      while (parentIndex >= 0 && this.data[i] < this.data[parentIndex]) {
          swap(parentIndex, i);
          i = parentIndex;
          parentIndex = parent(i);
      }
  }

  private void sink(int index) {
      var i = index;
      while (i < this.heapSize) {
          var swapIndex = i;
          var leftIndex = left(i);
          var rightIndex = right(i);
          if (leftIndex < heapSize && this.data[leftIndex] < this.data[swapIndex]) {
              swapIndex = leftIndex;
          }
          if (rightIndex < heapSize && this.data[rightIndex] < this.data[swapIndex]) {
              swapIndex = rightIndex;
          }
          if (swapIndex == i) break;
          swap(swapIndex, i);
          i = swapIndex;
      }
  }

  public boolean isFull() {
      return heapSize == size;
  }

  public boolean isEmpty() {
      return heapSize == 0;
  }

  public void insert(int n) {
      if (isFull()) {
        if (n < findMin()) {
          this.removeMin();
        } else {
          return;
        }
      }
      this.data[heapSize] = n;
      swim(heapSize);
      heapSize++;
  }

  public int remove() {
      var maxNum = this.data[0];
      this.data[0] = this.data[heapSize - 1];
      heapSize--;
      sink(0);
      return maxNum;
  }

  public int findMin() {
    var minIndex = 0;
    for (var i = 1; i < heapSize; i++) {
        if (value(i) > value(minIndex)) {
            minIndex = i;
        }
    }
    return value(minIndex);
}

  public int removeMin() {
      var minIndex = 0;
      for (var i = 1; i < heapSize; i++) {
          if (value(i) > value(minIndex)) {
              minIndex = i;
          }
      }
      var minValue = value(minIndex);
      this.data[minIndex] = this.data[heapSize - 1];
      heapSize--;
      swim(minIndex);

      return minValue;
  }

  public int[] toArray() {
    return Arrays.copyOf(data, heapSize);
  }
}
