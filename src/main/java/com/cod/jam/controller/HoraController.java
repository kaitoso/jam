package com.cod.jam.controller;

import com.cod.jam.model.Hora;
import com.cod.jam.service.HoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/hora")
public class HoraController {

    @Autowired
    private HoraService service;

    @GetMapping
    public ResponseEntity<List<Hora>> listar() {
        List<Hora> lista = service.findAll();
        return new ResponseEntity<List<Hora>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hora> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Hora obj = service.findById(id);
        return new ResponseEntity<Hora>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Hora hora) {
        Hora obj = service.save(hora);
        //hora/1
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hora.getIdHora()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Hora> modificar(@Valid @RequestBody Hora hora) {
        Hora obj = service.update(hora);
        return new ResponseEntity<Hora>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
        service.deleteById(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
