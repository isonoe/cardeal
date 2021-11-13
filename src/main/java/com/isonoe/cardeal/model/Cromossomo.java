package com.isonoe.cardeal.model;

import com.isonoe.cardeal.model.common.BaseEntity;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Cromossomo extends BaseEntity {

    ArrayList<Entrega> entregas;

    ArrayList<Rota> rotas;

    Veiculo veiculo;
}
