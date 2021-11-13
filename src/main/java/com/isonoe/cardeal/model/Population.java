package com.isonoe.cardeal.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;

@Data
public class Population {
    Integer numberOfCromossomes;
    ArrayList<Cromossomo> cromossomos;
}
