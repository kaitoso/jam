package com.cod.jam.controller;

import com.cod.jam.model.Usuario;
import com.cod.jam.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService userService;
    @ApiOperation(value = "Obtener todos los usuarios",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Usuarios")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron usuarios en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})

    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        List<Usuario> lista = userService.findAll();
        return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> lista = userService.findAll();
        return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
    }


}
