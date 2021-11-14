package com.isonoe.cardeal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WayPointLink {
    BigDecimal id;
    BigDecimal distance;
}
