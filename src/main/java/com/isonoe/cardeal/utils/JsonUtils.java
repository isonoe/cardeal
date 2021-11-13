package com.isonoe.cardeal.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.isonoe.cardeal.model.LatLng;

import java.lang.reflect.Type;

public class JsonUtils {

    public static <T> T jsonToObject(String strJson, Type typeOfT) {
        T object = null;

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        object = gson.fromJson(strJson, typeOfT);

        return object;
    }
}
