package com.cod.jam.dto;

import com.cod.jam.model.Empresa;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

public class ProyectoDTO extends ResourceSupport implements Serializable {
    private Integer idProyecto;
    private Empresa empresa;


    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
