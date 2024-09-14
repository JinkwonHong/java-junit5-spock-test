package com.fastcampus.javajunit5.filter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LIstFilterTest {

    @Test
    void filterBy() {
        //given
        ListFilter filter = new ListFilter();

        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            target.add(i + 1);
        }

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
        ListFilter filter = new ListFilter();

        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            target.add(i + 1);
        }

        int from = 20;
        int to = 10;

        //when && then
        assertThrows(RuntimeException.class, () -> {
            filter.filterBy(target, from, to);
        });
    }
}