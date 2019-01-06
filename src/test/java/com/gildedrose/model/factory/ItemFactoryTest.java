package com.gildedrose.model.factory;

import com.gildedrose.exceptions.InvalidItemConfigurationException;
import com.gildedrose.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemFactoryTest {


    @Test
    void correct_generation_of_default_item() throws Exception {
        Item givenItem = new Item("+5 Dexterity Vest", 10, 20);

        GenericStableItem generatedItem = ItemFactory.getSpecificItem(givenItem);

        assertEquals(givenItem.name,generatedItem.name);
        assertEquals(givenItem.sellIn,generatedItem.sellIn);
        assertEquals(givenItem.quality,generatedItem.quality);
        assertEquals(generatedItem.getClass(),DefaultItem.class);
    }

    @Test
    void correct_generation_of_aged_brie_item()  throws Exception {
        Item givenItem = new Item("Aged Brie", 10, 20);

        GenericStableItem generatedItem = ItemFactory.getSpecificItem(givenItem);

        assertEquals(givenItem.name,generatedItem.name);
        assertEquals(givenItem.sellIn,generatedItem.sellIn);
        assertEquals(givenItem.quality,generatedItem.quality);
        assertEquals(generatedItem.getClass(), AgedBrieItem.class);
    }

    @Test
    void correct_generation_of_sulfuras_item() throws Exception {
        Item givenItem = new Item("Sulfuras, Hand of Ragnaros", 10, 20);

        GenericStableItem generatedItem = ItemFactory.getSpecificItem(givenItem);

        assertEquals(givenItem.name,generatedItem.name);
        assertEquals(givenItem.sellIn,generatedItem.sellIn);
        assertEquals(givenItem.quality,generatedItem.quality);
        assertEquals(generatedItem.getClass(), GenericStableItem.class);
    }

    @Test
    void correct_generation_of_backstage_item() throws Exception {
        Item givenItem = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);

        GenericStableItem generatedItem = ItemFactory.getSpecificItem(givenItem);

        assertEquals(givenItem.name,generatedItem.name);
        assertEquals(givenItem.sellIn,generatedItem.sellIn);
        assertEquals(givenItem.quality,generatedItem.quality);
        assertEquals(generatedItem.getClass(), BackstagePassItem.class);
    }

    @Test
    void correct_generation_of_conjured_item() throws Exception {
        Item givenItem = new Item("Conjured mana cake", 10, 20);

        GenericStableItem generatedItem = ItemFactory.getSpecificItem(givenItem);

        assertEquals(givenItem.name,generatedItem.name);
        assertEquals(givenItem.sellIn,generatedItem.sellIn);
        assertEquals(givenItem.quality,generatedItem.quality);
        assertEquals(generatedItem.getClass(), ConjuredItem.class);
    }

    @Test
    void should_throw_Invalid_Config_Exception_On_Empty_Or_Null_Name() throws Exception{
        Item givenItemNullName = new Item(null, 10, 20);
        assertThrows(InvalidItemConfigurationException.class,() -> ItemFactory.getSpecificItem(givenItemNullName));
        Item givenItemEmptyName = new Item("", 10, 20);
        assertThrows(InvalidItemConfigurationException.class,() -> ItemFactory.getSpecificItem(givenItemEmptyName));
    }

    @Test
    void should_throw_Invalid_Config_Exception_On_Negative_Quality() throws Exception{
        Item givenItemNegativeQuality = new Item("foo", 10, -1);
        assertThrows(InvalidItemConfigurationException.class,() -> ItemFactory.getSpecificItem(givenItemNegativeQuality));
    }
}