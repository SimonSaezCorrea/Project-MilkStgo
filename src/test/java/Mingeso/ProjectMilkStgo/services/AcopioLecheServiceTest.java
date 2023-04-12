package Mingeso.ProjectMilkStgo.services;


import Mingeso.ProjectMilkStgo.entities.AcopioLecheEntity;
import Mingeso.ProjectMilkStgo.repositories.AcopioLecheRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AcopioLecheServiceTest {
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
        assertNotNull(acopioLecheService.ObtenerAcopioLeche());
    }


}
