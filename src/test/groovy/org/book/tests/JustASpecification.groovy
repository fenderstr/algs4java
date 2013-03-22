package org.book.tests

import org.book.chapter1.SimpleJavaClass
import org.book.example.SimpleGroovyClass
import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 *
 * @author ANosov
 */
class JustASpecification  extends Specification {

    @Unroll('Sums integers #integers into: #expectedResult')
    def "Can sum different amount of integers"() {

        given:
            def instance = new SimpleJavaClass()

        when:
            def result = instance.sumAll(* integers)

        then:
            result == expectedResult

        where:
            expectedResult | integers
            11             | [3, 3, 5]
            8              | [3, 5]
            254            | [2, 4, 8, 16, 32, 64, 128]
            22             | [7, 5, 6, 2, 2]
    }

    @Unroll('Concatenates strings #strings with separator "#separator" into: #expectedResult')
    def "Can concatenate different amount of integers with a specified separator"() {

        given:
            def instance = new SimpleGroovyClass()

        when:
            def result = instance.concatenateAll(separator, * strings)

        then:
            result == expectedResult

        where:
            expectedResult     | separator   | strings
            'Whasup dude?'     | ' ' as char | ['Whasup', 'dude?']
            '2012/09/15'       | '/' as char | ['2012', '09', '15']
            'nice-to-meet-you' | '-' as char | ['nice', 'to', 'meet', 'you']
    }
}
