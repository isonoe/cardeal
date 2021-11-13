package com.isonoe.cardeal.controller;

import com.isonoe.cardeal.dto.common.AnaliseCompletaDTO;
import com.isonoe.cardeal.dto.common.ResponseBodyDTO;
import com.isonoe.cardeal.dto.common.ResponseDTO;
import com.isonoe.cardeal.exceptions.DefaultExceptionHandler;
import com.isonoe.cardeal.model.WayPoint;
import com.isonoe.cardeal.service.RouteManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/manager")
public class RouteManager {

    @Autowired
    private RouteManagerService routeManagerService;

    @PostMapping(value = "/validatemapping", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO consultarMetadata(@RequestBody(required = true) List<WayPoint> wayPoints) throws DefaultExceptionHandler {

        ResponseDTO out = this.routeManagerService.validarWaipointsMapping(wayPoints);

        return out;
    }

    @PostMapping(value = "/startanalisecompleta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO consultarMetadata(@RequestBody(required = true) AnaliseCompletaDTO analiseCompleta) throws DefaultExceptionHandler {

        ResponseDTO out = this.routeManagerService.startAnaliseCompleta(analiseCompleta);

        return out;
    }
}
