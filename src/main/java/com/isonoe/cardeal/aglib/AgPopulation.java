package com.isonoe.cardeal.aglib;

import com.isonoe.cardeal.model.*;
import com.isonoe.cardeal.utils.RandomUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AgPopulation {

    /*
     */

    public static Population generatePopulation(
            Integer numberOfCromossomes,
            List<Entrega> entregas,
            List<Veiculo> veiculos,
            Map<Integer, WayPoint> indexedMapping
    ) {

        Population population = new Population();

        ArrayList<Chromosome> chromosomes = new ArrayList<>();


        for (int i = 0; i < numberOfCromossomes; i++) {
            Chromosome chromosome = new Chromosome(i);

            List<Entrega> entregasClone = new ArrayList<>();
            entregasClone.addAll(entregas);

            List<Veiculo> veiculosClone = new ArrayList<>();
            veiculosClone.addAll(veiculos);


            // gerar rota para cada entrega

            List<Veiculo> veiculosEscolhidos = AgPopulation.getVeiculoDisponivel(
                    veiculosClone,
                    entregasClone.size() < veiculosClone.size() ? entregasClone.size() : veiculosClone.size());


            ArrayList<PacoteEntrega> pacoteEntregaList = new ArrayList<>();

            Integer numVeiculos = veiculosEscolhidos.size();


            for (int j = 0; j < numVeiculos; j++) {
                PacoteEntrega pacoteEntrega = new PacoteEntrega();
                pacoteEntrega.setVeiculo(veiculosEscolhidos.get(0));

                if (veiculosEscolhidos.size() == 1) {
                    pacoteEntrega.setEntregas(entregasClone);
                } else {
                    Integer limite = 1;

                    if (entregasClone.size() > veiculosEscolhidos.size()) {
                        limite = entregasClone.size() - (veiculosEscolhidos.size() - 1);
                    }

                    List<Entrega> entregaDisponiveisList = AgPopulation.getEntregasDisponiveis(entregasClone,
                            limite
                    );

                    pacoteEntrega.setEntregas(entregaDisponiveisList);

                    for (Entrega entrega : entregaDisponiveisList) {
                        entregasClone.remove(entrega);
                    }

                    veiculosEscolhidos.remove(0);

                }

                ArrayList<Route> routes = new ArrayList<>();
                BigDecimal distanciaTotal = new BigDecimal(0);
                BigDecimal volumeTotal = new BigDecimal(0);
                Endereco origem = pacoteEntrega.getEntregas().get(0).getOrigem();

                Integer countMachedRoutes = 0;

                for (Entrega entrega : pacoteEntrega.getEntregas()) {
                    Route route = AgRoute.generateRoute(
                            origem.getWayPointId(),
                            entrega.getDestino().getWayPointId(),
                            indexedMapping);

                    distanciaTotal = distanciaTotal.add(route.getDistanciaTotal());
                    volumeTotal = volumeTotal.add(entrega.getVolumeEmbalagemLt());

                    if(route.isExactMatch()){
                        countMachedRoutes += 1;
                    }

                    routes.add(route);

                    // a proxima origem e o atual destino
                    origem = entrega.getDestino();
                }

                pacoteEntrega.setRoutes(routes);
                pacoteEntrega.setDistanciaTotalRota(distanciaTotal);
                pacoteEntrega.setVolumeTotalEntregas(volumeTotal);

                pacoteEntrega.setPositiveRoutes(countMachedRoutes);

                pacoteEntregaList.add(pacoteEntrega);

            }

            chromosome.setPacoteEntregas(pacoteEntregaList);


//            chromosome.setRotas(routes);
//            chromosome.setVeiculo(AgPopulation.getVeiculoDisponivel(veiculos));

            chromosomes.add(chromosome);
        }

        population.setChromosomes(chromosomes);

//        Integer matches = AgPopulation.getNumberOfMaches(population);

        return population;
    }

//    static Integer getNumberOfMaches(Population population) {
//        Integer matches = 0;
//        for (Chromosome chromosome : population.getChromosomes()) {
//            for (Route route : chromosome.getRotas()) {
//                if (route.isExactMatch()) {
//                    matches += 1;
//                }
//            }
//        }
//        return matches;
//    }

    public static List<Veiculo> getVeiculoDisponivel(List<Veiculo> veiculos, Integer numMaxVeiculos) {

        int rNum = RandomUtils.getRandomNumberInRange(1, numMaxVeiculos);

        if (veiculos.size() == rNum) {
            return veiculos;
        } else {
            ArrayList<Veiculo> veiculosEscolhidos = new ArrayList<>();

            for (Integer i :
                    RandomUtils.getRandomNumbersOfRange(0, veiculos.size(), rNum, true)
            ) {
                veiculosEscolhidos.add(veiculos.get(i));
            }

            return veiculosEscolhidos;
        }
    }

    public static List<Entrega> getEntregasDisponiveis(List<Entrega> entregas, Integer numMaxEntrega) {
        int rNum = RandomUtils.getRandomNumberInRange(1, numMaxEntrega);

        if (entregas.size() == rNum) {
            return entregas;
        } else {
            ArrayList<Entrega> entregaEscolhidas = new ArrayList<>();

            for (Integer i :
                    RandomUtils.getRandomNumbersOfRange(0, entregas.size(), rNum, true)
            ) {
                entregaEscolhidas.add(entregas.get(i));
            }

            return entregaEscolhidas;
        }
    }

//    public static List<Veiculo> filterVeiculosVolumeMinimo(List<Veiculo> veiculos, Integer volumeMinimo){
//        ArrayList<Veiculo> veiculosFiltrados = new ArrayList<>();
//        for (Veiculo veiculo: veiculos ) {
//            if(veiculo.getVolumeTotalLt() >= volumeMinimo){
//                veiculosFiltrados.add(veiculo);
//            }
//        }
//        return veiculosFiltrados;
//    }
}
