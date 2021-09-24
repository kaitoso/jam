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

    /*
    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

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
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable("id") Integer id) throws Exception {
        return usuarioService.findById(id);
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario){
        return usuarioService.update(usuario);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        usuarioService.deleteById(id);
        return "Usuario eliminado correctamente";
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Usuario>> listarPageable(Pageable pageable) {
        Page<Usuario> usuarios = usuarioService.listarPageable(pageable);
        return new ResponseEntity<Page<Usuario>>(usuarios, HttpStatus.OK);
    }
*/


}
