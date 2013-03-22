package edu.princeton.cs.algs4;
import  edu.princeton.cs.introcs.*;

/*************************************************************************
 *  Compilation:  javac SequentialSearchST.java
 *  Execution:    java SequentialSearchST
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/31elementary/tinyST.txt  
 *  
 *  Symbol table implementation with sequential search in an
 *  unordered linked list of key-value pairs.
 *
 *  % more tinyST.txt
 *  S E A R C H E X A M P L E
 *
 *  % java SequentialSearchST < tiny.txt 
 *  L 11
 *  P 10
 *  M 9
 *  X 7
 *  H 5
 *  C 4
 *  R 3
 *  A 8
 *  E 12
 *  S 0
 *
 *************************************************************************/

public class SequentialSearchST<Key, Value> {
    private int N;           // number of key-value pairs
    private Node first;      // the linked list of key-value pairs

    // a helper linked list data type
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    // return number of key-value pairs
    public int size() { return N; }

    // is the symbol table empty?
    public boolean isEmpty() { return size() == 0; }

    // does this symbol table contain the given key?
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // return the value associated with the key, or null if the key is not present
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    // add a key-value pair, replacing old key-value pair if key is already present
    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) { x.val = val; return; }
        first = new Node(key, val, first);
        N++;
    }

    // remove key-value pair with given key (if it's in the table)
    public void delete(Key key) {
        first = delete(first, key);
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) { N--; return x.next; }
        x.next = delete(x.next, key);
        return x;
    }


    // return all keys as an Iterable
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }




   /***********************************************************************
    * Test client
    **********************************************************************/
    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
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

