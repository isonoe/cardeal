package com.isonoe.cardeal.model;

import com.isonoe.cardeal.model.common.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;

@Data
public class Rota extends BaseEntity {

    ArrayList<WayPoint> wayPoints;

    BigDecimal distanciaTotal;
}
