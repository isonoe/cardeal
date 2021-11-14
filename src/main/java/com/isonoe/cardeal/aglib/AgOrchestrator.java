package com.isonoe.cardeal.aglib;

import com.isonoe.cardeal.dto.common.AnaliseCompletaDTO;
import com.isonoe.cardeal.model.Population;
import com.isonoe.cardeal.model.WayPoint;

import java.util.Map;

public class AgOrchestrator {

    AnaliseCompletaDTO analiseCompleta;
    Map<Integer, WayPoint> indexedMapping;
    Population population;

    /* TODO (
        * n iteracoes
        * n max-waypoints
        * n max-route-length
        * formatar objeto de saida da analise

        )
     */

    public void startAnalise(){
        // Gerar a populacao
        AgPopulation.generatePopulation(
                this.analiseCompleta.getNumberOfCromossomes(),
                this.analiseCompleta.getEntregas(),
                this.indexedMapping);

        // Fase Fitness

        // Fase Torneio

        // Fase Crossover

        // Fase Mutation

    }

    public AgOrchestrator(AnaliseCompletaDTO analiseCompleta){
        this.setAnaliseCompleta(analiseCompleta);
        this.indexedMapping = AgMapping.getIndexedMapping(analiseCompleta.getMapping());
    }

    public AnaliseCompletaDTO getAnaliseCompleta() {
        return analiseCompleta;
    }

    public void setAnaliseCompleta(AnaliseCompletaDTO analiseCompleta) {
        this.analiseCompleta = analiseCompleta;
    }
}
