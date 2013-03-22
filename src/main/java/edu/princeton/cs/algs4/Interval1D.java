package edu.princeton.cs.algs4;
import  edu.princeton.cs.introcs.*;

/*************************************************************************
 *  Compilation:  javac Interval1D.java
 *  Execution:    java Interval1D
 *  
 *  1-dimensional interval data type.
 *
 *************************************************************************/

import java.util.Arrays;
import java.util.Comparator;

public class Interval1D {
    public static final Comparator<Interval1D> LEFT_ENDPOINT_ORDER  = new LeftComparator();
    public static final Comparator<Interval1D> RIGHT_ENDPOINT_ORDER = new RightComparator();
    public static final Comparator<Interval1D> LENGTH_ORDER         = new LengthComparator();

    private final double left;
    private final double right;

    public Interval1D(double left, double right) {
        if (left <= right) {
            this.left  = left;
            this.right = right;
        }
        else throw new RuntimeException("Illegal interval");
    }

    // left endpoint
    public double left() { 
        return left;
    }

    // right endpoint
    public double right() { 
        return right;
    }

    // does this interval intersect that one?
    public boolean intersects(Interval1D that) {
        if (this.right < that.left) return false;
        if (that.right < this.left) return false;
        return true;
    }

    // does this interval contain x?
    public boolean contains(double x) {
        return (left <= x) && (x <= right);
    }

    // length of this interval
    public double length() {
        return right - left;
    }

    // string representation of this interval        
    public String toString() {
        return "[" + left + ", " + right + "]";
    }



    private static class LeftComparator implements Comparator<Interval1D> {
        public int compare(Interval1D a, Interval1D b) {
            if      (a.left  < b.left)  return -1;
            else if (a.left  > b.left)  return +1;
            else if (a.right < b.right) return -1;
            else if (a.right > b.right) return +1;
            else                        return  0;
        }
    }

    // ascending order of right endpoint, breaking ties by left endpoint
    private static class RightComparator implements Comparator<Interval1D> {
        public int compare(Interval1D a, Interval1D b) {
            if      (a.right < b.right) return -1;
            else if (a.right > b.right) return +1;
            else if (a.left  < b.left)  return -1;
            else if (a.left  > b.left)  return +1;
            else                        return  0;
        }
    }

    // ascending order of left endpoint, breaking ties by right endpoint
    private static class LengthComparator implements Comparator<Interval1D> {
        public int compare(Interval1D a, Interval1D b) {
            double alen = a.length();
            double blen = b.length();
            if      (alen < blen) return -1;
            else if (alen > blen) return +1;
            else                  return  0;
        }
    }




    // test client
    public static void main(String[] args) {
        Interval1D[] intervals = new Interval1D[4];
        intervals[0] = new Interval1D(15.0, 33.0);
        intervals[1] = new Interval1D(45.0, 60.0);
        intervals[2] = new Interval1D(20.0, 70.0);
        intervals[3] = new Interval1D(46.0, 55.0);

        StdOut.println("Unsorted");
        for (int i = 0; i < intervals.length; i++)
            StdOut.println(intervals[i]);
        StdOut.println();
        
        StdOut.println("Sort by left endpoint");
        Arrays.sort(intervals, Interval1D.LEFT_ENDPOINT_ORDER);
        for (int i = 0; i < intervals.length; i++)
            StdOut.println(intervals[i]);
        StdOut.println();

        StdOut.println("Sort by right endpoint");
        Arrays.sort(intervals, Interval1D.RIGHT_ENDPOINT_ORDER);
        for (int i = 0; i < intervals.length; i++)
            StdOut.println(intervals[i]);
        StdOut.println();

        StdOut.println("Sort by length");
        Arrays.sort(intervals, Interval1D.LENGTH_ORDER);
        for (int i = 0; i < intervals.length; i++)
            StdOut.println(intervals[i]);
        StdOut.println();
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

