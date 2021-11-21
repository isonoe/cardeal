package com.isonoe.cardeal.aglib;

import com.isonoe.cardeal.model.Chromosome;
import com.isonoe.cardeal.model.Entrega;
import com.isonoe.cardeal.model.PacoteEntrega;
import com.isonoe.cardeal.model.Population;
import com.isonoe.cardeal.utils.RandomUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AgSelection {

    public static Population startSelectionPopulation(Population population) {

        ArrayList<Chromosome> chromosomes = new ArrayList<>();

        ArrayList<Chromosome> winners = new ArrayList<>();

        chromosomes.addAll(population.getChromosomes());

        Integer numOfTournaments = chromosomes.size() / 2;

        for (int i = 0; i < numOfTournaments; i++) {

            List<Integer> ids = RandomUtils.getRandomNumbersOfRange(
                    0, chromosomes.size(), 2, true);

            Chromosome competidor1 = chromosomes.get(ids.get(0));
            Chromosome competidor2 = chromosomes.get(ids.get(1));

            chromosomes.remove(competidor1);
            chromosomes.remove(competidor2);

            Chromosome vencedor = AgSelection.startTournament(competidor1, competidor2);

            winners.add(vencedor);
        }

        if(chromosomes.size() > 0){
            winners.addAll(chromosomes);
        }

        population.setChromosomes(winners);

        return population;
    }

    public static Chromosome startTournament(Chromosome competidor1, Chromosome competidor2) {

        /*
            Peso rota positiva 1 : entrega atendida
            Peso capacidade carga 2.5
            Peso custo por km 2
         */

        double pesoRotaPositiva = 1;
        double pesoVolume = 2.5;
        double pesoCustoTotal = 2;

        double pontuacao1 = 0;
        double pontuacao2 = 0;

        double rotasPositiva1 = 0;
        double volumeTotalVeiculo1 = 0;
        double volumeTotalEntrega1 = 0;
        double volumePorcentagemTotal1 = 0;
        double custoPorKmTotal1 = 0;

        double rotasPositiva2 = 0;
        double volumeTotalVeiculo2 = 0;
        double volumeTotalEntrega2 = 0;
        double volumePorcentagemTotal2 = 0;
        double custoPorKmTotal2 = 0;

        for (PacoteEntrega pacoteEntrega : competidor1.getPacoteEntregas()) {
            rotasPositiva1 += pacoteEntrega.getPositiveRoutes();
            volumeTotalEntrega1 += pacoteEntrega.getVolumeTotalEntregas().doubleValue();
            volumeTotalVeiculo1 += pacoteEntrega.getVeiculo().getVolumeTotalLt().doubleValue();
            custoPorKmTotal1 += pacoteEntrega.getDistanciaTotalRota().doubleValue()
                    * pacoteEntrega.getVeiculo().getConsumoPorKm().doubleValue();
        }

        volumePorcentagemTotal1 = volumeTotalEntrega1 / volumeTotalVeiculo1;

        for (PacoteEntrega pacoteEntrega : competidor2.getPacoteEntregas()) {
            rotasPositiva2 += pacoteEntrega.getPositiveRoutes();
            volumeTotalEntrega2 += pacoteEntrega.getVolumeTotalEntregas().doubleValue();
            volumeTotalVeiculo2 += pacoteEntrega.getVeiculo().getVolumeTotalLt().doubleValue();
            custoPorKmTotal2 += pacoteEntrega.getDistanciaTotalRota().doubleValue()
                    * pacoteEntrega.getVeiculo().getConsumoPorKm().doubleValue();
        }

        volumePorcentagemTotal2 = volumeTotalEntrega2 / volumeTotalVeiculo2;

        pontuacao1 += rotasPositiva1 * pesoRotaPositiva;

        pontuacao2 += rotasPositiva2 * pesoRotaPositiva;

        if (volumePorcentagemTotal1 < 1){
            pontuacao1 += volumePorcentagemTotal1 * pesoVolume;
        }

        if (volumePorcentagemTotal2 < 1){
            pontuacao2 += volumePorcentagemTotal2 * pesoVolume;
        }

        if(custoPorKmTotal1 < custoPorKmTotal2){
            pontuacao1 = pesoCustoTotal;
            pontuacao2 = (custoPorKmTotal1 / custoPorKmTotal2) * pesoCustoTotal;
        }

        if (pontuacao1 > pontuacao2) {
            return competidor1;
        } else {
            return competidor2;
        }
    }
}
