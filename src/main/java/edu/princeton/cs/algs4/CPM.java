package edu.princeton.cs.algs4;
import  edu.princeton.cs.introcs.*;

/*************************************************************************
 *  Compilation:  javac CPM.java
 *  Execution:    java CPM < input.txt
 *  Dependencies: EdgeWeightedDigraph.java AcyclicDigraphLP.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/44sp/jobsPC.txt
 *
 *  Critical path method.
 *
 *  % java CPM < jobsPC.txt
 *   job   start  finish
 *  --------------------
 *     0     0.0    41.0
 *     1    41.0    92.0
 *     2   123.0   173.0
 *     3    91.0   127.0
 *     4    70.0   108.0
 *     5     0.0    45.0
 *     6    70.0    91.0
 *     7    41.0    73.0
 *     8    91.0   123.0
 *     9    41.0    70.0
 *  Finish time:   173.0
 *
 *************************************************************************/

public class CPM {

    public static void main(String[] args) {

        // number of jobs
        int N = StdIn.readInt();

        // source and sink
        int source = 2*N;
        int sink   = 2*N + 1;

        // build network
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(2*N + 2);
        for (int i = 0; i < N; i++) {
            double duration = StdIn.readDouble();
            G.addEdge(new DirectedEdge(source, i, 0.0));
            G.addEdge(new DirectedEdge(i+N, sink, 0.0));
            G.addEdge(new DirectedEdge(i, i+N,    duration));

            // precedence constraints
            int M = StdIn.readInt();
            for (int j = 0; j < M; j++) {
                int precedent = StdIn.readInt();
                G.addEdge(new DirectedEdge(N+i, precedent, 0.0));
            }
        }

        // compute longest path
        AcyclicLP lp = new AcyclicLP(G, source);

        // print results
        StdOut.println(" job   start  finish");
        StdOut.println("--------------------");
        for (int i = 0; i < N; i++) {
            StdOut.printf("%4d %7.1f %7.1f\n", i, lp.distTo(i), lp.distTo(i+N));
        }
        StdOut.printf("Finish time: %7.1f\n", lp.distTo(sink));
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

