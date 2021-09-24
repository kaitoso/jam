package com.cod.jam.service.impl;

import com.cod.jam.model.Hora;
import com.cod.jam.repository.HoraRepository;
import com.cod.jam.service.HoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoraServiceImpl implements HoraService {
    @Autowired
    private HoraRepository horaRepository;

    @Override
    public Hora save(Hora obj) {
        return horaRepository.save(obj);
    }

    @Override
    public Hora update(Hora obj) {
        return horaRepository.save(obj);
    }

    @Override
    public List<Hora> findAll() {
        return horaRepository.findAll();
    }

    @Override
    public Hora findById(Integer id) throws Exception {
        Optional<Hora> hr = horaRepository.findById(id);
        if (!hr.isPresent()) {
            throw new Exception("ID NO ENCONTRADO" + id);
        }
        return hr.get();
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        Optional<Hora> hr = horaRepository.findById(id);
        if (!hr.isPresent()) {
            throw new Exception("ID NO ENCONTRADO" + id);
        }
        horaRepository.deleteById(id);
        return true;
    }
}
