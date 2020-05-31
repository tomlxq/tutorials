package com.tom.store;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
public class Store {
    @Autowired
    private Item item;
    public Store(Item item) {
        this.item = item;
    }
}
