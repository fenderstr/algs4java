package edu.princeton.cs.algs4;
import  edu.princeton.cs.introcs.*;

/*************************************************************************
 *  Compilation:  javac RandomSeq.java
 *  Execution:    java RandomSeq N lo hi
 *
 *  Prints N numbers between lo and hi.
 *
 *  % java RandomSeq 5 100.0 200.0
 *  123.43
 *  153.13
 *  144.38
 *  155.18
 *  104.02
 *
 *************************************************************************/

public class RandomSeq { 
    public static void main(String[] args) {

        // command-line arguments
        int N = Integer.parseInt(args[0]);

        if (args.length == 1) {
            // generate and print N numbers between 0.0 and 1.0
            for (int i = 0; i < N; i++) {
                double x = StdRandom.uniform();
                StdOut.println(x);
            }
        }

        else if (args.length == 3) {
            double lo = Double.parseDouble(args[1]);
            double hi = Double.parseDouble(args[2]);

            // generate and print N numbers between lo and hi
            for (int i = 0; i < N; i++) {
                double x = StdRandom.uniform(lo, hi);
                StdOut.printf("%.2f\n", x);
            }
        }

        else {
            throw new RuntimeException("Invalid number of arguments");
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

