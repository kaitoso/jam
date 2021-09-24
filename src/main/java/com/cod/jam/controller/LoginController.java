package com.cod.jam.controller;


import com.cod.jam.model.ResetToken;
import com.cod.jam.service.LoginService;
import com.cod.jam.service.ResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @Autowired
    private ResetTokenService tokenService;



    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Value("${reintos.token}")
    private String count;



    @GetMapping(value = "/restablecer/verificar/{token}")
    public ResponseEntity<Integer> restablecerClave(@PathVariable("token") String token) {
        int rpta = 0;
        try {
            if (token != null && !token.isEmpty()) {
                ResetToken rt = tokenService.findByToken(token);
                if (rt != null && rt.getId() > 0) {
                    if (!rt.estaExpirado()) {
                        if(!rt.getCount().equals(count)){
                            rpta = 1;
                        }
                    }
                }
            }
        } catch (Exception e) {
            return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
    }


    @PostMapping(value = "/restablecer/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> restablecerClave(@PathVariable("token") String token, @RequestBody String clave ) {
        int rpta = 0;
        try {
            ResetToken rt = tokenService.findByToken(token);
            String claveHash = bcrypt.encode(clave);
            rpta = service.cambiarClave(claveHash, rt.getUser().getUsername());
            tokenService.eliminar(rt);
        } catch (Exception e) {
            return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
    }
}
