package com.gildedrose.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultItemTest {

    private DefaultItem defaultItemSellinLargerThanZero;
    private DefaultItem defaultItemSellinEqualToZero;
    private DefaultItem defaultItemSellinEqualTo1;
    private DefaultItem defaultItemSellinLowerThanZero;

    @BeforeEach
    void setUp(){
        defaultItemSellinLargerThanZero = new DefaultItem("foo",6,4);
        defaultItemSellinEqualToZero= new DefaultItem("foo",0,4);
        defaultItemSellinEqualTo1= new DefaultItem("foo",1,4);
        defaultItemSellinLowerThanZero = new DefaultItem("foo",-1,4);
    }

    @Test
    public void passADay_Item_Name_Remains_Same(){
        String originalName = defaultItemSellinLargerThanZero.name;
        defaultItemSellinLargerThanZero.passADay();
        assertEquals(originalName, defaultItemSellinLargerThanZero.name);
    }

    @Test
    void passDay_SellIn_Data_Should_Decrease_By_1(){
        int origSellIn = defaultItemSellinLargerThanZero.sellIn;
        defaultItemSellinLargerThanZero.passADay();
        assertEquals(origSellIn-1,defaultItemSellinLargerThanZero.sellIn);
    }
    @Test
    void passDay_Quality_Diminishes_By_One_While_Sellin_Becomes_Larger_Or_Equal_To_0(){
        int origQuality1 = defaultItemSellinLargerThanZero.quality;
        int origQuality2 = defaultItemSellinEqualTo1.quality;
        defaultItemSellinLargerThanZero.passADay();
        defaultItemSellinEqualTo1.passADay();
        assertEquals(origQuality1-1,defaultItemSellinLargerThanZero.quality);
        assertEquals(origQuality1-1,defaultItemSellinEqualTo1.quality);
    }

    @Test
    void passDay_Quality_Diminishes_By_Two_While_Sellin_Becomes_Lower_Than_0(){
        int origQuality1 = defaultItemSellinEqualToZero.quality;
        int origQuality2 = defaultItemSellinLowerThanZero.quality;
        defaultItemSellinEqualToZero.passADay();
        defaultItemSellinLowerThanZero.passADay();
        assertEquals(origQuality1-2,defaultItemSellinEqualToZero.quality);
        assertEquals(origQuality2-2,defaultItemSellinLowerThanZero.quality);
    }
    @Test
    void passDay_Quality_Should_Not_Go_Below_0(){
        int origQuality = defaultItemSellinLowerThanZero.quality;
        defaultItemSellinLowerThanZero.passADay();
        assertEquals(origQuality-2,defaultItemSellinLowerThanZero.quality);
    }
    @Test
    void passDay_SellIn_Can_Go_Below_0(){
        int origEqualSellIn = defaultItemSellinEqualToZero.sellIn;
        int origLowerSellIn = defaultItemSellinLowerThanZero.sellIn;
        defaultItemSellinEqualToZero.passADay();
        defaultItemSellinLowerThanZero.passADay();
        assertEquals(origEqualSellIn-1,defaultItemSellinEqualToZero.sellIn);
        assertEquals(origLowerSellIn-1,defaultItemSellinLowerThanZero.sellIn);
    }
    @Test
    void passDay_Quality_Can_Not_Go_Below_0(){
        DefaultItem oneQualitySellInNegativeItem = new DefaultItem("foo",-2,1);
        DefaultItem zeroQualitySellInLargerThanZeroItem = new DefaultItem("foo",2,0);
        oneQualitySellInNegativeItem.passADay();
        zeroQualitySellInLargerThanZeroItem.passADay();
        assertEquals(0,oneQualitySellInNegativeItem.quality);
        assertEquals(0,zeroQualitySellInLargerThanZeroItem.quality);
    }
}