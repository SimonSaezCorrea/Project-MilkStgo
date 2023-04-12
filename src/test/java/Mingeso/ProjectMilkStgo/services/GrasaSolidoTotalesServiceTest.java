package Mingeso.ProjectMilkStgo.services;

import Mingeso.ProjectMilkStgo.entities.GrasaSolidoTotalEntity;
import Mingeso.ProjectMilkStgo.repositories.GrasaSolidoTotalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GrasaSolidoTotalesServiceTest {

    @Autowired
    private GrasaSolidoTotalesService grasaSolidoTotalesService;
    @Autowired
    private GrasaSolidoTotalRepository grasaSolidoTotalRepository;
    private GrasaSolidoTotalEntity grasaSolidoTotalEntity;
    @Test
    void guardarGrasaSolidoTotal() {
        grasaSolidoTotalEntity = new GrasaSolidoTotalEntity();
        grasaSolidoTotalEntity.setGrasa("10");
        grasaSolidoTotalEntity.setSolidoTotal("30");
        grasaSolidoTotalEntity.setProveedor_id("00003");
        grasaSolidoTotalesService.guardarGrasaSolidoTotal(grasaSolidoTotalEntity);

        assertNotNull(grasaSolidoTotalRepository.encontrarPorCodigo(grasaSolidoTotalEntity.getSolido_grasasTotal_id()));
        grasaSolidoTotalRepository.deleteById(grasaSolidoTotalEntity.getSolido_grasasTotal_id());
    }

    @Test
    void obtenerGrasaSolidoTotal() {
        assertNotNull(grasaSolidoTotalesService.obtenerGrasaSolidoTotal());
    }
}