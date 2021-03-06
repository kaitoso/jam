package com.cod.jam.repository;

import com.cod.jam.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LoginRepository extends JpaRepository<Usuario, Integer> {

    @Query("FROM Usuario us where us.username = :usuario")
    Usuario verificarNombreUsuario(@Param("usuario") String usuario) throws Exception;



    @Transactional
    @Modifying
    @Query("UPDATE Usuario us SET us.password = :clave WHERE us.username = :nombre")
    void cambiarClave(@Param("clave") String clave, @Param("nombre") String nombre) throws Exception;

}
