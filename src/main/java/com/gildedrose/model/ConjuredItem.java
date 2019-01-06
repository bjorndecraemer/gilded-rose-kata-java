package com.gildedrose.model;

public class ConjuredItem extends GenericStableItem {

    public ConjuredItem(String name, int sellIn, int quality) {
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
        if(quality > 0){
            if(isFresh()){
                quality -= 2;
            }
            else{
                quality = quality-4;
            }
            // If this would drop quality below 0
            if(quality<0){
                quality = 0;
            }
        }
    }

    private boolean isFresh(){
        return sellIn >= 0;
    }
}
