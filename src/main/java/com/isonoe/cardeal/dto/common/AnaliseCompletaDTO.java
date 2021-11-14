package com.isonoe.cardeal.dto.common;

import com.isonoe.cardeal.model.Entrega;
import com.isonoe.cardeal.model.Veiculo;
import com.isonoe.cardeal.model.WayPoint;
import lombok.Data;

import java.util.List;

@Data
public class AnaliseCompletaDTO {

    Integer numberOfGenerations;
    Integer numberOfCromossomes;
    List<Entrega> entregas;
    List<Veiculo> veiculos;
    List<WayPoint> mapping;
}
