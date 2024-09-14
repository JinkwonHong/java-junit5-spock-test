package com.fastcampus.javajunit5.filter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LIstFilterTest {
    private static ListFilter filter;
    private static List<Integer> target;

    @BeforeAll
    static void setup() {
        filter = new ListFilter();
        target = new ArrayList<>();
        createMockData();
    }

    private static void createMockData() {
        for (int i = 0; i < 100; i++) {
            target.add(i + 1);
        }
    }

    @Test
    void filterBy() {
        //given
        int from = 10;
        int to = 20;

        int expectedSize = to - from - 1;

        //when
        List<Integer> result = filter.filterBy(target, from, to);

        //then
        assertEquals(expectedSize, result.size());
    }

    @Test
    void filterFailedWhenFromIsGreaterThanTo() {
        //given
        int from = 20;
        int to = 10;

        //when && then
        assertThrows(RuntimeException.class, () -> {
            filter.filterBy(target, from, to);
        });
    }
}