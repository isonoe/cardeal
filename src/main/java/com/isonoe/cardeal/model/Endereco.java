package com.isonoe.cardeal.model;

import com.isonoe.cardeal.model.common.BaseEntity;
import lombok.Data;

@Data
public class Endereco extends BaseEntity {

    String descricao;
    Integer wayPointId;
}
