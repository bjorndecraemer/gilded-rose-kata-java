# Gilded Rose Refactoring Kata ( My solution)

This Kata was originally created by Terry Hughes (http://twitter.com/TerryHughes). It is already on GitHub [here](https://github.com/NotMyself/GildedRose). See also [Bobby Johnson's description of the kata](http://iamnotmyself.com/2011/02/13/refactor-this-the-gilded-rose-kata/).

[Emily Bache](https://github.com/emilybache) translated the original C# into a few other languages, including java (the version I refactored), and slightly changed the starting position.

As Bobby Johnson points out in his article ["Why Most Solutions to Gilded Rose Miss The Bigger Picture"](http://iamnotmyself.com/2012/12/07/why-most-solutions-to-gilded-rose-miss-the-bigger-picture), it'll actually give you
better practice at handling a legacy code situation if you do this Kata in the original C#. However, I think this kata
is also really useful for practicing writing good tests using different frameworks and approaches, and the small changes I've made help with that. I think it's also interesting to compare what the refactored code and tests look like in different programming languages.

[Emily Bache](https://github.com/emilybache) wrote this article ["Writing Good Tests for the Gilded Rose Kata"](http://coding-is-like-cooking.info/2013/03/writing-good-tests-for-the-gilded-rose-kata/) about how you could use this kata in a [coding dojo](https://leanpub.com/codingdojohandbook).

## Remark
<b>There is a difference between the given requirements and the existing implementation</b>

<b>Requirements:</b>

 - "Aged Brie" and "Sulfuras" are described as fixed-name items
 - "Backstage passes" and "Conjured" items are described as there are multiple possible items with the prefix same prefix (like : "Conjured mana cake" and "Conjured health potion")
 
<b>Existing implementation:</b>
- In the existing implementation all types are handled as fixed  names (equals is used)

<b>I made the choice to follow the requirements and used the respective startsWith or equals options in my factory class(In real life I would check this with my end-user/business/client what the correct implementation should be ;)</b>
## Description of my Refactoring

- I left the Item class as-is, as this was a requirement

<b>I adhered to the SOLID principles & TDD which led me to the following solution:</b>
*This sometimes leads to less abstractions in a super class, but I did not put a method in a super class that would not be used in all Child classes*

- The [JUnit5](https://junit.org/junit5/) tests were written so that the existing requirements were included in them
- Once I started refactoring I first wrote the tests for a new file before implementing it.
- Every class has it's tests in a separate file which follows the same package structure in the [test](./src/test) directory
- I Created 1 new Child-Class of Item called [GenericStableItem](./src/main/java/com/gildedrose/model/GenericStableItem.java) This class both serves as a parent to all other specialized classes and is used for the Sulfuras Items. This class has no behaviour that it's child classes do not use. The method passADay() does nothing here.
- I created 4 Child-Classes of [GenericStableItem](./src/main/java/com/gildedrose/model/GenericStableItem.java) : [AgedBrieItem](./src/main/java/com/gildedrose/model/AgedBrieItem.java), [BackstagePassItem](./src/main/java/com/gildedrose/model/BackstagePassItem.java), [ConjuredItem](./src/main/java/com/gildedrose/model/ConjuredItem.java) & [DefaultItem](./src/main/java/com/gildedrose/model/DefaultItem.java) 
- I created a Factory Class [ItemFactory](./src/main/java/com/gildedrose/model/factory/ItemFactory.java) which has an overloaded static method that returns one of the specific Item classes bases on an existing [Item](./src/main/java/com/gildedrose/model/Item.java) OR (name,sellIn,quality)
- I added a [InvalidGildedRoseConfigurationException](./src/main/java/com/gildedrose/exceptions/InvalidGildedRoseConfigurationException.java)  , Thrown if the [GildedRose](./src/main/java/com/gildedrose/GildedRose.java) constructor is called with a null or empty object.
- I added a [InvalidItemConfigurationException](./src/main/java/com/gildedrose/exceptions/InvalidItemConfigurationException.java)  , Thrown if the [ItemFactory](./src/main/java/com/gildedrose/model/factory/ItemFactory.java) is used with an Item that is invalid (null, negative quality or null/empty name)
- I chose to leave the [GildedRose](./src/main/java/com/gildedrose/GildedRose.java) constructor signature as-is (To allow for backwards compatibility), but changed it's implementation to generate an ArrayList<[GenericStableItem](./src/main/java/com/gildedrose/model/GenericStableItem.java)> based on the input Item[].
- I added another (overloaded) constructor that has as input an ArrayList<[GenericStableItem](./src/main/java/com/gildedrose/model/GenericStableItem.java)>.
- I added a constants class [GildedRoseConstants](./src/main/java/com/gildedrose/constants/GildedRoseConstants.java) to store some constants
- The GildedRose updateQuality method now only loops over all items in the ArrayList<GenericStableItem> and calls the passADay() method on them
- I left the [TexttestFixture](./src/test/java/com/gildedrose/TexttestFixture.java) intact, but do not use text-based tests myself (I used JUnit)
- I chose an appropriate package structure

<b>Other info:</b> 

- I added project lombok to the maven pom.xml, since I use it in my code
- Updated to Java 11
- Added Intellij entries to .gitIgnore 
## How to run this Kata

- In Eclipse or Intellij : Run all JUnit tests in the project
- The [TexttestFixture](./src/test/java/com/gildedrose/TexttestFixture.java) file is also still runnable