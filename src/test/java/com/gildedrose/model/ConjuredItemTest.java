package com.gildedrose.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConjuredItemTest {


    @Test
    public void passADay_Item_Name_Remains_Same(){
        String originalName = "Conjured wand";
        ConjuredItem conjuredItem = new ConjuredItem(originalName,10,10);
        conjuredItem.passADay();
        assertEquals(originalName, conjuredItem.name);
    }
    @Test
    void passADay_SellInn_Decreases_By_One() {
        int originalSellIn = 5;
        ConjuredItem conjuredItem = new ConjuredItem("Conjured wand",originalSellIn,10);
        conjuredItem.passADay();
        assertEquals(originalSellIn-1,conjuredItem.sellIn);
    }

    @Test
    void passADay_SellInn_Can_Become_Negative() {
        int originalSellIn = 0;
        ConjuredItem conjuredItem = new ConjuredItem("Conjured wand",originalSellIn,10);
        conjuredItem.passADay();
        assertEquals(originalSellIn-1,conjuredItem.sellIn);
    }
    @Test
    void passDay_Quality_Diminishes_By_2_While_Sellin_Remains_Gigger_Or_Equal_To_0(){
        int origQuality = 10;
        ConjuredItem conjuredVeryFreshItem = new ConjuredItem("Conjured wand",4,10);
        ConjuredItem conjuredSellTodayItem = new ConjuredItem("Conjured wand",1,10);

        conjuredVeryFreshItem.passADay();
        conjuredSellTodayItem.passADay();
        assertEquals(origQuality-2,conjuredVeryFreshItem.quality);
        assertEquals(origQuality-2,conjuredSellTodayItem.quality);
    }

    @Test
    void passDay_Quality_Diminishes_By_4_While_Sellin_Reaches_Negative(){
        int originalSellIn = 0;
        ConjuredItem conjuredItem = new ConjuredItem("Conjured wand",originalSellIn,10);
        int origQuality = conjuredItem.quality;
        conjuredItem.passADay();
        assertEquals(origQuality-4,conjuredItem.quality);
    }
    @Test
    void passDay_Quality_Can_Not_Go_Below_0(){
        ConjuredItem twoQualitySellInNegativeItem = new ConjuredItem("Conjured Wand",-2,2);
        ConjuredItem oneQualitySellInZeroItem = new ConjuredItem("Conjured Wand",0,1);
        ConjuredItem zeroQualitySellInLargerThanZeroItem = new ConjuredItem("Conjured Wand",2,0);
        twoQualitySellInNegativeItem.passADay();
        zeroQualitySellInLargerThanZeroItem.passADay();
        oneQualitySellInZeroItem.passADay();
        assertEquals(0,twoQualitySellInNegativeItem.quality);
        assertEquals(0,oneQualitySellInZeroItem.quality);
        assertEquals(0,zeroQualitySellInLargerThanZeroItem.quality);
    }
}