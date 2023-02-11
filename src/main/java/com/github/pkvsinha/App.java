package com.github.pkvsinha;

import java.util.Arrays;

import com.github.pkvsinha.ds.MaxPriorityQueue;
import com.github.pkvsinha.math.Numbers;
import com.github.pkvsinha.parallel.Threads;
import com.github.pkvsinha.parallel.TimedExec;

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
    public static void main( String[] args ) {
        runThreadsExample();
    }
}