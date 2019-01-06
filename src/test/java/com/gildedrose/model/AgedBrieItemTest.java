package com.gildedrose.model;

import com.gildedrose.constants.GildedRoseConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieItemTest {

    @Test
    public void passADay_Item_Name_Remains_Same() throws Exception {
        String originalName = "Aged Brie";
        AgedBrieItem agedBrieItem = new AgedBrieItem(originalName,10,10);
        agedBrieItem.passADay();
        assertEquals(originalName, agedBrieItem.name);
    }

    @Test
    void passADay_SellInn_Decreases_By_One() {
        int originalSellIn = 5;
        AgedBrieItem agedBrieItem = new AgedBrieItem("Aged Brie",originalSellIn,10);
        agedBrieItem.passADay();
        assertEquals(originalSellIn-1,agedBrieItem.sellIn);
    }

    @Test
    void passADay_SellInn_Can_Become_Negative() {
        int originalSellIn = 0;
        AgedBrieItem agedBrieItem = new AgedBrieItem("Aged Brie",originalSellIn,10);
        agedBrieItem.passADay();
        assertEquals(originalSellIn-1,agedBrieItem.sellIn);
    }

    @Test
    void passADay_Quality_Increases_By_1_WHILE_ITEM_IS_NOT_EXPIRED() {
        int originalQuality = 8;
        AgedBrieItem agedBrieSellTodayItem = new AgedBrieItem("Aged Brie",1,originalQuality);
        AgedBrieItem agedBrieVeryFreshItem = new AgedBrieItem("Aged Brie",6,originalQuality);
        agedBrieSellTodayItem.passADay();
        agedBrieVeryFreshItem.passADay();
        assertEquals(originalQuality+1,agedBrieSellTodayItem.quality);
        assertEquals(originalQuality+1,agedBrieVeryFreshItem.quality);
    }

    @Test
    void passADay_Quality_Increases_By_2_When_Item_Is_Expired() {
        int originalQuality = 8;
        AgedBrieItem agedBrieItem = new AgedBrieItem("Aged Brie",0,originalQuality);
        agedBrieItem.passADay();
        assertEquals(originalQuality+2,agedBrieItem.quality);
    }

    @Test
    void passADay_Quality_Can_Not_Become_More_Than_MAX_QUALITY() {
        int originalQuality = GildedRoseConstants.DEFAULT_MAX_QUALITY;
        AgedBrieItem agedBrieItem = new AgedBrieItem("Aged Brie",5,originalQuality);
        agedBrieItem.passADay();
        assertEquals(GildedRoseConstants.DEFAULT_MAX_QUALITY,agedBrieItem.quality);
    }
}