package com.gildedrose.model.factory;

import com.gildedrose.constants.GildedRoseConstants;
import com.gildedrose.exceptions.InvalidItemConfigurationException;
import com.gildedrose.model.*;

public class ItemFactory {


    public static GenericStableItem getSpecificItem(Item item) throws InvalidItemConfigurationException{
        if(item == null){
            throw new InvalidItemConfigurationException("Null Item specified");
        }
        return getSpecificItem(item.name,item.sellIn,item.quality);
    }

    public static GenericStableItem getSpecificItem(String itemName, int sellIn, int quality) throws InvalidItemConfigurationException {

        // First check for invalid configurations
        if(quality < 0){
            throw new InvalidItemConfigurationException("Invalid quality given : "+quality+" < 0");
        }
        if(itemName == null || itemName.length() == 0){
            throw new InvalidItemConfigurationException("Empty name specified");
        }

        if(itemName.equals(GildedRoseConstants.AGED_BRIE_NAME)){
            return new AgedBrieItem(itemName,sellIn,quality);
        }
        if(itemName.startsWith(GildedRoseConstants.BACKSTAGE_PASSES_PREFIX)){
            return new BackstagePassItem(itemName,sellIn,quality);
        }
        if(itemName.startsWith(GildedRoseConstants.CONJURED_PREFIX)){
            return new ConjuredItem(itemName,sellIn,quality);
        }
        if(itemName.equals(GildedRoseConstants.SULFURAS_NAME)){
            return new GenericStableItem(itemName,sellIn,quality);
        }
        // Not a "special" item, defaulting to a DefaultItem
        return new DefaultItem(itemName,sellIn,quality);

    }
}
