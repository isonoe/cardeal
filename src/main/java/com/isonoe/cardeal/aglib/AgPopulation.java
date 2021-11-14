package com.isonoe.cardeal.aglib;

import com.isonoe.cardeal.dto.common.AnaliseCompletaDTO;
import com.isonoe.cardeal.model.Chromosome;
import com.isonoe.cardeal.model.Entrega;
import com.isonoe.cardeal.model.Population;
import com.isonoe.cardeal.model.WayPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AgPopulation {

    /* TODO(
         * criar cromossomo
         * iterar entregas
         * escolher veiculo
         * gerar rota
         * gerar analise rota
         * tempo
         * custo combustivel
         * utilizacao veiculo %
         *
         )
     */

    public static Population generatePopulation(
            Integer numberOfCromossomes,
            List<Entrega> entregas,
            Map<Integer, WayPoint> indexedMapping
    ) {

        Population population = new Population();

        ArrayList<Chromosome> chromosomes = new ArrayList<>();

        for (int i = 0; i < numberOfCromossomes; i++) {
            Chromosome chromosome = new Chromosome(i);
            chromosomes.add(chromosome);
        }

        population.setChromosomes(chromosomes);

        return population;
    }
}
