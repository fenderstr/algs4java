package org.book.chapter1;

/**
 * @author root
 */
public class SimpleJavaClass {

    public int sumAll(int... args) {

        int sum = 0;

        for (int arg : args){
            sum += arg;
        }

        return sum;
    }
}
