package com.cod.jam.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ProyectoHoraPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_hora", nullable = false)
    private Hora hora;

    @ManyToOne
    @JoinColumn(name = "id_proyecto", nullable = false)
    private Proyecto proyecto;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((proyecto == null) ? 0 : proyecto.hashCode());
        result = prime * result + ((hora == null) ? 0 : hora.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProyectoHoraPK other = (ProyectoHoraPK) obj;
        if (proyecto == null) {
            if (other.proyecto != null)
                return false;
        } else if (!proyecto.equals(other.proyecto))
            return false;
        if (hora == null) {
            if (other.hora != null)
                return false;
        } else if (!hora.equals(other.hora))
            return false;
        return true;
    }

}
