package com.koolio.library;

/**
 * Created by Firat Karababa on 10.1.2018.
 */

import java.util.ArrayList;

public class FontList {
    ArrayList<Font> fontArrayList;

    public FontList() {
        fontArrayList = new ArrayList<>();
    }

    public void addNewFont(Font font) {
        fontArrayList.add(font);
    }

    public ArrayList<Font> getFontArrayList() {
        return fontArrayList;
    }

    public ArrayList<Font> getFontArrayListByFamily(String family) {
        ArrayList<Font> list = new ArrayList<>();

        for(Font font:fontArrayList) {
            if(font.getFontFamily().equals(family)) {
                list.add(font);
            }
        }
        return list;
    }

    public ArrayList<Font> getFontArrayListByCategory(String category) {
        ArrayList<Font> list = new ArrayList<>();

        for(Font font: fontArrayList) {
            if(font.getFontFamily().equals(category)) {
                list.add(font);
            }
        }
        return list;
    }

    public Font getFontByID(int id) {
        return fontArrayList.get(id);
    }

    public ArrayList<String> getFontFamilyList() {
        ArrayList<String> familyList = new ArrayList<>();
        for(Font font: fontArrayList) {
            familyList.add(font.getFontFamily());
        }

        return familyList;
    }

}
