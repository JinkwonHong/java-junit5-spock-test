package com.fastcampus.javajunit5.filter

import spock.lang.Specification

class ListFilterTestSpock extends Specification {
    def "filterBy"() {
        given:
        def filter = new ListFilter()
        def target = []
        for (int i = 1; i <= 100; i++) {
            target.add(i)
        }
        def from = 10
        def to = 20
        def expectedSize = to - from - 1

        when:
        def actual = filter.filterBy(target, from, to)

        then:
        expectedSize == actual.size()
    }

    def "filterFailedWhenFromIsGreaterThanTo"() {
        given:
        def filter = new ListFilter()
        def target = []
        for (int i = 1; i <= 100; i++) {
            target.add(i)
        }
        def from = 20
        def to = 10

        when:
        def actual = filter.filterBy(target, from, to)

        then:
        thrown(RuntimeException.class)
    }
}
