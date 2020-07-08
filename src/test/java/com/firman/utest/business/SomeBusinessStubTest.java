package com.firman.utest.business;

import com.firman.utest.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements SomeDataService {
    @Override
    public int[] retriveAllData() {
        return new int[]{1, 2, 3};
    }
}

class SomeDataServiceEmptyStub implements SomeDataService {
    @Override
    public int[] retriveAllData() {
        return new int[]{};
    }
}

class SomeDataServiceOneValueStub implements SomeDataService {
    @Override
    public int[] retriveAllData() {
        return new int[]{5};
    }
}

public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actual = business.calculateSumUsingDataService();
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceEmptyStub());
        int actual = business.calculateSumUsingDataService();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceOneValueStub());
        int actual = business.calculateSumUsingDataService();
        int expected = 5;
        assertEquals(expected, actual);
    }

}
