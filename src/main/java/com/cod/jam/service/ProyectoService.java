package com.cod.jam.service;

import com.cod.jam.dto.ProyectoListaHoraDTO;
import com.cod.jam.model.Proyecto;
import com.cod.jam.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProyectoService extends  ICRUD<Proyecto>{
    Proyecto registrarTransaccional(ProyectoListaHoraDTO proyectoDTO);
}
