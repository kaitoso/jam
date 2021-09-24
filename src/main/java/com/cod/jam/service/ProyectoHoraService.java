package com.cod.jam.service;

import com.cod.jam.model.ProyectoHora;

import java.util.List;

public interface ProyectoHoraService {
    List<ProyectoHora> listarHorasPorProyecto(Integer idProyecto);
}
