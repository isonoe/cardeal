package com.isonoe.cardeal.aglib;

import com.isonoe.cardeal.model.*;
import com.isonoe.cardeal.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AgMutation {

    public static Population startMutationPopulation(
            Population population,
            Double mutationPercentage,
            List<Veiculo> veiculos,
            Map<Integer, WayPoint> indexedMapping) {

        ArrayList<Chromosome> chromosomes = new ArrayList<>();

        chromosomes.addAll(population.getChromosomes());

        Double numCromossomes = Math.floor((population.getChromosomes().size() / 100) * mutationPercentage);

        List<Integer> ids = RandomUtils.getRandomNumbersOfRange(
                0, chromosomes.size(), numCromossomes.intValue(), true);


        for (int i = 0; i < ids.size(); i++) {

            Chromosome chromosome = chromosomes.get(ids.get(i));

            ArrayList<PacoteEntrega> listaPacotes = new ArrayList<>(chromosome.getPacoteEntregas());

            Integer idPacote = RandomUtils.getRandomNumberInRange(0,
                    listaPacotes.size() - 1);

            PacoteEntrega pacoteEntrega = listaPacotes.get(idPacote);

            if (1 % 2 == 0) {
                Veiculo veiculo = (AgPopulation.getVeiculoDisponivel(veiculos, 1)).get(0);

                pacoteEntrega.setVeiculo(veiculo);
            } else {
                // TODO gerar rota
            }

            listaPacotes.set(idPacote, pacoteEntrega);

            chromosome.setPacoteEntregas(listaPacotes);

            chromosomes.set(i, chromosome);
        }

        population.setChromosomes(chromosomes);

        return population;
    }
}


