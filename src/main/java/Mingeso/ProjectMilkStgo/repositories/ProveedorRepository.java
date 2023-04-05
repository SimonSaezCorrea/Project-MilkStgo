package Mingeso.ProjectMilkStgo.repositories;

import Mingeso.ProjectMilkStgo.entities.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProveedorRepository  extends JpaRepository<ProveedorEntity, String>{
    @Query("select e from ProveedorEntity e where e.nombre = :nombre")
    ProveedorEntity findByNameCustomQuery(@Param("nombre") String nombre);

    @Query("select e.categoria from ProveedorEntity e where e.proveedor_id = :proveedor_id")
    String findCategory(@Param("proveedor_id") String codigo);

    @Query("select e from ProveedorEntity e where e.proveedor_id = :proveedor_id")
    ProveedorEntity findByCodigo(@Param("proveedor_id")String codigo);
}