package com.tom.map;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/23
 */
public class HashMapDemoTest {
    Map<String, Product> productsByName = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        Product eBike = new Product("E-Bike", "A bike with a battery");
        Product roadBike = new Product("Road bike", "A bike for competition");
        productsByName.put(eBike.getName(), eBike);
        productsByName.put(roadBike.getName(), roadBike);
    }

    @Test
    public void create_hashMap() {

    }

    @Test
    public void get_by_key() {
        Product nextPurchase = productsByName.get("E-Bike");
        assertEquals("A bike with a battery", nextPurchase.getDescription());
    }

    @Test
    public void when_null_by_key() {
        Product nextPurchase = productsByName.get("Car");
        assertNull(nextPurchase);
    }

    @Test
    public void get_by_key_update_last_value() {
        Product newEBike = new Product("E-Bike", "A bike with a better battery");
        productsByName.put(newEBike.getName(), newEBike);
        assertEquals("A bike with a better battery", productsByName.get("E-Bike").getDescription());
    }

    @Test
    public void store_null_as_key() {
        Product defaultProduct = new Product("Chocolate", "At least buy chocolate");
        productsByName.put(null, defaultProduct);

        Product nextPurchase = productsByName.get(null);
        assertEquals("At least buy chocolate", nextPurchase.getDescription());
    }

    @Test
    public void store_different_key_with_same_value() {
        Product defaultProduct = new Product("Chocolate", "At least buy chocolate");
        productsByName.put(defaultProduct.getName(), defaultProduct);
        productsByName.put(null, defaultProduct);
        assertSame(productsByName.get(null), productsByName.get("Chocolate"));
    }

    @Test
    public void remove_element() {
        productsByName.remove("E-Bike");
        assertNull(productsByName.get("E-Bike"));
    }

    @Test
    public void check_key_exist_or_not() {
        assertTrue(productsByName.containsKey("E-Bike"));
    }

    @Test
    public void check_value_exist_or_not() {
        Product eBike = new Product("E-Bike", "A bike with a battery");
        assertTrue(productsByName.containsValue(eBike));
    }

    @Test
    public void for_keySet() {
        for (String key : productsByName.keySet()) {
            Product product = productsByName.get(key);
        }
    }

    @Test
    public void for_entrySet() {
        for (Map.Entry<String, Product> entry : productsByName.entrySet()) {
            Product product = entry.getValue();
            String key = entry.getKey();
            //do something with the key and value
        }
    }

    @Test
    public void for_values() {
        List<Product> products = new ArrayList<>(productsByName.values());
        for (Product key : products) {

        }
    }

    @Test
    public void test_key() {
        Product eBike = new Product("E-Bike", "A bike with a battery");
        HashMap<Product, Integer> priceByProduct = new HashMap<>();
        priceByProduct.put(eBike, 900);
    }

    @Test
    public void forEach() {
        productsByName.forEach((key, product) -> {
            System.out.println("Key: " + key + " Product:" + product.getDescription());
            //do something with the key and value
        });
    }

    @Test
    public void entrySet() {
        for (Map.Entry<String, Product> entry : productsByName.entrySet()) {
            Product product = entry.getValue();
            String key = entry.getKey();
            //do something with the key and value
        }
    }

    @Test
    public void getOrDefault() {
        Product chocolate = new Product("chocolate", "something sweet");
        Product defaultProduct = productsByName.getOrDefault("horse carriage", chocolate);
        Product bike = productsByName.getOrDefault("E-Bike", chocolate);
    }

    @Test
    public void getOrDefault_before_java8() {
        Product chocolate = new Product("chocolate", "something sweet");
        Product bike2 = productsByName.containsKey("E-Bike")
                ? productsByName.get("E-Bike")
                : chocolate;
        Product defaultProduct2 = productsByName.containsKey("horse carriage")
                ? productsByName.get("horse carriage")
                : chocolate;
    }

    @Test
    public void putIfAbsent() {
        Product chocolate = new Product("chocolate", "something sweet");
        productsByName.putIfAbsent("E-Bike", chocolate);
    }

    @Test
    public void putIfAbsent_before_java8() {
        Product chocolate = new Product("chocolate", "something sweet");
        if (!productsByName.containsKey("E-Bike")) {
            productsByName.put("E-Bike", chocolate);
        }
    }

    @Test
    public void merge() {
        Product eBike2 = new Product("E-Bike", "A bike with a battery");
        eBike2.getTags().add("sport");
        productsByName.merge("E-Bike", eBike2, Product::addTagsOfOtherProdcut);
    }

    @Test
    public void merge_before_java8() {
        Product eBike2 = new Product("E-Bike", "A bike with a battery");
        if (productsByName.containsKey("E-Bike")) {
            productsByName.get("E-Bike").addTagsOfOtherProdcut(eBike2);
        } else {
            productsByName.put("E-Bike", eBike2);
        }
    }

    @Test
    public void compute() {
        Product eBike2 = new Product("E-Bike", "A bike with a battery");
        productsByName.compute("E-Bike", (k, v) -> {
            if (v != null) {
                return v.addTagsOfOtherProdcut(eBike2);
            } else {
                return eBike2;
            }
        });
    }

    @Test
    public void compute_before_java8() {
        Product eBike2 = new Product("E-Bike", "A bike with a battery");
        if (productsByName.containsKey("E-Bike")) {
            productsByName.get("E-Bike").addTagsOfOtherProdcut(eBike2);
        } else {
            productsByName.put("E-Bike", eBike2);
        }
    }
}