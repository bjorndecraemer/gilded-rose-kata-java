package com.gildedrose.model;

public class GenericStableItem extends Item {

    public GenericStableItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    // Default implementation, does nothing
    public void passADay(){
    }
}
