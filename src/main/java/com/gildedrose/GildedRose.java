package com.gildedrose;

import com.gildedrose.exceptions.InvalidGildedRoseConfigurationException;
import com.gildedrose.exceptions.InvalidItemConfigurationException;
import com.gildedrose.model.factory.ItemFactory;
import com.gildedrose.model.GenericStableItem;
import com.gildedrose.model.Item;
import lombok.Getter;

import java.util.ArrayList;

class GildedRose {

    @Getter
    private ArrayList<GenericStableItem> allItemsList;

    /**
     * Constructor to be used with an Array of {@link Item}
     * The constructor will compose the allItemsList ArrayList with the appropriate {@link GenericStableItem}
     * child class based on the item names
     * @param items
     * @throws InvalidItemConfigurationException
     * @throws InvalidGildedRoseConfigurationException
     */
    public GildedRose(Item[] items)throws InvalidItemConfigurationException, InvalidGildedRoseConfigurationException {
        if(items == null || items.length == 0){
            throw new InvalidGildedRoseConfigurationException("Gilded Rose constructor called with an item Array which is null or empty");
        }
        allItemsList = new ArrayList<>(items.length);
        for(Item item : items){
            allItemsList.add(ItemFactory.getSpecificItem(item.name,item.sellIn,item.quality));
        }
    }


    /**
     * Constructor to be used with an ArrayList of {@link GenericStableItem} subClasses
     * This constructor should only be used if you have already instantiated all elements with the correct Child Class.
     * @param items
     * @throws InvalidItemConfigurationException
     * @throws InvalidGildedRoseConfigurationException
     */
    public GildedRose(ArrayList<GenericStableItem> items)throws InvalidGildedRoseConfigurationException {
        if(items == null || items.isEmpty()){
            throw new InvalidGildedRoseConfigurationException("Gilded Rose constructor called with an item ArrayList which is null or empty");
        }
        this.allItemsList = items;
    }

    public void updateQuality(){
        for(GenericStableItem item : this.getAllItemsList()){
            item.passADay();
        }
    }
}