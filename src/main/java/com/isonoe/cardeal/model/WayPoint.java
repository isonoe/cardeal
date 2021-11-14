package com.isonoe.cardeal.model;

import com.isonoe.cardeal.model.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;


@Data
public class WayPoint extends BaseEntity {

    LatLng latLng;

    ArrayList<WayPointLink> wpLinks;
}
