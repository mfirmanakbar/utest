package com.firman.utest.business;

import com.firman.utest.data.ItemRepository;
import com.firman.utest.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService business;

    @Mock
    private ItemRepository repository;

    @Test
    public void calculateSumUsingDataService_basic() {
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Item(1, "Item1", 1000, 10),
                new Item(2, "Item2", 2000, 20)
        ));
        List<Item> items = business.retrieveItems();
        assertEquals(10000, items.get(0).getValue(), 10000);
        assertEquals(40000, items.get(1).getValue());
    }

}
