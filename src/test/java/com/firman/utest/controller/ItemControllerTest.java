package com.firman.utest.controller;

import com.firman.utest.business.ItemBusinessService;
import com.firman.utest.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void dummyItem_basic() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":4025,\"quantity\":10}"))
                .andReturn();

    }

    @Test
    public void itemFromBusinessService_basic() throws Exception {

        when(businessService.retreivedHardCodedItem()).thenReturn(new Item(2, "Mac Book Pro", 15000000, 20));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/items-hard-coded")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2,\"name\":\"Mac Book Pro\",\"price\":15000000,\"quantity\":20}"))
                .andReturn();

    }

    @Test
    public void retrieveItems_basic() throws Exception {

        when(businessService.retrieveItems())
                .thenReturn(Arrays.asList(
                        new Item(1, "Item1", 1000, 10),
                        new Item(2, "Item2", 2000, 20)
                ));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/items")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1,name:Item1,price:1000,quantity:10},{id:2,name:Item2,price:2000,quantity:20}]"))
                .andReturn();

    }

}
