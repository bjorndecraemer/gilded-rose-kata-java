package com.gildedrose;

import com.gildedrose.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GildedRoseTest {

    GildedRose defaultApp;
    Item[] items;

    @BeforeEach
    void setUp() throws Exception{
        items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };
        defaultApp = new GildedRose(items);
    }

    @Test
    public void constructor_All_Item_Names_Remain_Same() {
        for (int i = 0; i < items.length; i++) {
            assertEquals(items[0].name, defaultApp.getAllItemsList().get(0).name);
        }
    }

    @Test
    public void constructor_Item_Count_Remains_Same() {
        assertEquals(items.length, defaultApp.getAllItemsList().size());
    }


}
