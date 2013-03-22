package edu.princeton.cs.algs4;
import  edu.princeton.cs.introcs.*;

/*************************************************************************
 *  Compilation:  javac SuffixArray.java
 *  Execution:    java SuffixArray < input.txt
 *  
 *  A data type that computes the suffix array of a string.
 *
 *  % java SuffixArray < abra.txt 
 *    i ind lcp rnk  select
 *  ---------------------------
 *    0  11   -   0  !
 *    1  10   0   1  A!
 *    2   7   1   2  ABRA!
 *    3   0   4   3  ABRACADABRA!
 *    4   3   1   4  ACADABRA!
 *    5   5   1   5  ADABRA!
 *    6   8   0   6  BRA!
 *    7   1   3   7  BRACADABRA!
 *    8   4   0   8  CADABRA!
 *    9   6   0   9  DABRA!
 *   10   9   0  10  RA!
 *   11   2   2  11  RACADABRA!
 *
 *************************************************************************/

import java.util.Arrays;

public class SuffixArray {
    private final String[] suffixes;
    private final int N;

    public SuffixArray(String s) {
        N = s.length();
        suffixes = new String[N];
        for (int i = 0; i < N; i++)
            suffixes[i] = s.substring(i);
        Arrays.sort(suffixes);
    }

    // size of string
    public int length() { return N; }

    // index of ith sorted suffix
    public int index(int i) { return N - suffixes[i].length(); }

    // ith sorted suffix
    public String select(int i) { return suffixes[i]; }

    // number of suffixes strictly less than query
    public int rank(String query) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = query.compareTo(suffixes[mid]);
            if      (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    } 

   // length of longest common prefix of s and t
    private static int lcp(String s, String t) {
        int N = Math.min(s.length(), t.length());
        for (int i = 0; i < N; i++)
            if (s.charAt(i) != t.charAt(i)) return i;
        return N;
    }

    // longest common prefix of suffixes(i) and suffixes(i-1)
    public int lcp(int i) {
        return lcp(suffixes[i], suffixes[i-1]);
    }

    // longest common prefix of suffixes(i) and suffixes(j)
    public int lcp(int i, int j) {
        return lcp(suffixes[i], suffixes[j]);
    }




    public static void main(String[] args) {
        String s = StdIn.readAll().trim();
        SuffixArray suffix = new SuffixArray(s);

        StdOut.println("  i ind lcp rnk  select");
        StdOut.println("---------------------------");
        StdOut.printf("%3d %3d %3s %3d  %s\n",
                0, suffix.index(0), "-", suffix.rank(suffix.select(0)), suffix.select(0));
        for (int i = 1; i < s.length(); i++) {
            int index = suffix.index(i);
            String ith = suffix.select(i);
            int lcp = suffix.lcp(i, i-1);
            int rank = suffix.rank(ith);
            StdOut.printf("%3d %3d %3d %3d  %s\n", i, index, lcp, rank, ith);
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

