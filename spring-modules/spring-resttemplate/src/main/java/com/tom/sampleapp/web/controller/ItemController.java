package com.tom.sampleapp.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.tom.sampleapp.web.dto.Item;
import com.tom.sampleapp.web.dto.ItemManager;
import com.tom.sampleapp.web.dto.Views;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ItemController {

    @JsonView(Views.Public.class)
    @RequestMapping("/items/{id}")
    public Item getItemPublic(@PathVariable final int id) {
        return ItemManager.getById(id);
    }

    @JsonView(Views.Internal.class)
    @RequestMapping("/items/internal/{id}")
    public Item getItemInternal(@PathVariable final int id) {
        return ItemManager.getById(id);
    }

    @RequestMapping("/date")
    public Date getCurrentDate() throws Exception {
        return new Date();
    }

    @RequestMapping("/delay/{seconds}")
    public void getCurrentTime(@PathVariable final int seconds) throws Exception {

        Thread.sleep(seconds * 1000);
    }
}