package com.isonoe.cardeal.model;

import com.isonoe.cardeal.enums.EnumTipoVeiculo;
import com.isonoe.cardeal.model.common.BaseEntity;
import lombok.Data;

@Data
public class Entrega extends BaseEntity {

    String descricao;
    Endereco saida;
    Endereco destino;
    Integer peso;
    EnumTipoVeiculo veiculoCapacidadeMinima;
}
