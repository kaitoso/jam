package com.cod.jam.controller;
import com.cod.jam.controller.EmpresaController;
import com.cod.jam.dto.ProyectoDTO;
import com.cod.jam.dto.ProyectoListaHoraDTO;
import com.cod.jam.model.Proyecto;
import com.cod.jam.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService service;


    @GetMapping
    public ResponseEntity<List<Proyecto>> findAll(){
        System.out.println("qwer");
        List<Proyecto> lista = service.findAll();
        return new ResponseEntity<List<Proyecto>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> findById(@PathVariable("id") Integer id) throws Exception {
        Proyecto obj = service.findById(id);
        return new ResponseEntity<Proyecto>(obj, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Proyecto> update(@Valid @RequestBody Proyecto consulta) {
        Proyecto obj = service.update(consulta);
        return new ResponseEntity<Proyecto>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Integer id) throws Exception {
        service.deleteById(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }



    @GetMapping(value = "/dto", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<ProyectoDTO> getProyectosDTO() throws Exception {
        List<Proyecto> proyectos = new ArrayList<>();
        List<ProyectoDTO> proyectosDTO = new ArrayList<>();
        proyectos = service.findAll();
        for (Proyecto c : proyectos) {
            ProyectoDTO d = new ProyectoDTO();
            d.setIdProyecto(c.getIdProyecto());
            d.setEmpresa(c.getEmpresa());


            // localhost:0880/paciente/
            ControllerLinkBuilder linkTo1 = linkTo(methodOn(EmpresaController.class).findById((c.getEmpresa().getIdEmpresa())));
            d.add(linkTo1.withSelfRel());
            proyectosDTO.add(d);


        };
        return proyectosDTO;
    }

    @PostMapping
    public ResponseEntity<Object> registrarTransaccional(@Valid @RequestBody ProyectoListaHoraDTO proyectoDTO) {
        Proyecto obj = service.registrarTransaccional(proyectoDTO);
        //proyectos/4
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProyecto()).toUri();
        return ResponseEntity.created(location).build();
    }







}


