package com.isonoe.cardeal.enums;

public enum EnumTipoVeiculo {

    MOTO(1, "MOTO"),
    CARRO(2, "CARRO"),
    VAN(3, "VAN"),
    CAMINHAO(4, "CAMINHAO");

    private Integer codigo;

    private String descricao;

    private EnumTipoVeiculo(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
