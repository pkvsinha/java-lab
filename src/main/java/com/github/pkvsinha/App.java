package com.github.pkvsinha;

import java.util.Arrays;
import java.util.List;

import com.github.pkvsinha.array.MonotonicStack;
import com.github.pkvsinha.ds.MaxPriorityQueue;
import com.github.pkvsinha.math.Numbers;
import com.github.pkvsinha.parallel.Threads;
import com.github.pkvsinha.parallel.TimedExec;
import com.github.pkvsinha.string.Strings;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void runThreadsExample() {
        Threads.spawn(t -> {
            System.out.println("Hello World " + t);
        }, 5);
        TimedExec.every(t -> {
            System.out.println("Hello World s " + t);
        }, 5, 1000);
    }

    public static void indexExample() {
        for (int n : new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}) {
            System.out.println(Arrays.toString(index(3, 5, n)) + " = " + n);
        }
    }
    public static void main( String[] args ) {
        // runThreadsExample();
        int[] els = new int[] {1, 4, 5, 3, 12, 10};
        MonotonicStack<Integer> stack = new MonotonicStack<>();
        for (var el : els) {
            stack.push(el);
        }
        System.out.println(stack.toString());
        System.out.println(Strings.reverse("Hellos!"));
    }

    public static int[] index(int rows, int cols, int value) {
        return new int[] { value /  cols, value % cols };
    }
}