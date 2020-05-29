package com.tom.collection;

/**
 * Created by Gebruiker on 5/22/2018.
 */
public class TomBean {

    private String name;

    public TomBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
