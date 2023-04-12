package Mingeso.ProjectMilkStgo.repositories;

import Mingeso.ProjectMilkStgo.entities.ProveedorEntity;
import Mingeso.ProjectMilkStgo.entities.QuincenasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuincenasRepository extends JpaRepository<QuincenasEntity, String> {
    @Query("select e from QuincenasEntity e order by quincena_id desc limit 1")
    QuincenasEntity encontrarUltimo();
}
