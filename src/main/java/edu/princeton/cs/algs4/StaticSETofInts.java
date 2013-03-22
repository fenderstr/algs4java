package edu.princeton.cs.algs4;
import  edu.princeton.cs.introcs.*;

/*************************************************************************
 *  Compilation:  javac StaticSetOfInts.java
 *  
 *  Data type to store a set of integers.
 *
 *************************************************************************/

import java.util.Arrays;

public class StaticSETofInts {
    private int[] a;
    public StaticSETofInts(int[] keys) {
        // defensive copy
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++)
            a[i] = keys[i];

        Arrays.sort(a);

        // probably should check that no duplicates
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    // Binary search.
    public int rank(int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
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

