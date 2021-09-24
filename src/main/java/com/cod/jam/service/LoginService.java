package com.cod.jam.service;

import com.cod.jam.model.Usuario;

public interface LoginService {
    Usuario verificarNombreUsuario(String usuario) throws Exception;
    int cambiarClave(String clave, String nombre) throws Exception;
}
