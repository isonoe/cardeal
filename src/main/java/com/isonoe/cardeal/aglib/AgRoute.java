package com.isonoe.cardeal.aglib;

import com.isonoe.cardeal.model.Route;
import com.isonoe.cardeal.model.WayPoint;
import com.isonoe.cardeal.model.WayPointLink;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class AgRoute {

    /*
    * TODO(criar indexacao de melhores rotas entre pontos persistida)
    * */
    public static Route generateRoute(
            Integer origem,
            Integer destino,
            Map<Integer, WayPoint> indexedMapping
    ) {
        Route rota = new Route();

        ArrayList<Integer> wayPointsLista = new ArrayList<>();

        Integer limitePath = 100;

        Random gerador = new Random();

        WayPoint actualWaypoint = indexedMapping.get(origem);

        wayPointsLista.add(actualWaypoint.getId());

        boolean matchPath = false;

        while (wayPointsLista.size() < limitePath
                && actualWaypoint.getWpLinks().size() > 0
                && !matchPath) {
            int rNum = gerador.nextInt(actualWaypoint.getWpLinks().size());

            boolean validPoint = false;
            WayPointLink wpLink = new WayPointLink();
            while (!validPoint) {
                wpLink = actualWaypoint.getWpLinks().get(rNum);
                WayPoint wayPoint = indexedMapping.get(wpLink.getId());
                if (wayPoint.getId() != actualWaypoint.getId()) {
                    actualWaypoint = wayPoint;
                    validPoint = true;
                }
            }

            rota.setDistanciaTotal(rota.getDistanciaTotal().add(wpLink.getDistance()));
            wayPointsLista.add(actualWaypoint.getId());

            if (actualWaypoint.getId().equals(destino)) {
                matchPath = true;
                rota.setExactMatch(true);
            }
        }

        rota.setWayPoints(wayPointsLista);

        return rota;
    }
}
