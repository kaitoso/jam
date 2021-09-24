package com.cod.jam.model;

import javax.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_empresa", length = 70)
    private Integer idEmpresa;

    @Column(name="nombre", length = 70)
    private String nombre;

    @Column(name="imagen_url")
    private String imagenurl;

    @ManyToOne
    @JoinColumn(name ="id_usuario", insertable =false, updatable = false)
    private Usuario usuario;

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
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


}
