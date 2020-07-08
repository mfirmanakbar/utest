package com.firman.utest.business;

import com.firman.utest.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {

    public Item retreivedHardCodedItem() {
        return new Item(1, "Ball", 4025, 10);
    }

}
