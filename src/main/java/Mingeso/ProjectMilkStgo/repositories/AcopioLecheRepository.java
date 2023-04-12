package Mingeso.ProjectMilkStgo.repositories;

import Mingeso.ProjectMilkStgo.entities.AcopioLecheEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AcopioLecheRepository  extends JpaRepository<AcopioLecheEntity, Integer>{
    @Query("select e from AcopioLecheEntity e where e.acopio_leche_id = :acopio_leche_id")
    AcopioLecheEntity encontrarPorID(@Param("acopio_leche_id")Integer acopio_leche_id);

    @Query("select e from AcopioLecheEntity e where e.proveedor_id = :proveedor_id")
    List<AcopioLecheEntity> encontrarPorProveedor(@Param("proveedor_id")String proveedor_id);
}