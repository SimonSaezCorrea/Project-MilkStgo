package Mingeso.ProjectMilkStgo.services;

import Mingeso.ProjectMilkStgo.entities.GrasaSolidoTotalEntity;
import Mingeso.ProjectMilkStgo.repositories.GrasaSolidoTotalRepository;
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
    void obtenerGrasaSolidoTotal_medianteProveedor(){
        grasaSolidoTotalEntity = new GrasaSolidoTotalEntity("00101","23","41");
        grasaSolidoTotalRepository.save(grasaSolidoTotalEntity);
        assertThat(grasaSolidoTotalesService.obtenerGrasaSolidoTotal("00101")).isEqualTo(grasaSolidoTotalEntity);
        grasaSolidoTotalRepository.delete(grasaSolidoTotalEntity);
    }

    @Test
    void leerCSV(){
        List<String[]> datos = new ArrayList<String[]>();
        datos.add(new String[] {"Proveedor;% Grasa;% Solido Total"});
        datos.add(new String[] {"00003;25;10"});
        datos.add(new String[] {"00006;35;50"});
        datos.add(new String[] {"00007;15;20"});
        datos.add(new String[] {"00009;70;40"});

        String ubicacion_archCSV = "D:\\Simon\\progra\\IdeaProjects\\Project-MilkStgo\\CSV_TEST_GRASAS-SOLIDO.csv";
        try {
            FileWriter escritor = new FileWriter(ubicacion_archCSV);

            for (String[] fila : datos) {
                escritor.append(String.join(",", fila));
                escritor.append("\n");
            }
            escritor.flush();
            escritor.close();
            System.out.println("Archivo CSV creado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo CSV: " + e.getMessage());
        }
        List<GrasaSolidoTotalEntity> grasaSolidoTotalEntityList = grasaSolidoTotalRepository.findAll();

        grasaSolidoTotalesService.leerCSV(ubicacion_archCSV);
        List<GrasaSolidoTotalEntity> grasaSolidoTotalEntityList1 = grasaSolidoTotalRepository.findAll();

        int valorCorrecto = 1;
        grasaSolidoTotalEntity = grasaSolidoTotalEntityList1.get(0);
        if(!(grasaSolidoTotalEntity.getProveedor_id().equals("00003") &&
                grasaSolidoTotalEntity.getGrasa().equals("25") &&
                grasaSolidoTotalEntity.getSolidoTotal().equals("10"))){
            valorCorrecto=0;
        }
        grasaSolidoTotalEntity = grasaSolidoTotalEntityList1.get(1);
        if(!(grasaSolidoTotalEntity.getProveedor_id().equals("00006") &&
                grasaSolidoTotalEntity.getGrasa().equals("35") &&
                grasaSolidoTotalEntity.getSolidoTotal().equals("50"))){
            valorCorrecto=0;
        }
        grasaSolidoTotalEntity = grasaSolidoTotalEntityList1.get(2);
        if(!(grasaSolidoTotalEntity.getProveedor_id().equals("00007") &&
                grasaSolidoTotalEntity.getGrasa().equals("15") &&
                grasaSolidoTotalEntity.getSolidoTotal().equals("20"))){
            valorCorrecto=0;
        }
        grasaSolidoTotalEntity = grasaSolidoTotalEntityList1.get(3);
        if(!(grasaSolidoTotalEntity.getProveedor_id().equals("00009") &&
                grasaSolidoTotalEntity.getGrasa().equals("70") &&
                grasaSolidoTotalEntity.getSolidoTotal().equals("40"))){
            valorCorrecto=0;
        }

        grasaSolidoTotalRepository.deleteAll();
        for(GrasaSolidoTotalEntity grasaSolidoTotalEntity1: grasaSolidoTotalEntityList){
            grasaSolidoTotalesService.guardarGrasaSolidoTotal(grasaSolidoTotalEntity1);
        }
        File archivo = new File(ubicacion_archCSV);
        if (archivo.delete()) {
            System.out.println("Archivo CSV eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el archivo CSV.");
        }

        assertThat(valorCorrecto).isEqualTo(1);
    }
}