package com.firman.utest.business;

import com.firman.utest.data.ItemRepository;
import com.firman.utest.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retreivedHardCodedItem() {
        return new Item(1, "Ball", 4025, 10);
    }

    public List<Item> retrieveItems() {
        List<Item> items = itemRepository.findAll();
        for (Item item : items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }

}
