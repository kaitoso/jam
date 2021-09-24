package com.cod.jam.service;

import com.cod.jam.model.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmpresaService extends ICRUD<Empresa> {

    Page<Empresa> listarPageable(Pageable pageable);
}
