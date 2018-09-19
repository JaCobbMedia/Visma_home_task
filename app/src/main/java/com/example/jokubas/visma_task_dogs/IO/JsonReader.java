package com.example.jokubas.visma_task_dogs.IO;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JsonReader {
    public static ArrayList<String> readJSONfile(String jsonFile, Context context) {

        System.out.println(jsonFile);
        String jsonText = "";
        JsonParser parser = new JsonParser();
        ArrayList<String> dogUrlsList = new ArrayList<>();

        try{
            InputStream is = context.getAssets().open(jsonFile);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonText = new String(buffer);
            //System.out.println(jsonText);

            JsonObject json = (JsonObject) parser.parse(jsonText);
            JsonArray dogUrls = json.getAsJsonArray("urls");


            dogUrlsList = new Gson().fromJson(dogUrls, ArrayList.class);

        }catch (IOException ex){
            System.out.println("Reading failed");
            ex.printStackTrace();
        }

        return dogUrlsList;
    }
}
