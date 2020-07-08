package com.firman.utest.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SomeBusinessImplTest {

    @Test
    public void calculateSum() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actual = business.calculateSum(new int[]{1, 2, 3});
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actual = business.calculateSum(new int[]{});
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actual = business.calculateSum(new int[]{5});
        int expected = 5;
        assertEquals(expected, actual);
    }

}
