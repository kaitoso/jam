package com.cod.jam.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idUsuario;

    @Column(name="username", length = 70)
    private String username;

    @Column(name="email", length = 70)
    private String email;

    @Column(name="password", length = 70)
    private String password;

    @OneToMany(mappedBy ="usuario")
    private List<Empresa> empresas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
    private List<Rol> rols;

    public Integer getId() {
        return idUsuario;
    }

    public void setId(Integer idPaciente) {
        this.idUsuario = idPaciente;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public List<Rol> getRols() {
        return rols;
    }

    public void setRols(List<Rol> rols) {
        this.rols = rols;
    }
}
