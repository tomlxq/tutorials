package com.tom.sampleapp.web.dto;

public class TomItem {
    private final String itemId;

    public TomItem(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }
}
