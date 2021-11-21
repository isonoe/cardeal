package com.isonoe.cardeal.aglib;

import com.isonoe.cardeal.model.Chromosome;
import com.isonoe.cardeal.model.PacoteEntrega;
import com.isonoe.cardeal.model.Population;

import java.util.ArrayList;

public class AgFitness {

    public static Population startEvaluatePopulation(Population population) {

        ArrayList<Chromosome> chromosomes = new ArrayList<>();
        chromosomes.addAll(population.getChromosomes());

        for (Chromosome chromosome : population.getChromosomes()) {
            int countMatch = 0;
            for (PacoteEntrega pacoteEntrega : chromosome.getPacoteEntregas()) {
                if (AgFitness.evaluatePacoteEntregaRota(pacoteEntrega)) {
                    countMatch += 1;
                }
            }
            if (countMatch == 0) {
                chromosomes.remove(chromosome);
            }
        }

        population.setChromosomes(chromosomes);

        return population;
    }

    public static boolean evaluatePacoteEntregaRota(PacoteEntrega pacoteEntrega) {

        // TODO (Avaliar outros aspectos da pacote)



        return pacoteEntrega.getPositiveRoutes() > 0;
    }


}
