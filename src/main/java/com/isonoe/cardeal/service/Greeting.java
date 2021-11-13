package com.isonoe.cardeal.service;

import com.isonoe.cardeal.model.LatLng;
import com.isonoe.cardeal.model.WayPoint;
import com.isonoe.cardeal.utils.JsonUtils;

public class Greeting {

    private long id;
    private String content;

    public Greeting() {

    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void convertJsonToObject() {
        String str = "{\"latLng\":{\"lat\": 45.36252,\"lng\":15.65654 }, \"links\":[]}";

        WayPoint wayPoint = JsonUtils.jsonToObject(str, WayPoint.class);

        System.out.println(wayPoint);
    }
}

