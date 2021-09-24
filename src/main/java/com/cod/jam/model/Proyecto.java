package com.cod.jam.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_proyecto")
    private Integer idProyecto;

    @Column(name="nombre", length = 70)
    private String nombre;

    @Column(name="imagen_url")
    private String imagenurl;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;



    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenurl() {
        return imagenurl;
    }

    public void setImagenurl(String imagenurl) {
        this.imagenurl = imagenurl;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


}
