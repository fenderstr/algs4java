package edu.princeton.cs.algs4;
import  edu.princeton.cs.introcs.*;

/*************************************************************************
 *  Compilation:  javac Edge.java
 *  Execution:    java Edge
 *
 *  Immutable weighted edge.
 *
 *************************************************************************/

/**
 *  The <tt>Edge</tt> class represents a weighted edge in an undirected graph.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/43mst">Section 4.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class Edge implements Comparable<Edge> { 

    private final int v;
    private final int w;
    private final double weight;

   /**
     * Create an edge between v and w with given weight.
     */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

   /**
     * Return the weight of this edge.
     */
    public double weight() {
        return weight;
    }

   /**
     * Return either endpoint of this edge.
     */
    public int either() {
        return v;
    }

   /**
     * Return the endpoint of this edge that is different from the given vertex
     * (unless a self-loop).
     */
    public int other(int vertex) {
        if      (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("Illegal endpoint");
    }

   /**
     * Compare edges by weight.
     */
    public int compareTo(Edge that) {
        if      (this.weight() < that.weight()) return -1;
        else if (this.weight() > that.weight()) return +1;
        else                                    return  0;
    }


   /**
     * Return a string representation of this edge.
     */
    public String toString() {
        return String.format("%d-%d %.5f", v, w, weight);
    }


   /**
     * Test client.
     */
    public static void main(String[] args) {
        Edge e = new Edge(12, 23, 3.14);
        StdOut.println(e);
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

