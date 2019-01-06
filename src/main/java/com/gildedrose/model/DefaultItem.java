package com.gildedrose.model;

import com.gildedrose.constants.GildedRoseConstants;

public final class DefaultItem extends GenericStableItem {

    public DefaultItem(String name, int sellIn, int quality) {
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

    void updateQuality() {
        if(quality > 0){
            if(isFresh()){
                quality -= 1;
            }
            else{
                quality -= 2;
            }
            // If this would drop quality below 0
            if(quality < 0){
                quality = 0;
            }
        }
    }

    private boolean isFresh(){
        return sellIn >= 0;
    }
}
