package com.isonoe.cardeal.aglib;

import com.isonoe.cardeal.model.WayPoint;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgMapping {

    public static Map<Integer, WayPoint> getIndexedMapping(List<WayPoint> wayPointList) {
        Map<Integer, WayPoint> mapping = new HashMap<>();

        for (WayPoint point : wayPointList) {
            mapping.put(point.getId(), point);
        }

        return mapping;
    }
}
