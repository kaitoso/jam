package com.cod.jam.repository;

import com.cod.jam.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findOneByUsername(String username);
}
