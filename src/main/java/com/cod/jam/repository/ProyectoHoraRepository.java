package com.cod.jam.repository;

import com.cod.jam.model.ProyectoHora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoHoraRepository extends JpaRepository<ProyectoHora, Integer> {
    //@Transactional
    @Modifying
    @Query(value = "INSERT INTO proyecto_hora(id_proyecto, id_hora) VALUES (:idProyecto, :idHora)", nativeQuery = true)
    Integer registrar(@Param("idProyecto") Integer idProyecto, @Param("idHora") Integer idHora);

    @Query("from ProyectoHora ce where ce.proyecto.idProyecto = :idProyecto")
    List<ProyectoHora> listarHorasPorProyecto(@Param("idProyecto") Integer idProyecto);
}
