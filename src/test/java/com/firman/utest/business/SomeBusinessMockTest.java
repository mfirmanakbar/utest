package com.firman.utest.business;

import com.firman.utest.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SomeBusinessMockTest {

    SomeBusinessImpl business = new SomeBusinessImpl();
    SomeDataService dataServiceMock = mock(SomeDataService.class);

    @BeforeEach
    public void before() {
        business.setSomeDataService(dataServiceMock);
    }

    @Test
    public void calculateSumUsingDataService_basic() {
        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{1, 2, 3});
        //business.setSomeDataService(dataServiceMock); // we already using it on @BeforeEach

        assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{});
        //business.setSomeDataService(dataServiceMock); // we already using it on @BeforeEach

        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{5});
        //business.setSomeDataService(dataServiceMock); // we already using it on @BeforeEach

        assertEquals(5, business.calculateSumUsingDataService());
    }

}
