package com.cod.jam.controller;

import com.cod.jam.model.Hora;
import com.cod.jam.model.Proyecto;
import com.cod.jam.model.ProyectoHora;
import com.cod.jam.service.ProyectoHoraService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/horasProyecto")
public class ProyectoHoraController {

    @Autowired
    private ProyectoHoraService service;

    @ApiOperation(value = "Obtener todas las horas por proyecto",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "proyectoHora")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron registros en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping(value = "/{idProyecto}")
    public ResponseEntity<List<ProyectoHora>> listar(@PathVariable("idProyecto") Integer idproyecto) {
        List<ProyectoHora> proyectoshora = new ArrayList<>();
        proyectoshora = service.listarHorasPorProyecto(idproyecto);
        return new ResponseEntity<List<ProyectoHora>>(proyectoshora, HttpStatus.OK);
    }


}
