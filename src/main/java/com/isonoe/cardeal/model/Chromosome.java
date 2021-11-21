package com.isonoe.cardeal.model;

import com.isonoe.cardeal.model.common.BaseEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Chromosome extends BaseEntity {

    List<PacoteEntrega> pacoteEntregas;

    public Chromosome(){}

    public Chromosome(Integer id){
        super(id);
    }
}
