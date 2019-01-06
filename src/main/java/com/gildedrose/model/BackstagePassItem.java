package com.gildedrose.model;

import com.gildedrose.constants.GildedRoseConstants;

public class BackstagePassItem extends GenericStableItem {

    public BackstagePassItem(String name, int sellIn, int quality) {
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
        if(sellIn<0){
            quality = GildedRoseConstants.MIN_QUALITY;
        }
        else{
            if(sellIn > 10){
                quality+=1;
            }
            else if(sellIn > 5){
                quality+=2;
            }
            else{
                quality+=3;
            }
            if(quality> GildedRoseConstants.DEFAULT_MAX_QUALITY) quality = GildedRoseConstants.DEFAULT_MAX_QUALITY;
        }
    }
}
