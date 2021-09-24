package com.cod.jam.service.impl;

import com.cod.jam.exception.ModelNotFoundExcept;
import com.cod.jam.model.Empresa;
import com.cod.jam.model.Usuario;
import com.cod.jam.repository.EmpresaRepository;
import com.cod.jam.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;
    @Override
    public Page<Empresa> listarPageable(Pageable pageable) {
        return empresaRepository.findAll(pageable);
    }

    @Override
    public Empresa findById(Integer id) throws Exception {
        Optional<Empresa> empresaO=empresaRepository.findById(id);
        if(!empresaO.isPresent()){
            throw new ModelNotFoundExcept("ID NO ENCONTRADO: " + id);
        }
        return empresaO.isPresent() ? empresaO.get() : new Empresa();
    }

    @Override
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa save(Empresa empresa) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Empresa>> violations = validator.validate(empresa);
        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        Empresa empre= empresaRepository.save(empresa);
        return empresaRepository.save(empre);
    }

    @Override
    public Empresa update(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
    @Override
    public boolean deleteById(Integer id) throws Exception {
        Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
        if(!optionalEmpresa.isPresent()){
            throw new Exception("el id: " + id+", no se encontró");
        }
        empresaRepository.deleteById(id);
        return true;
    }
}
