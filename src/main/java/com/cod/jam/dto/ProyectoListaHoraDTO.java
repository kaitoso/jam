package com.cod.jam.dto;

import com.cod.jam.model.Hora;
import com.cod.jam.model.Proyecto;

import java.io.Serializable;
import java.util.List;

public class ProyectoListaHoraDTO implements Serializable {
    private Proyecto proyecto;
    private List<Hora> lstHora;

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<Hora> getLstHora() {
        return lstHora;
    }

    public void setLstHora(List<Hora> lstHora) {
        this.lstHora = lstHora;
    }
}
