package com.cod.jam.service;

import com.cod.jam.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioService extends ICRUD<Usuario>{


    Page<Usuario> listarPageable(Pageable pageable);


}
