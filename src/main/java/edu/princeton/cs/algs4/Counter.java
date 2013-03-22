package edu.princeton.cs.algs4;
import  edu.princeton.cs.introcs.*;

/*************************************************************************
 *  Compilation:  javac Counter.java
 *  Execution:    java Counter N T
 *  Dependencies: StdRandom.java StdOut.java
 *
 *  A mutable data type for an integer counter.
 *
 *  The test clients create N counters and performs T increment
 *  operations on random counters.
 *
 *  % java Counter 6 600000
 *  0: 99870
 *  1: 99948
 *  2: 99738
 *  3: 100283
 *  4: 100185
 *  5: 99976
 *
 *************************************************************************/

public class Counter implements Comparable<Counter> {

    private final String name;     // counter name
    private int count;             // current value

    // create a new counter
    public Counter(String id) {
        name = id;
    } 

    // increment the counter by 1
    public void increment() {
        count++;
    } 

    // return the current count
    public int tally() {
        return count;
    } 

    // return a string representation of this counter
    public String toString() {
        return count + " " + name;
    } 

    // compare two Counter objects based on their count
    public int compareTo(Counter that) {
        if      (this.count < that.count) return -1;
        else if (this.count > that.count) return +1;
        else                              return  0;
    }


    // test client
    public static void main(String[] args) { 
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        // create N counters
        Counter[] hits = new Counter[N];
        for (int i = 0; i < N; i++) {
            hits[i] = new Counter("counter" + i);
        }

        // increment T counters at random
        for (int t = 0; t < T; t++) {
            hits[StdRandom.uniform(N)].increment();
        }

        // print results
        for (int i = 0; i < N; i++) {
            StdOut.println(hits[i]);
        }
    } 
} 


/*************************************************************************
 *  Copyright 2002-2012, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4-package.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4-package.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4-package.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.

 *  You should have received a copy of the GNU General Public License
 *  along with algs4-package.jar.  If not, see http://www.gnu.org/licenses.
 *************************************************************************/

