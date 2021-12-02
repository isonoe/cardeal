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

    public void startAnalise() {
        // Gerar a populacao
        this.population = AgPopulation.generatePopulation(
                this.analiseCompleta.getNumberOfCromossomes(),
                this.analiseCompleta.getEntregas(),
                this.analiseCompleta.getVeiculos(),
                this.indexedMapping);

        for (int i = 0; i < this.analiseCompleta.getNumberOfGenerations(); i++) {

            // Fase Fitness
            this.population = AgFitness.startEvaluatePopulation(population);

            // Fase Selecao Torneio
            this.population = AgSelection.startSelectionPopulation(population);

            // Fase Crossover
            this.population = AgCrossover.startCrossoverPopulation(
                    population,
                    this.analiseCompleta.getNumberOfCromossomes());

            // Fase Mutation
            this.population = AgMutation.startMutationPopulation(
                    population,
                    this.analiseCompleta.getMutationPercentage(),
                    this.analiseCompleta.getVeiculos(),
                    this.indexedMapping);

            int a = 0;
        }

        // Fase Mutation

    }

    public AgOrchestrator(AnaliseCompletaDTO analiseCompleta) {
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
