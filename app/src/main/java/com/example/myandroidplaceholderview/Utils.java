package com.example.myandroidplaceholderview;

import android.content.Context;
import android.content.res.AssetManager;
import android.provider.ContactsContract;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darush on 1/5/2018.
 */

public class Utils {

    private static final String TAG = "Utils";

    public static List<Profile> loadProfile(Context context) {
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            JSONArray jsonArray = new JSONArray(loadJsonFromAsset(context, "profile.json"));
            List<Profile> profileList = new ArrayList<>();
            for(int i=0; i<jsonArray.length(); i++) {
                Profile profile = gson.fromJson(jsonArray.getString(i), Profile.class);
                profileList.add(profile);
            }
            return profileList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String loadJsonFromAsset(Context context, String jsonFileName) {
        String json = null;
        InputStream inputStream = null;
        try {
            AssetManager assetManager = context.getAssets();
            Log.d(TAG, "path: " + jsonFileName);
            inputStream = assetManager.open(jsonFileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

}
