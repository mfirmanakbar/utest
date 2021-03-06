package com.firman.utest.controller;

import com.firman.utest.business.ItemBusinessService;
import com.firman.utest.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 4025, 10);
    }

    @GetMapping("/items-hard-coded")
    public Item itemFromBusinessService() {
        return itemBusinessService.retreivedHardCodedItem();
    }

    @GetMapping("/items")
    public List<Item> retrieveItems() {
        return itemBusinessService.retrieveItems();
    }

}
