package com.cod.jam.model;

import javax.persistence.*;

@Entity
@Table(name="proyecto_hora")
@IdClass(ProyectoHoraPK.class)
public class ProyectoHora  {
    @Id
    private Hora hora;

    @Id
    private Proyecto proyecto;

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
