package com.cod.jam.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Hora")
public class Hora {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_hora")
    private Integer idHora;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "cantidad_hora")
    private Integer cantidadHora;

    @Column(name = "valor_hora_uf")
    private Integer valorHoraUF;

    public Integer getIdHora() {
        return idHora;
    }

    public void setIdHora(Integer idHora) {
        this.idHora = idHora;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidadHora() {
        return cantidadHora;
    }

    public void setCantidadHora(Integer cantidadHora) {
        this.cantidadHora = cantidadHora;
    }

    public Integer getValorHoraUF() {
        return valorHoraUF;
    }

    public void setValorHoraUF(Integer valorHoraUF) {
        this.valorHoraUF = valorHoraUF;
    }
}