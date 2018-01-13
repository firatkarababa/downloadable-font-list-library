package com.koolio.library;

/**
 * Created by Firat Karababa on 10.1.2018.
 */

public class Font {

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

    public String getQueryString(int variantOpt) {
        String variant = getFontVariants()[variantOpt];
        String query;

        if (variant.equals("regular")) {
            query = "name=" + getFontFamily() + "&weight=400" + "&italic=0";   // Form the query String
        } else if (variant.equals("italic")) {
            query = "name=" + getFontFamily() + "&weight=400" + "&italic=1";   // Form the query String
        } else if (variant.contains("italic")) {
            query = "name=" + getFontFamily() + "&weight=" + variant.split("italic")[0] + "&italic=1";   // Form the query String
        } else {
            query = "name=" + getFontFamily() + "&weight=" + variant + "&italic=0";   // Form the query String
        }
        return query;
    }

}
