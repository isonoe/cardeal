package com.isonoe.cardeal.model;

import com.isonoe.cardeal.model.common.BaseEntity;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Chromosome extends BaseEntity {

    ArrayList<Entrega> entregas;

    ArrayList<Rota> rotas;

    Veiculo veiculo;

    public Chromosome(){}

    public Chromosome(Integer id){
        super(id);
    }
}
