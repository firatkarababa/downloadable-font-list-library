package com.koolio.library;

/**
 * Created by Firat Karababa on 10.1.2018.
 */

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


public class DownloadableFontList {

    private static FontListCallback callback;

    public DownloadableFontList() {
    }

    public FontListCallback getCallback() {
        return callback;
    }

    public void setCallback(FontListCallback callback) {
        this.callback = callback;
    }

    public static void requestDownloadableFontList(FontListCallback fontListCallback, String yourAPIKey) {
        callback = fontListCallback;
        new FontListDownloaderAsyncTask(callback, yourAPIKey).execute();
    }


    public interface FontListCallback {

        void onFontListRetrieved(FontList fontList);

        void onTypefaceRequestFailed(int reason);

    }


    private static class FontListDownloaderAsyncTask extends AsyncTask<String, String, Void> {

        String result = "";
        FontListCallback fontListCallback;
        String yourAPIKey;

        public FontListDownloaderAsyncTask(FontListCallback fontListCallback, String yourAPIKey){
            this.fontListCallback = fontListCallback;
            this.yourAPIKey = yourAPIKey;
        }

        protected void onPreExecute() {

        }
        @Override
        protected Void doInBackground(String... params) {

            BufferedReader reader = null;
            try {
                URL url = new URL("https://www.googleapis.com/webfonts/v1/webfonts?key=" + yourAPIKey);
                reader = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuffer buffer = new StringBuffer();
                int read;
                char[] chars = new char[1024];
                while ((read = reader.read(chars)) != -1)
                    buffer.append(chars, 0, read);

                result = buffer.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(Void v) {
            fontListCallback.onFontListRetrieved(parseJSONString(result));

        }
    }

    private static FontList parseJSONString(String jsonStr) {
        FontList fontList = new FontList();

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                // Getting JSON Array node
                JSONArray fonts = jsonObj.getJSONArray("items");

                // looping through all fonts
                for (int i = 0; i < fonts.length(); i++) {
                    JSONObject c = fonts.getJSONObject(i);
                    String family = c.getString("family");

                    String category = c.getString("category");

                    // Variants are JSON Objects
                    JSONArray variants = c.getJSONArray("variants");
                    String[] variantStrArray = new String[variants.length()];
                    for (int j = 0; j < variants.length(); j++) {
                        variantStrArray[j] = variants.getString(j);
                    }

                    JSONArray subsets = c.getJSONArray("subsets");
                    String[] subsetStrArray = new String[subsets.length()];
                    for (int j = 0; j < subsets.length(); j++) {
                        subsetStrArray[j] = subsets.getString(j);
                    }

                    String version = c.getString("version");

                    String lastModified = c.getString("lastModified");

                    fontList.addNewFont(new Font(family, category, variantStrArray, subsetStrArray, version, lastModified));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return fontList;
    }


}
