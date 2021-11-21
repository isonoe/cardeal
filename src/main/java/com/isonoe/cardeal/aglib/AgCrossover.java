package com.isonoe.cardeal.aglib;

import com.isonoe.cardeal.model.Chromosome;
import com.isonoe.cardeal.model.Entrega;
import com.isonoe.cardeal.model.PacoteEntrega;
import com.isonoe.cardeal.model.Population;
import com.isonoe.cardeal.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class AgCrossover {

    public static Population startCrossoverPopulation(Population population, Integer numberOfCromossomes) {

        ArrayList<Chromosome> chromosomes = new ArrayList<>();

        chromosomes.addAll(population.getChromosomes());

        while (chromosomes.size() < numberOfCromossomes){
            List<Integer> ids = RandomUtils.getRandomNumbersOfRange(
                    0, chromosomes.size(), 2, true);


        }

        for (Chromosome chromosome : population.getChromosomes()) {

        }

        return population;
    }

    public static List<Chromosome> crossover(Chromosome individuo1, Chromosome individuo2){
        /*
            pacote entrega
                entregas
                rotas
                veiculo
        */

        Chromosome filho1 = new Chromosome();

        filho1.setPacoteEntregas(individuo1.getPacoteEntregas());

        Chromosome filho2 = new Chromosome();

        filho2.setPacoteEntregas(individuo2.getPacoteEntregas());

//        for (PacoteEntrega pacoteEntrega: filho1.getPacoteEntregas()) {
//            for (Entrega entrega: pacoteEntrega.getEntregas() ) {
//                pacoteEntrega.setEntrega;
//            }
//
//        }

        ArrayList<Chromosome> listaCromossomos = new ArrayList<>();

        listaCromossomos.add(filho1);
        listaCromossomos.add(filho2);

        return listaCromossomos;
    }
}
