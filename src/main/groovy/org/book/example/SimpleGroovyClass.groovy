package org.book.example
/**
 *
 *
 * @author ANosov
 */
class SimpleGroovyClass {

    String concatenateAll(char separator, String... args) {
        args.join(separator as String)
    }
}
