package com.cod.jam.controller;

import com.cod.jam.model.Api;
import com.cod.jam.model.Usuario;
import com.cod.jam.service.ApiService;
import com.cod.jam.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }
    @ApiOperation(value = "Obtener todas las apis",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "APIS")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron listados de apis en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})

    @GetMapping
    public List<Api> findAll(){
        return apiService.findAll();
    }

    @GetMapping("/{id}")
    public Api findById(@PathVariable("id") Integer id) throws Exception {
        return apiService.findById(id);
    }

    @PostMapping
    public Api save(@RequestBody Api api){
        return apiService.save(api);
    }

    @PutMapping
    public Api update(@RequestBody Api api){
        return apiService.update(api);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        apiService.deleteById(id);
        return "Api eliminada correctamente";
    }
}
