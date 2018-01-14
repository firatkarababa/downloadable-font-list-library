# downloadable-font-list-library
A library that fetches Google's downloadable font list and helps to form query String to use downloadable fonts feature.

## Methods
### FontList Class Methods
#### fontList.getFontFamilyList()
  This method returns a Font ArrayList of all fonts.

#### fontList.getFontArrayList()
  This method returns a String ArrayList of Font family names.

#### fontList.getFontByID(int id)
  This method returns the Font object by its id.


### Font Class Methods
#### font.getFontVariants()
  This method returns all of the variants available for the specified font.

#### font.getQueryString(int variantOpt)
  This method returns a String query to be used for dynamic use of Downloadable Fonts feature given which variant of a font is to be used.



The article which explains Downloadable Font List Library and Downloadable Fon List Demo can be found [here](https://medium.com/@firatkarababa/retrieve-available-downloadable-font-list-for-android-downloadable-font-list-library-731f8d6a7281)
