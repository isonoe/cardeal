package com.isonoe.cardeal.model;

import com.isonoe.cardeal.enums.EnumTipoVeiculo;
import com.isonoe.cardeal.model.common.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Entrega extends BaseEntity {

    String descricao;

    Endereco origem;

    Endereco destino;

    BigDecimal peso;

    BigDecimal volumeEmbalagemLt;
}
