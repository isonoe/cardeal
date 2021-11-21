package com.isonoe.cardeal.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PacoteEntrega {

    List<Entrega> entregas;

    List<Route> routes;

    Veiculo veiculo;

    Integer positiveRoutes;

    BigDecimal distanciaTotalRota;

    BigDecimal volumeTotalEntregas;
}
