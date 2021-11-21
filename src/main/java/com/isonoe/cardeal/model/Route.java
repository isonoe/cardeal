package com.isonoe.cardeal.model;

import com.isonoe.cardeal.model.common.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;

@Data
public class Route extends BaseEntity {

    ArrayList<Integer> wayPoints;

    BigDecimal distanciaTotal;

    boolean exactMatch;

    public Route(){
        wayPoints = new ArrayList<>();
        distanciaTotal = new BigDecimal(0);
        exactMatch = false;
    }
}
