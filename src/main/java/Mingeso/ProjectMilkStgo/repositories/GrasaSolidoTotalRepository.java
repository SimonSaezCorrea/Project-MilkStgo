package Mingeso.ProjectMilkStgo.repositories;

import Mingeso.ProjectMilkStgo.entities.GrasaSolidoTotalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GrasaSolidoTotalRepository extends JpaRepository<GrasaSolidoTotalEntity, Integer> {
    @Query("select e from GrasaSolidoTotalEntity e where e.solido_grasasTotal_id = :solido_grasasTotal_id")
    GrasaSolidoTotalEntity encontrarPorCodigo(@Param("solido_grasasTotal_id")Integer solido_grasasTotal_id);
}