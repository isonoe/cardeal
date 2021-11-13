package com.isonoe.cardeal.model;

import com.isonoe.cardeal.enums.EnumTipoVeiculo;
import lombok.Data;

@Data
public class Veiculo {
    Integer id;
    String placa;
    String descricao;
    EnumTipoVeiculo tipoVeiculo;
    Integer capacidadeTotal;
    Integer consumoPorKm;


    // TODO (Dimensoes uteis para entrega)
}
