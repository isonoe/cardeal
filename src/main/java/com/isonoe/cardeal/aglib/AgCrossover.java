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

        while (chromosomes.size() < numberOfCromossomes) {
            List<Integer> ids = RandomUtils.getRandomNumbersOfRange(
                    0, chromosomes.size(), 2, true);

            chromosomes.addAll(
                    AgCrossover.crossover(
                            chromosomes.get(ids.get(0)),
                            chromosomes.get(ids.get(1)))
            );
        }

        population.setChromosomes(chromosomes);

        return population;
    }

    public static List<Chromosome> crossover(Chromosome individuo1, Chromosome individuo2) {
        /*
            pacote entrega
                entregas
                rotas
                veiculo
        */

        Chromosome filho1 = new Chromosome();
        Chromosome filho2 = new Chromosome();

        List<PacoteEntrega> pacoteEntregas1 = individuo1.getPacoteEntregas();
        List<PacoteEntrega> pacoteEntregas2 = individuo2.getPacoteEntregas();

        filho1.setPacoteEntregas(
                AgCrossover.crossoverVeiculo(pacoteEntregas1,
                        individuo2.getPacoteEntregas())
        );

        filho2.setPacoteEntregas(
                AgCrossover.crossoverVeiculo(pacoteEntregas2,
                        individuo1.getPacoteEntregas())
        );

        ArrayList<Chromosome> listaCromossomos = new ArrayList<>();

        listaCromossomos.add(filho1);
        listaCromossomos.add(filho2);

        return listaCromossomos;
    }

    public static List<PacoteEntrega> crossoverVeiculo(
            List<PacoteEntrega> pacoteEntregas1,
            List<PacoteEntrega> pacoteEntregas2) {
        for (int i = 0; i < pacoteEntregas1.size(); i++) {
            if (pacoteEntregas2.size() >= i + 1) {
                PacoteEntrega pacoteEntrega = pacoteEntregas1.get(i);
                pacoteEntrega.setVeiculo(pacoteEntregas2.get(i).getVeiculo());
                pacoteEntregas1.set(i, pacoteEntrega);
            }
        }
        return pacoteEntregas1;
    }
}
