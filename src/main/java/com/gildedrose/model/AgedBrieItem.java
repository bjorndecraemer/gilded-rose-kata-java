package com.gildedrose.model;

import com.gildedrose.constants.GildedRoseConstants;

public class AgedBrieItem extends GenericStableItem {

    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void passADay() {
        updateSellIn();
        updateQuality();
    }

    private void updateSellIn() {
        sellIn-=1;
    }


    private void updateQuality() {
        // Quality can not go over the defined MAX quality
        if(quality< GildedRoseConstants.DEFAULT_MAX_QUALITY) {
            if(isFresh()){
                quality += 1;
            }
            else{
                quality += 2;
            }
            if(quality > GildedRoseConstants.DEFAULT_MAX_QUALITY) quality = GildedRoseConstants.DEFAULT_MAX_QUALITY;
        }
    }

    private boolean isFresh(){
        return sellIn >= 0;
    }
}
