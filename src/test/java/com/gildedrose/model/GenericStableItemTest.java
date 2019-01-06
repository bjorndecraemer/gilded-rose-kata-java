package com.gildedrose.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericStableItemTest {

    private GenericStableItem genericStableItem;

    @BeforeEach
    void setUp() {
        genericStableItem = new GenericStableItem("Sulfuras, Hand of Floki", 5, 6);
    }

    @Test
    public void passADay_Item_Name_Remains_Same(){
        String originalName = genericStableItem.name;
        genericStableItem.passADay();
        assertEquals(originalName, genericStableItem.name);
    }

    @Test
    void passADay_Should_Not_Change_SellIn() {
        int originalSellIn = genericStableItem.sellIn;
        genericStableItem.passADay();
        assertEquals(originalSellIn, genericStableItem.sellIn);
    }

    @Test
    void passADay_Should_Not_Change_Quality() {
        int originalQuality = genericStableItem.quality;
        genericStableItem.passADay();
        assertEquals(originalQuality, genericStableItem.quality);
    }
}