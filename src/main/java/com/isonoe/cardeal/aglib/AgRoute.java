package com.isonoe.cardeal.aglib;

import com.isonoe.cardeal.model.Rota;
import com.isonoe.cardeal.model.WayPoint;
import com.isonoe.cardeal.model.WayPointLink;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class AgRoute {

    public static Rota generateRoute(WayPoint saida, WayPoint destino, Map<BigDecimal, WayPoint> wayPoints) {
        Rota rota = new Rota();

        ArrayList<WayPoint> wayPointsLista = new ArrayList<>();

        Integer limitePath = 100;

        Random gerador = new Random();

        WayPoint actualWaypoint = saida;

        boolean matchPath = false;

        while (rota.getWayPoints().size() < limitePath
                && actualWaypoint.getWpLinks().size() > 0
                && !matchPath) {
            int rNum = gerador.nextInt(actualWaypoint.getWpLinks().size());

            WayPointLink wpLink = actualWaypoint.getWpLinks().get(rNum);

            actualWaypoint = wayPoints.get(wpLink.getId());

            if (actualWaypoint.getId() == destino.getId()) {
                matchPath = true;
            } else {

                rota.setDistanciaTotal(rota.getDistanciaTotal().add(wpLink.getDistance()));

                wayPointsLista.add(actualWaypoint);
            }

        }

        rota.setWayPoints(wayPointsLista);

        return rota;
    }


}
