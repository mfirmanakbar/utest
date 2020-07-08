package com.firman.utest.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

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
        assertNull(mock.get(1));
    }

    @Test
    public void returnWithGenericParams() {
        when(mock.get(anyInt())).thenReturn("firman");
        assertEquals("firman", mock.get(0));
        assertEquals("firman", mock.get(1));
    }

    @Test
    public void verificationBasics() {
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        verify(mock).get(0);
        verify(mock).get(1);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        mock.add("SomeString");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        mock.add("SomeString1");
        mock.add("SomeString2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    /**
     * The different between MOCKING and SPYING
     */
    @Test
    public void spying() {

        /**
         * MOCKING
         * */
        ArrayList arrayListMock = mock(ArrayList.class);
        arrayListMock.add("Test0");
        assertNull(arrayListMock.get(0));
        assertEquals(0, arrayListMock.size());
        when(arrayListMock.size()).thenReturn(5);
        assertEquals(5, arrayListMock.size());
        verify(arrayListMock).add("Test0");

        /**
         * SPYING
         * */
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        assertEquals("Test0", arrayListSpy.get(0));
        assertEquals(1, arrayListSpy.size());
        when(arrayListSpy.size()).thenReturn(5);
        assertEquals(5, arrayListSpy.size());
        verify(arrayListSpy).add("Test0");
    }

}
