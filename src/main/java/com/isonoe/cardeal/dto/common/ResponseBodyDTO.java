package com.isonoe.cardeal.dto.common;

import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class ResponseBodyDTO<T> extends ResponseDTO {

    private List<T> resultados;

    public List<T> getResultados() {
        if (ObjectUtils.isEmpty(resultados)) {
            this.resultados = new ArrayList<>();
        }
        return this.resultados;
    }
}
