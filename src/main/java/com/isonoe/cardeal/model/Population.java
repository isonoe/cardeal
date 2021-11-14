package com.isonoe.cardeal.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Population {
    Integer numberOfCromossomes;
    ArrayList<Chromosome> chromosomes;
}
