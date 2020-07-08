package com.firman.utest.business;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListMockTest {

    List mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDiffValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParams() {
        when(mock.get(0)).thenReturn("firman");
        assertEquals("firman", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void returnWithGenericParams() {
        when(mock.get(anyInt())).thenReturn("firman");
        assertEquals("firman", mock.get(0));
        assertEquals("firman", mock.get(1));
    }

}
