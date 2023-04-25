package Mingeso.ProjectMilkStgo;


import Mingeso.ProjectMilkStgo.entities.AcopioLecheEntity;
import Mingeso.ProjectMilkStgo.repositories.AcopioLecheRepository;
import Mingeso.ProjectMilkStgo.services.AcopioLecheService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AcopioLecheServiceTest {
    @Autowired
    private AcopioLecheService acopioLecheService;
    @Autowired
    private AcopioLecheRepository acopioLecheRepository;
    private AcopioLecheEntity acopioLecheEntity;

    @Test
    void guardarAcopioLeche(){
        acopioLecheEntity = new AcopioLecheEntity();
        acopioLecheEntity.setFecha("2021/03/18");
        acopioLecheEntity.setTurno("T");
        acopioLecheEntity.setKls_leche("90");
        acopioLecheEntity.setProveedor_id("00009");
        acopioLecheService.guardarAcopioLeche(acopioLecheEntity);

        assertNotNull(acopioLecheRepository.encontrarPorID(acopioLecheEntity.getAcopio_leche_id()));

        acopioLecheRepository.deleteById(acopioLecheEntity.getAcopio_leche_id());
    }

    @Test
    void ObtenerAcopioLeche(){
        assertNotNull(acopioLecheService.obtenerAcopioLeche());
    }

    @Test
    void obtenerAcopioLeche_conProveedor(){
        acopioLecheEntity = new AcopioLecheEntity("2022/10/14","T","00101","200");
        acopioLecheRepository.save(acopioLecheEntity);
        assertFalse(acopioLecheService.obtenerAcopioLeche("00101").isEmpty());
        acopioLecheRepository.delete(acopioLecheEntity);
    }
}
