package com.isonoe.cardeal.model.common;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    Integer id;
    String criadoEm;
    String atualizadoEm;

    public Integer getId() {
        return id;
    }

    public BaseEntity(){

    }

    public BaseEntity(Integer id){
        this.setId(id);
        this.setCriadoEm(new Date().toString());
        this.setAtualizadoEm(this.getCriadoEm());
    }
}
