package com.cod.jam.model;

import javax.persistence.*;

@Entity
@Table(name = "api")
public class Api {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_api")
    private Integer id;

    @Column(name="nombre", length = 70)
    private String nombre;

    @Column(name="url_api")
    private String urlApi;

}
