package com.isonoe.cardeal.model;

import com.isonoe.cardeal.enums.EnumTipoVeiculo;
import com.isonoe.cardeal.model.common.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Veiculo extends BaseEntity {

    String placa;

    String descricao;

    EnumTipoVeiculo tipoVeiculo;

    // considerado uso padrao no volume de embalagens para limitar o escopo
    BigDecimal volumeTotalLt;

    BigDecimal volumeOcupadoLt;

    BigDecimal consumoPorKm;

    // TODO (Dimensoes uteis para entrega)
}
