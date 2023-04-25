package Mingeso.ProjectMilkStgo;

import Mingeso.ProjectMilkStgo.entities.GrasaSolidoTotalEntity;
import Mingeso.ProjectMilkStgo.repositories.GrasaSolidoTotalRepository;
import Mingeso.ProjectMilkStgo.services.GrasaSolidoTotalesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

        assertNotNull(grasaSolidoTotalRepository.encontrarPorID(grasaSolidoTotalEntity.getSolido_grasasTotal_id()));
        grasaSolidoTotalRepository.deleteById(grasaSolidoTotalEntity.getSolido_grasasTotal_id());
    }

    @Test
    void obtenerGrasaSolidoTotal() {
        grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","23","41");
        grasaSolidoTotalRepository.save(grasaSolidoTotalEntity);
        assertNotNull(grasaSolidoTotalesService.obtenerGrasaSolidoTotal());
        grasaSolidoTotalRepository.delete(grasaSolidoTotalEntity);
    }

    @Test
    void obtenerGrasaSolidoTotal_proveedorID() {
        grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","23","41");
        grasaSolidoTotalRepository.save(grasaSolidoTotalEntity);
        assertThat(grasaSolidoTotalesService.obtenerGrasaSolidoTotal(grasaSolidoTotalEntity.getProveedor_id())).isEqualTo(grasaSolidoTotalEntity);
        grasaSolidoTotalRepository.delete(grasaSolidoTotalEntity);
    }
}