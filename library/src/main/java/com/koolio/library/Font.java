package com.koolio.library;

import java.io.Serializable;

/**
 * Created by Firat Karababa on 10.1.2018.
 */

public class Font implements Serializable {

    private String fontFamily, fontCategory, fontVersion, fontLastModified;
    private String[] fontVariants, fontSubsets;

    public Font(String fontFamily, String fontCategory, String[] fontVariants, String[] fontSubsets,String fontVersion, String fontLastModified) {
        this.fontFamily = fontFamily;
        this.fontCategory = fontCategory;
        this.fontLastModified = fontLastModified;
        this.fontVariants = fontVariants;
        this.fontVersion = fontVersion;
        this.fontSubsets = fontSubsets;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getFontCategory() {
        return fontCategory;
    }

    public void setFontCategory(String fontCategory) {
        this.fontCategory = fontCategory;
    }

    public String getFontVersion() {
        return fontVersion;
    }

    public void setFontVersion(String fontVersion) {
        this.fontVersion = fontVersion;
    }

    public String getFontLastModified() {
        return fontLastModified;
    }

    public void setFontLastModified(String fontLastModified) {
        this.fontLastModified = fontLastModified;
    }

    public String[] getFontVariants() {
        return fontVariants;
    }

    public void setFontVariants(String[] fontVariants) {
        this.fontVariants = fontVariants;
    }

    public String[] getFontSubsets() {
        return fontSubsets;
    }

    public void setFontSubsets(String[] fontSubsets) {
        this.fontSubsets = fontSubsets;
    }

    // Returns query String with no specification. Query will just use the family name and default values
    public String getQueryString() {
        return "name=" + getFontFamily() + "&weight=400" + "&italic=0";

    }

    // Returns query String with the selected variant options. Variant options will be selected based
    // on given variantOpt ID
    public String getQueryString(int variantOpt) {
        String[] fontVariants = getFontVariants();

        if(variantOpt < 0 || variantOpt > fontVariants.length-1)
            throw new IllegalArgumentException("variantOpt argument is out of bound: please use " +
                    "an int between 0 and variants length-1 (both inclusive)");

        String variant = fontVariants[variantOpt];
        String query = "name=" + getFontFamily();

        if (variant.equals("regular")) {
            query += "&weight=400" + "&italic=0";   // Form the query String with default values
        } else if (variant.equals("italic")) {
            query += "&weight=400" + "&italic=1";   // Form the query String
        } else if (variant.contains("italic")) {
            query += "&weight=" + variant.split("italic")[0] + "&italic=1";   // Form the query String
        } else {
            query += "&weight=" + variant + "&italic=0";   // Form the query String
        }
        return query;
    }



}
