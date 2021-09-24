package com.cod.jam.controller;

import com.cod.jam.model.Empresa;
import com.cod.jam.service.EmpresaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @ApiOperation(value = "Obtener todas las empresas",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Empresas")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron Empresas en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})

    @GetMapping
    public List<Empresa> findAll(){
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public Empresa findById(@PathVariable("id") Integer id) throws Exception {
        return empresaService.findById(id);
    }

    @PostMapping
    public Empresa save(@RequestBody Empresa empresa){
        return empresaService.save(empresa);
    }

    @PutMapping
    public Empresa update(@RequestBody Empresa empresa){
        return empresaService.update(empresa);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        empresaService.deleteById(id);
        return "Empresa eliminada correctamente";
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Empresa>> listarPageable(Pageable pageable) {
        Page<Empresa> empresas = empresaService.listarPageable(pageable);
        return new ResponseEntity<Page<Empresa>>(empresas, HttpStatus.OK);
    }


}
