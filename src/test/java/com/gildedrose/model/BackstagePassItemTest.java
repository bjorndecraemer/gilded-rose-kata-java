package com.gildedrose.model;

import com.gildedrose.constants.GildedRoseConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassItemTest {

    @Test
    public void passADay_Item_Name_Remains_Same() throws Exception {
        String originalName = "Backstage passes to a TAFKAL80ETC concert";
        BackstagePassItem backstagePassItem = new BackstagePassItem(originalName,10,10);
        backstagePassItem.passADay();
        assertEquals(originalName, backstagePassItem.name);
    }

    @Test
    void passDay_SellIn_Data_Should_Decrease_By_1(){
        int origSellIn = 4;
        BackstagePassItem backstagePassItem = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert",origSellIn,10);
        backstagePassItem.passADay();
        assertEquals(origSellIn-1,backstagePassItem.sellIn);
    }
    @Test
    void passDay_SellIn_Can_Become_Negative(){
        int origSellIn = 0;
        BackstagePassItem backstagePassItem = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert",origSellIn,10);
        backstagePassItem.passADay();
        assertEquals(origSellIn-1,backstagePassItem.sellIn);
    }
    @Test
    void passDay_Quality_Increases_By_One_While_Sellin_Larger_Than_10(){
        int origSellIn = 12;
        int origQuality = 10;
        BackstagePassItem backstagePassItem = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert",origSellIn,origQuality);
        backstagePassItem.passADay();
        assertEquals(origQuality+1,backstagePassItem.quality);
    }
    @Test
    void passDay_Quality_Increases_By_Two_While_Sellin_Between_10_And_6Included(){
        int origSellIn1 = 11;
        int origSellIn2 = 7;
        int origQuality = 10;
        BackstagePassItem backstagePassItem1 = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert",origSellIn1,origQuality);
        BackstagePassItem backstagePassItem2 = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert",origSellIn2,origQuality);
        backstagePassItem1.passADay();
        backstagePassItem2.passADay();
        assertEquals(origQuality+2,backstagePassItem1.quality);
        assertEquals(origQuality+2,backstagePassItem2.quality);
    }
    @Test
    void passDay_Quality_Increases_By_Three_While_Sellin_Between_5_And_0Included(){
        int origSellIn1 = 6;
        int origSellIn2 = 1;
        int origQuality = 10;
        BackstagePassItem backstagePassItem1 = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert",origSellIn1,origQuality);
        BackstagePassItem backstagePassItem2 = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert",origSellIn2,origQuality);
        backstagePassItem1.passADay();
        backstagePassItem2.passADay();
        assertEquals(origQuality+3,backstagePassItem1.quality);
        assertEquals(origQuality+3,backstagePassItem2.quality);
    }
    @Test
    void passDay_Quality_Becomes_0_When_SellIn_Becomes_Negative(){
        int origSellIn = 0;
        int origQuality = 10;
        BackstagePassItem backstagePassItem = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert",origSellIn,origQuality);
        backstagePassItem.passADay();
        assertEquals(0,backstagePassItem.quality);
    }
    @Test
    void passADay_Quality_Can_Not_Become_More_Than_MAX_QUALITY(){
        int origSellIn = 3;
        int origQuality = GildedRoseConstants.DEFAULT_MAX_QUALITY;
        BackstagePassItem backstagePassItem = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert",origSellIn,origQuality);
        backstagePassItem.passADay();
        assertEquals(GildedRoseConstants.DEFAULT_MAX_QUALITY,backstagePassItem.quality);
    }
}