package Mingeso.ProjectMilkStgo.repositories;

import Mingeso.ProjectMilkStgo.entities.AcopioLecheEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AcopioLecheRepository  extends JpaRepository<AcopioLecheEntity, Integer>{
    @Query("select e from AcopioLecheEntity e where e.acopio_leche_id = :acopio_leche_id")
    AcopioLecheEntity encontrarPorCodigo(@Param("acopio_leche_id")Integer acopio_leche_id);
}