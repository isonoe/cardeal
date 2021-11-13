package com.isonoe.cardeal.service;

import com.isonoe.cardeal.dto.common.AnaliseCompletaDTO;
import com.isonoe.cardeal.dto.common.ResponseBodyDTO;
import com.isonoe.cardeal.dto.common.ResponseDTO;
import com.isonoe.cardeal.model.WayPoint;
import com.isonoe.cardeal.utils.JsonUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteManagerService {

    public ResponseDTO validarWaipointsMapping(List<WayPoint> wayPointList) {
        System.out.println(wayPointList);

        ResponseDTO response = new ResponseDTO();

        response.setStatusCode(200);
        response.setUserMessage("Mapa valido");
        response.setDeveloperMessage("Mapa valido");

        return response;
    }

    public void convertJsonToObject() {
        String str = "{\"latLng\":{\"lat\": 45.36252,\"lng\":15.65654 }, \"links\":[]}";

        WayPoint wayPoint = JsonUtils.jsonToObject(str, WayPoint.class);

        System.out.println(wayPoint);
    }

    public ResponseDTO startAnaliseCompleta(AnaliseCompletaDTO analiseCompleta) {
        System.out.println(analiseCompleta);

        ResponseDTO response = new ResponseDTO();

        response.setStatusCode(200);
        response.setUserMessage("Mapa valido");
        response.setDeveloperMessage("Mapa valido");

        return response;
    }
}
