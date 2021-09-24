package com.cod.jam.service.impl;

import com.cod.jam.model.ProyectoHora;
import com.cod.jam.repository.ProyectoHoraRepository;
import com.cod.jam.service.ProyectoHoraService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoHoraServiceImpl implements ProyectoHoraService {
    private ProyectoHoraRepository proyectoHoraRepository;

    @Override
    public List<ProyectoHora> listarHorasPorProyecto(Integer idProyecto){
        return proyectoHoraRepository.listarHorasPorProyecto(idProyecto);
    }

}
