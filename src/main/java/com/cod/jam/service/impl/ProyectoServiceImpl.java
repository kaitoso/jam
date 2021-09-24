package com.cod.jam.service.impl;

import com.cod.jam.dto.ProyectoListaHoraDTO;
import com.cod.jam.model.Empresa;
import com.cod.jam.model.Proyecto;
import com.cod.jam.repository.ProyectoHoraRepository;
import com.cod.jam.repository.ProyectoRepository;
import com.cod.jam.service.EmpresaService;
import com.cod.jam.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProyectoServiceImpl implements ProyectoService {
    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private EmpresaService empresaService;



    @Autowired
    private ProyectoHoraRepository ceRepo;

    @Override
    public Proyecto save(Proyecto obj) {

        return proyectoRepository.save(obj);
    }

    @Override
    public Proyecto update(Proyecto obj) {
        return proyectoRepository.save(obj);
    }

    @Override
    public List<Proyecto> findAll() {
        return proyectoRepository.findAll();
    }

    @Override
    public Proyecto findById(Integer id) throws Exception {
        Optional<Proyecto> op = proyectoRepository.findById(id);
        if(!op.isPresent()) {
            throw new Exception("ID NO ENCONTRADO " + id);
        }
        return op.get();
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        Optional<Proyecto> obj = proyectoRepository.findById(id);
        if(!obj.isPresent()) {
            throw new Exception("ID NO ENCONTRADO " + id);
        }
        proyectoRepository.deleteById(id);
        return true;
    }

    @Transactional
    @Override
    public Proyecto registrarTransaccional(ProyectoListaHoraDTO dto) {


        proyectoRepository.save(dto.getProyecto());

        dto.getLstHora().forEach(ex -> ceRepo.registrar(dto.getProyecto().getIdProyecto(), ex.getIdHora()));
        return dto.getProyecto();
    }







}
