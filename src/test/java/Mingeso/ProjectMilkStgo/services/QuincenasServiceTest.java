package Mingeso.ProjectMilkStgo.services;

import Mingeso.ProjectMilkStgo.entities.AcopioLecheEntity;
import Mingeso.ProjectMilkStgo.entities.GrasaSolidoTotalEntity;
import Mingeso.ProjectMilkStgo.entities.ProveedorEntity;
import Mingeso.ProjectMilkStgo.entities.QuincenasEntity;
import Mingeso.ProjectMilkStgo.repositories.AcopioLecheRepository;
import Mingeso.ProjectMilkStgo.repositories.GrasaSolidoTotalRepository;
import Mingeso.ProjectMilkStgo.repositories.ProveedorRepository;
import Mingeso.ProjectMilkStgo.repositories.QuincenasRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuincenasServiceTest {

    @Autowired
    private QuincenasService quincenasService;
    @Autowired
    private QuincenasRepository quincenasRepository;
    @Autowired
    private AcopioLecheRepository acopioLecheRepository;
    @Autowired
    private GrasaSolidoTotalRepository grasaSolidoTotalRepository;
    @Autowired
    private ProveedorRepository proveedorRepository;

    private List<AcopioLecheEntity> listAcopioLecheEntity;
    private ProveedorEntity proveedorEntity;
    private QuincenasEntity quincenasEntity;
    private GrasaSolidoTotalEntity grasaSolidoTotalEntity;

    @Test
    void sueldoCategoria_categoriaA() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        proveedorEntity = new ProveedorEntity("00101","Anonimo","A","Si");
        int sueldo = quincenasService.sueldoCategoria(listAcopioLecheEntity, proveedorEntity);
        assertThat(sueldo).isEqualTo(70000);
    }
    @Test
    void sueldoCategoria_categoriaB() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        proveedorEntity = new ProveedorEntity("00101","Anonimo","B","Si");
        int sueldo = quincenasService.sueldoCategoria(listAcopioLecheEntity, proveedorEntity);
        assertThat(sueldo).isEqualTo(55000);
    }
    @Test
    void sueldoCategoria_categoriaC() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        proveedorEntity = new ProveedorEntity("00101","Anonimo","C","Si");
        int sueldo = quincenasService.sueldoCategoria(listAcopioLecheEntity, proveedorEntity);
        assertThat(sueldo).isEqualTo(40000);
    }
    @Test
    void sueldoCategoria_categoriaD() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        proveedorEntity = new ProveedorEntity("00101","Anonimo","D","Si");
        int sueldo = quincenasService.sueldoCategoria(listAcopioLecheEntity, proveedorEntity);
        assertThat(sueldo).isEqualTo(25000);
    }

    @Test
    void sueldoGrasa_menor20() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        GrasaSolidoTotalEntity grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","15","40");
        int sueldo = quincenasService.sueldoGrasa(listAcopioLecheEntity, grasaSolidoTotalEntity);
        assertThat(sueldo).isEqualTo(3000);
    }
    @Test
    void sueldoGrasa_menor45() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        GrasaSolidoTotalEntity grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","35","40");
        int sueldo = quincenasService.sueldoGrasa(listAcopioLecheEntity, grasaSolidoTotalEntity);
        assertThat(sueldo).isEqualTo(8000);
    }
    @Test
    void sueldoGrasa_otro() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        GrasaSolidoTotalEntity grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","65","40");
        int sueldo = quincenasService.sueldoGrasa(listAcopioLecheEntity, grasaSolidoTotalEntity);
        assertThat(sueldo).isEqualTo(12000);
    }

    @Test
    void sueldoSolido_menor7() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        GrasaSolidoTotalEntity grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","65","5");
        int sueldo = quincenasService.sueldoSolido(listAcopioLecheEntity, grasaSolidoTotalEntity);
        assertThat(sueldo).isEqualTo(-13000);
    }
    @Test
    void sueldoSolido_menor18() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        GrasaSolidoTotalEntity grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","65","15");
        int sueldo = quincenasService.sueldoSolido(listAcopioLecheEntity, grasaSolidoTotalEntity);
        assertThat(sueldo).isEqualTo(-9000);
    }
    @Test
    void sueldoSolido_menor35() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        GrasaSolidoTotalEntity grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","65","25");
        int sueldo = quincenasService.sueldoSolido(listAcopioLecheEntity, grasaSolidoTotalEntity);
        assertThat(sueldo).isEqualTo(9500);
    }
    @Test
    void sueldoSolido_otro() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        GrasaSolidoTotalEntity grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","65","45");
        int sueldo = quincenasService.sueldoSolido(listAcopioLecheEntity, grasaSolidoTotalEntity);
        assertThat(sueldo).isEqualTo(15000);
    }

    @Test
    void bonificacionFrecuencia_maniana() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","M","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","M","00101","40");
        AcopioLecheEntity acopioLecheEntity4 = new AcopioLecheEntity("2023/03/21","M","00101","50");
        AcopioLecheEntity acopioLecheEntity5 = new AcopioLecheEntity("2023/03/22","M","00101","60");
        AcopioLecheEntity acopioLecheEntity6 = new AcopioLecheEntity("2023/03/23","M","00101","70");
        AcopioLecheEntity acopioLecheEntity7 = new AcopioLecheEntity("2023/03/24","M","00101","80");
        AcopioLecheEntity acopioLecheEntity8 = new AcopioLecheEntity("2023/03/25","M","00101","90");
        AcopioLecheEntity acopioLecheEntity9 = new AcopioLecheEntity("2023/03/26","M","00101","100");
        AcopioLecheEntity acopioLecheEntity10 = new AcopioLecheEntity("2023/03/27","M","00101","110");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        listAcopioLecheEntity.add(acopioLecheEntity4);
        listAcopioLecheEntity.add(acopioLecheEntity5);
        listAcopioLecheEntity.add(acopioLecheEntity6);
        listAcopioLecheEntity.add(acopioLecheEntity7);
        listAcopioLecheEntity.add(acopioLecheEntity8);
        listAcopioLecheEntity.add(acopioLecheEntity9);
        listAcopioLecheEntity.add(acopioLecheEntity10);

        int bonificacion = quincenasService.bonificacionFrecuencia(listAcopioLecheEntity);

        assertThat(bonificacion).isEqualTo(12);
    }
    @Test
    void bonificacionFrecuencia_tarde() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","T","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","T","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        AcopioLecheEntity acopioLecheEntity4 = new AcopioLecheEntity("2023/03/21","T","00101","50");
        AcopioLecheEntity acopioLecheEntity5 = new AcopioLecheEntity("2023/03/22","T","00101","60");
        AcopioLecheEntity acopioLecheEntity6 = new AcopioLecheEntity("2023/03/23","T","00101","70");
        AcopioLecheEntity acopioLecheEntity7 = new AcopioLecheEntity("2023/03/24","T","00101","80");
        AcopioLecheEntity acopioLecheEntity8 = new AcopioLecheEntity("2023/03/25","T","00101","90");
        AcopioLecheEntity acopioLecheEntity9 = new AcopioLecheEntity("2023/03/26","T","00101","100");
        AcopioLecheEntity acopioLecheEntity10 = new AcopioLecheEntity("2023/03/27","T","00101","110");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        listAcopioLecheEntity.add(acopioLecheEntity4);
        listAcopioLecheEntity.add(acopioLecheEntity5);
        listAcopioLecheEntity.add(acopioLecheEntity6);
        listAcopioLecheEntity.add(acopioLecheEntity7);
        listAcopioLecheEntity.add(acopioLecheEntity8);
        listAcopioLecheEntity.add(acopioLecheEntity9);
        listAcopioLecheEntity.add(acopioLecheEntity10);

        int bonificacion = quincenasService.bonificacionFrecuencia(listAcopioLecheEntity);

        assertThat(bonificacion).isEqualTo(8);
    }
    @Test
    void bonificacionFrecuencia_manianaTarde() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","M","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/18","T","00101","20");
        AcopioLecheEntity acopioLecheEntity4 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity5 = new AcopioLecheEntity("2023/03/19","T","00101","30");
        AcopioLecheEntity acopioLecheEntity6 = new AcopioLecheEntity("2023/03/20","M","00101","40");
        AcopioLecheEntity acopioLecheEntity7 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        AcopioLecheEntity acopioLecheEntity8 = new AcopioLecheEntity("2023/03/21","M","00101","50");
        AcopioLecheEntity acopioLecheEntity9 = new AcopioLecheEntity("2023/03/21","T","00101","50");
        AcopioLecheEntity acopioLecheEntity10 = new AcopioLecheEntity("2023/03/22","M","00101","60");
        AcopioLecheEntity acopioLecheEntity11 = new AcopioLecheEntity("2023/03/22","T","00101","60");
        AcopioLecheEntity acopioLecheEntity12 = new AcopioLecheEntity("2023/03/23","M","00101","70");
        AcopioLecheEntity acopioLecheEntity13 = new AcopioLecheEntity("2023/03/23","T","00101","70");
        AcopioLecheEntity acopioLecheEntity14 = new AcopioLecheEntity("2023/03/24","M","00101","80");
        AcopioLecheEntity acopioLecheEntity15 = new AcopioLecheEntity("2023/03/24","T","00101","80");
        AcopioLecheEntity acopioLecheEntity16 = new AcopioLecheEntity("2023/03/25","M","00101","90");
        AcopioLecheEntity acopioLecheEntity17 = new AcopioLecheEntity("2023/03/25","T","00101","90");
        AcopioLecheEntity acopioLecheEntity18 = new AcopioLecheEntity("2023/03/26","M","00101","100");
        AcopioLecheEntity acopioLecheEntity19 = new AcopioLecheEntity("2023/03/26","T","00101","100");
        AcopioLecheEntity acopioLecheEntity20 = new AcopioLecheEntity("2023/03/27","M","00101","110");
        AcopioLecheEntity acopioLecheEntity21 = new AcopioLecheEntity("2023/03/27","T","00101","110");

        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        listAcopioLecheEntity.add(acopioLecheEntity4);
        listAcopioLecheEntity.add(acopioLecheEntity5);
        listAcopioLecheEntity.add(acopioLecheEntity6);
        listAcopioLecheEntity.add(acopioLecheEntity7);
        listAcopioLecheEntity.add(acopioLecheEntity8);
        listAcopioLecheEntity.add(acopioLecheEntity9);
        listAcopioLecheEntity.add(acopioLecheEntity10);
        listAcopioLecheEntity.add(acopioLecheEntity11);
        listAcopioLecheEntity.add(acopioLecheEntity12);
        listAcopioLecheEntity.add(acopioLecheEntity13);
        listAcopioLecheEntity.add(acopioLecheEntity14);
        listAcopioLecheEntity.add(acopioLecheEntity15);
        listAcopioLecheEntity.add(acopioLecheEntity16);
        listAcopioLecheEntity.add(acopioLecheEntity17);
        listAcopioLecheEntity.add(acopioLecheEntity18);
        listAcopioLecheEntity.add(acopioLecheEntity19);
        listAcopioLecheEntity.add(acopioLecheEntity20);
        listAcopioLecheEntity.add(acopioLecheEntity21);

        int bonificacion = quincenasService.bonificacionFrecuencia(listAcopioLecheEntity);

        assertThat(bonificacion).isEqualTo(20);
    }
    @Test
    void bonificacionFrecuencia_manianaTarde_maniana() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","M","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/18","T","00101","20");
        AcopioLecheEntity acopioLecheEntity4 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity5 = new AcopioLecheEntity("2023/03/19","T","00101","30");
        AcopioLecheEntity acopioLecheEntity6 = new AcopioLecheEntity("2023/03/20","M","00101","40");
        AcopioLecheEntity acopioLecheEntity7 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        AcopioLecheEntity acopioLecheEntity8 = new AcopioLecheEntity("2023/03/21","M","00101","50");
        AcopioLecheEntity acopioLecheEntity10 = new AcopioLecheEntity("2023/03/22","M","00101","60");
        AcopioLecheEntity acopioLecheEntity11 = new AcopioLecheEntity("2023/03/22","T","00101","60");
        AcopioLecheEntity acopioLecheEntity12 = new AcopioLecheEntity("2023/03/23","M","00101","70");
        AcopioLecheEntity acopioLecheEntity13 = new AcopioLecheEntity("2023/03/23","T","00101","70");
        AcopioLecheEntity acopioLecheEntity14 = new AcopioLecheEntity("2023/03/24","M","00101","80");
        AcopioLecheEntity acopioLecheEntity15 = new AcopioLecheEntity("2023/03/24","T","00101","80");
        AcopioLecheEntity acopioLecheEntity16 = new AcopioLecheEntity("2023/03/25","M","00101","90");
        AcopioLecheEntity acopioLecheEntity17 = new AcopioLecheEntity("2023/03/25","T","00101","90");
        AcopioLecheEntity acopioLecheEntity18 = new AcopioLecheEntity("2023/03/26","M","00101","100");
        AcopioLecheEntity acopioLecheEntity19 = new AcopioLecheEntity("2023/03/26","T","00101","100");
        AcopioLecheEntity acopioLecheEntity20 = new AcopioLecheEntity("2023/03/27","M","00101","110");
        AcopioLecheEntity acopioLecheEntity21 = new AcopioLecheEntity("2023/03/27","T","00101","110");

        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        listAcopioLecheEntity.add(acopioLecheEntity4);
        listAcopioLecheEntity.add(acopioLecheEntity5);
        listAcopioLecheEntity.add(acopioLecheEntity6);
        listAcopioLecheEntity.add(acopioLecheEntity7);
        listAcopioLecheEntity.add(acopioLecheEntity8);
        listAcopioLecheEntity.add(acopioLecheEntity10);
        listAcopioLecheEntity.add(acopioLecheEntity11);
        listAcopioLecheEntity.add(acopioLecheEntity12);
        listAcopioLecheEntity.add(acopioLecheEntity13);
        listAcopioLecheEntity.add(acopioLecheEntity14);
        listAcopioLecheEntity.add(acopioLecheEntity15);
        listAcopioLecheEntity.add(acopioLecheEntity16);
        listAcopioLecheEntity.add(acopioLecheEntity17);
        listAcopioLecheEntity.add(acopioLecheEntity18);
        listAcopioLecheEntity.add(acopioLecheEntity19);
        listAcopioLecheEntity.add(acopioLecheEntity20);
        listAcopioLecheEntity.add(acopioLecheEntity21);

        int bonificacion = quincenasService.bonificacionFrecuencia(listAcopioLecheEntity);

        assertThat(bonificacion).isEqualTo(12);
    }
    @Test
    void bonificacionFrecuencia_manianaTarde_tarde() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","M","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/18","T","00101","20");
        AcopioLecheEntity acopioLecheEntity4 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity5 = new AcopioLecheEntity("2023/03/19","T","00101","30");
        AcopioLecheEntity acopioLecheEntity7 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        AcopioLecheEntity acopioLecheEntity8 = new AcopioLecheEntity("2023/03/21","M","00101","50");
        AcopioLecheEntity acopioLecheEntity9 = new AcopioLecheEntity("2023/03/21","T","00101","50");
        AcopioLecheEntity acopioLecheEntity10 = new AcopioLecheEntity("2023/03/22","M","00101","60");
        AcopioLecheEntity acopioLecheEntity11 = new AcopioLecheEntity("2023/03/22","T","00101","60");
        AcopioLecheEntity acopioLecheEntity12 = new AcopioLecheEntity("2023/03/23","M","00101","70");
        AcopioLecheEntity acopioLecheEntity13 = new AcopioLecheEntity("2023/03/23","T","00101","70");
        AcopioLecheEntity acopioLecheEntity14 = new AcopioLecheEntity("2023/03/24","M","00101","80");
        AcopioLecheEntity acopioLecheEntity15 = new AcopioLecheEntity("2023/03/24","T","00101","80");
        AcopioLecheEntity acopioLecheEntity16 = new AcopioLecheEntity("2023/03/25","M","00101","90");
        AcopioLecheEntity acopioLecheEntity17 = new AcopioLecheEntity("2023/03/25","T","00101","90");
        AcopioLecheEntity acopioLecheEntity18 = new AcopioLecheEntity("2023/03/26","M","00101","100");
        AcopioLecheEntity acopioLecheEntity19 = new AcopioLecheEntity("2023/03/26","T","00101","100");
        AcopioLecheEntity acopioLecheEntity20 = new AcopioLecheEntity("2023/03/27","M","00101","110");
        AcopioLecheEntity acopioLecheEntity21 = new AcopioLecheEntity("2023/03/27","T","00101","110");

        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        listAcopioLecheEntity.add(acopioLecheEntity4);
        listAcopioLecheEntity.add(acopioLecheEntity5);
        listAcopioLecheEntity.add(acopioLecheEntity7);
        listAcopioLecheEntity.add(acopioLecheEntity8);
        listAcopioLecheEntity.add(acopioLecheEntity9);
        listAcopioLecheEntity.add(acopioLecheEntity10);
        listAcopioLecheEntity.add(acopioLecheEntity11);
        listAcopioLecheEntity.add(acopioLecheEntity12);
        listAcopioLecheEntity.add(acopioLecheEntity13);
        listAcopioLecheEntity.add(acopioLecheEntity14);
        listAcopioLecheEntity.add(acopioLecheEntity15);
        listAcopioLecheEntity.add(acopioLecheEntity16);
        listAcopioLecheEntity.add(acopioLecheEntity17);
        listAcopioLecheEntity.add(acopioLecheEntity18);
        listAcopioLecheEntity.add(acopioLecheEntity19);
        listAcopioLecheEntity.add(acopioLecheEntity20);
        listAcopioLecheEntity.add(acopioLecheEntity21);

        int bonificacion = quincenasService.bonificacionFrecuencia(listAcopioLecheEntity);

        assertThat(bonificacion).isEqualTo(12);
    }
    @Test
    void bonificacionFrecuencia_maniana_tarde() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","M","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        AcopioLecheEntity acopioLecheEntity4 = new AcopioLecheEntity("2023/03/21","M","00101","50");
        AcopioLecheEntity acopioLecheEntity5 = new AcopioLecheEntity("2023/03/22","M","00101","60");
        AcopioLecheEntity acopioLecheEntity6 = new AcopioLecheEntity("2023/03/23","M","00101","70");
        AcopioLecheEntity acopioLecheEntity7 = new AcopioLecheEntity("2023/03/24","M","00101","80");
        AcopioLecheEntity acopioLecheEntity8 = new AcopioLecheEntity("2023/03/25","M","00101","90");
        AcopioLecheEntity acopioLecheEntity9 = new AcopioLecheEntity("2023/03/26","M","00101","100");
        AcopioLecheEntity acopioLecheEntity10 = new AcopioLecheEntity("2023/03/27","M","00101","110");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        listAcopioLecheEntity.add(acopioLecheEntity4);
        listAcopioLecheEntity.add(acopioLecheEntity5);
        listAcopioLecheEntity.add(acopioLecheEntity6);
        listAcopioLecheEntity.add(acopioLecheEntity7);
        listAcopioLecheEntity.add(acopioLecheEntity8);
        listAcopioLecheEntity.add(acopioLecheEntity9);
        listAcopioLecheEntity.add(acopioLecheEntity10);

        int bonificacion = quincenasService.bonificacionFrecuencia(listAcopioLecheEntity);

        assertThat(bonificacion).isEqualTo(12);
    }
    @Test
    void bonificacionFrecuencia_tarde_maniana() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","T","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","T","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        AcopioLecheEntity acopioLecheEntity4 = new AcopioLecheEntity("2023/03/21","T","00101","50");
        AcopioLecheEntity acopioLecheEntity5 = new AcopioLecheEntity("2023/03/22","M","00101","60");
        AcopioLecheEntity acopioLecheEntity6 = new AcopioLecheEntity("2023/03/23","T","00101","70");
        AcopioLecheEntity acopioLecheEntity7 = new AcopioLecheEntity("2023/03/24","T","00101","80");
        AcopioLecheEntity acopioLecheEntity8 = new AcopioLecheEntity("2023/03/25","T","00101","90");
        AcopioLecheEntity acopioLecheEntity9 = new AcopioLecheEntity("2023/03/26","T","00101","100");
        AcopioLecheEntity acopioLecheEntity10 = new AcopioLecheEntity("2023/03/28","T","00101","110");
        AcopioLecheEntity acopioLecheEntity11 = new AcopioLecheEntity("2023/03/29","T","00101","110");
        AcopioLecheEntity acopioLecheEntity12 = new AcopioLecheEntity("2023/03/30","T","00101","110");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        listAcopioLecheEntity.add(acopioLecheEntity4);
        listAcopioLecheEntity.add(acopioLecheEntity5);
        listAcopioLecheEntity.add(acopioLecheEntity6);
        listAcopioLecheEntity.add(acopioLecheEntity7);
        listAcopioLecheEntity.add(acopioLecheEntity8);
        listAcopioLecheEntity.add(acopioLecheEntity9);
        listAcopioLecheEntity.add(acopioLecheEntity10);
        listAcopioLecheEntity.add(acopioLecheEntity11);
        listAcopioLecheEntity.add(acopioLecheEntity12);

        int bonificacion = quincenasService.bonificacionFrecuencia(listAcopioLecheEntity);

        assertThat(bonificacion).isEqualTo(12);
    }
    @Test
    void bonificacionFrecuencia_noHayBonificacion() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","M","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/18","T","00101","20");
        AcopioLecheEntity acopioLecheEntity4 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity5 = new AcopioLecheEntity("2023/03/19","T","00101","30");
        AcopioLecheEntity acopioLecheEntity6 = new AcopioLecheEntity("2023/03/20","M","00101","40");
        AcopioLecheEntity acopioLecheEntity7 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        AcopioLecheEntity acopioLecheEntity8 = new AcopioLecheEntity("2023/03/21","M","00101","50");
        AcopioLecheEntity acopioLecheEntity9 = new AcopioLecheEntity("2023/03/21","T","00101","50");
        AcopioLecheEntity acopioLecheEntity10 = new AcopioLecheEntity("2023/03/22","M","00101","60");
        AcopioLecheEntity acopioLecheEntity11 = new AcopioLecheEntity("2023/03/22","T","00101","60");
        AcopioLecheEntity acopioLecheEntity14 = new AcopioLecheEntity("2023/03/24","M","00101","80");
        AcopioLecheEntity acopioLecheEntity15 = new AcopioLecheEntity("2023/03/24","T","00101","80");
        AcopioLecheEntity acopioLecheEntity16 = new AcopioLecheEntity("2023/03/25","M","00101","90");
        AcopioLecheEntity acopioLecheEntity17 = new AcopioLecheEntity("2023/03/25","T","00101","90");
        AcopioLecheEntity acopioLecheEntity18 = new AcopioLecheEntity("2023/03/26","M","00101","100");
        AcopioLecheEntity acopioLecheEntity19 = new AcopioLecheEntity("2023/03/26","T","00101","100");
        AcopioLecheEntity acopioLecheEntity20 = new AcopioLecheEntity("2023/03/27","M","00101","110");
        AcopioLecheEntity acopioLecheEntity21 = new AcopioLecheEntity("2023/03/27","T","00101","110");

        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);
        listAcopioLecheEntity.add(acopioLecheEntity4);
        listAcopioLecheEntity.add(acopioLecheEntity5);
        listAcopioLecheEntity.add(acopioLecheEntity6);
        listAcopioLecheEntity.add(acopioLecheEntity7);
        listAcopioLecheEntity.add(acopioLecheEntity8);
        listAcopioLecheEntity.add(acopioLecheEntity9);
        listAcopioLecheEntity.add(acopioLecheEntity10);
        listAcopioLecheEntity.add(acopioLecheEntity11);
        listAcopioLecheEntity.add(acopioLecheEntity14);
        listAcopioLecheEntity.add(acopioLecheEntity15);
        listAcopioLecheEntity.add(acopioLecheEntity16);
        listAcopioLecheEntity.add(acopioLecheEntity17);
        listAcopioLecheEntity.add(acopioLecheEntity18);
        listAcopioLecheEntity.add(acopioLecheEntity19);
        listAcopioLecheEntity.add(acopioLecheEntity20);
        listAcopioLecheEntity.add(acopioLecheEntity21);

        int bonificacion = quincenasService.bonificacionFrecuencia(listAcopioLecheEntity);

        assertThat(bonificacion).isEqualTo(0);
    }

    @Test
    void descuentoVariacionLeche_noHayVariacion() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);

        quincenasEntity = new QuincenasEntity(80,11,22,"00101");
        quincenasRepository.save(quincenasEntity);
        int descuento = quincenasService.descuentoVariacionLeche(listAcopioLecheEntity);
        assertThat(descuento).isEqualTo(0);
        quincenasRepository.delete(quincenasEntity);
    }
    @Test
    void descuentoVariacionLeche_variacionMenor9() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);

        quincenasEntity = new QuincenasEntity(105,11,22,"00101");
        quincenasRepository.save(quincenasEntity);
        int descuento = quincenasService.descuentoVariacionLeche(listAcopioLecheEntity);
        assertThat(descuento).isEqualTo(0);
        quincenasRepository.delete(quincenasEntity);
    }
    @Test
    void descuentoVariacionLeche_variacionMenor26() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);

        quincenasEntity = new QuincenasEntity(124,11,22,"00101");
        quincenasRepository.save(quincenasEntity);
        int descuento = quincenasService.descuentoVariacionLeche(listAcopioLecheEntity);
        assertThat(descuento).isEqualTo(7);
        quincenasRepository.delete(quincenasEntity);
    }
    @Test
    void descuentoVariacionLeche_variacionMenor41() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);

        quincenasEntity = new QuincenasEntity(147,11,22,"00101");
        quincenasRepository.save(quincenasEntity);
        int descuento = quincenasService.descuentoVariacionLeche(listAcopioLecheEntity);
        assertThat(descuento).isEqualTo(20);
        quincenasRepository.delete(quincenasEntity);
    }
    @Test
    void descuentoVariacionLeche_otro() {
        AcopioLecheEntity acopioLecheEntity = new AcopioLecheEntity("2023/03/17","T","00101","10");
        AcopioLecheEntity acopioLecheEntity1 = new AcopioLecheEntity("2023/03/18","M","00101","20");
        AcopioLecheEntity acopioLecheEntity2 = new AcopioLecheEntity("2023/03/19","M","00101","30");
        AcopioLecheEntity acopioLecheEntity3 = new AcopioLecheEntity("2023/03/20","T","00101","40");
        listAcopioLecheEntity = new ArrayList<>();
        listAcopioLecheEntity.add(acopioLecheEntity);
        listAcopioLecheEntity.add(acopioLecheEntity1);
        listAcopioLecheEntity.add(acopioLecheEntity2);
        listAcopioLecheEntity.add(acopioLecheEntity3);

        quincenasEntity = new QuincenasEntity(176,11,22,"00101");
        quincenasRepository.save(quincenasEntity);
        int descuento = quincenasService.descuentoVariacionLeche(listAcopioLecheEntity);
        assertThat(descuento).isEqualTo(30);
        quincenasRepository.delete(quincenasEntity);
    }

    @Test
    void descuentoVariacionGrasa_NoHayVariacion() {
        grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","25","45");
        quincenasEntity = new QuincenasEntity(176,11,22,"00101");
        quincenasRepository.save(quincenasEntity);
        int descuento = quincenasService.descuentoVariacionGrasa(grasaSolidoTotalEntity);
        assertThat(descuento).isEqualTo(0);
        quincenasRepository.delete(quincenasEntity);
    }
    @Test
    void descuentoVariacionGrasa_variacionMenor15() {
        grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","25","45");
        quincenasEntity = new QuincenasEntity(176,26,22,"00101");
        quincenasRepository.save(quincenasEntity);
        int descuento = quincenasService.descuentoVariacionGrasa(grasaSolidoTotalEntity);
        assertThat(descuento).isEqualTo(0);
        quincenasRepository.delete(quincenasEntity);
    }
    @Test
    void descuentoVariacionGrasa_variacionMenor25() {
        grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","25","45");
        quincenasEntity = new QuincenasEntity(176,30,22,"00101");
        quincenasRepository.save(quincenasEntity);
        int descuento = quincenasService.descuentoVariacionGrasa(grasaSolidoTotalEntity);
        assertThat(descuento).isEqualTo(12);
        quincenasRepository.delete(quincenasEntity);
    }
    @Test
    void descuentoVariacionGrasa_variacionMenor40() {
        grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","25","45");
        quincenasEntity = new QuincenasEntity(176,37,22,"00101");
        quincenasRepository.save(quincenasEntity);
        int descuento = quincenasService.descuentoVariacionGrasa(grasaSolidoTotalEntity);
        assertThat(descuento).isEqualTo(20);
        quincenasRepository.delete(quincenasEntity);
    }
    @Test
    void descuentoVariacionGrasa_otro() {
        grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","25","45");
        quincenasEntity = new QuincenasEntity(176,50,22,"00101");
        quincenasRepository.save(quincenasEntity);
        int descuento = quincenasService.descuentoVariacionGrasa(grasaSolidoTotalEntity);
        assertThat(descuento).isEqualTo(30);
        quincenasRepository.delete(quincenasEntity);
    }

    @Test
    void descuentoVariacionSolidoTotal_noHayVariacion() {
        grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","25","45");
        quincenasEntity = new QuincenasEntity(176,37,22,"00101");
        quincenasRepository.save(quincenasEntity);
        int descuento = quincenasService.descuentoVariacionSolidoTotal(grasaSolidoTotalEntity);
        assertThat(descuento).isEqualTo(0);
        quincenasRepository.delete(quincenasEntity);
    }
    @Test
    void descuentoVariacionSolidoTotal_variacionMenor6() {
        grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","25","45");
        quincenasEntity = new QuincenasEntity(176,37,47,"00101");
        quincenasRepository.save(quincenasEntity);
        int descuento = quincenasService.descuentoVariacionSolidoTotal(grasaSolidoTotalEntity);
        assertThat(descuento).isEqualTo(0);
        quincenasRepository.delete(quincenasEntity);
    }
    @Test
    void descuentoVariacionSolidoTotal_variacionMenor12() {
        grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","25","45");
        quincenasEntity = new QuincenasEntity(176,57,50,"00101");
        quincenasRepository.save(quincenasEntity);
        int descuento = quincenasService.descuentoVariacionSolidoTotal(grasaSolidoTotalEntity);
        assertThat(descuento).isEqualTo(18);
        quincenasRepository.delete(quincenasEntity);
    }
    @Test
    void descuentoVariacionSolidoTotal_variacionMenor35() {
        grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","25","45");
        quincenasEntity = new QuincenasEntity(176,37,60,"00101");
        quincenasRepository.save(quincenasEntity);
        int descuento = quincenasService.descuentoVariacionSolidoTotal(grasaSolidoTotalEntity);
        assertThat(descuento).isEqualTo(27);
        quincenasRepository.delete(quincenasEntity);
    }
    @Test
    void descuentoVariacionSolidoTotal_otro() {
        grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","25","45");
        quincenasEntity = new QuincenasEntity(176,37,80,"00101");
        quincenasRepository.save(quincenasEntity);
        int descuento = quincenasService.descuentoVariacionSolidoTotal(grasaSolidoTotalEntity);
        assertThat(descuento).isEqualTo(45);
        quincenasRepository.delete(quincenasEntity);
    }

    @Test
    void retencion() {
        int pago = 1000000;
        int retencion = quincenasService.retencion(pago);
        assertThat(retencion).isEqualTo(130000);
    }
    @Test
    void Noretencion() {
        int pago = 600000;
        int retencion = quincenasService.retencion(pago);
        assertThat(retencion).isEqualTo(0);
    }

    @Test
    void pagoAcopioLeche() {
    }

    @Test
    void descuentos() {
    }

    @Test
    void pagoTotal() {
    }

    @Test
    void pagoFinal() {
    }
}