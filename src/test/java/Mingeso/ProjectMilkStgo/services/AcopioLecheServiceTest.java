package Mingeso.ProjectMilkStgo.services;


import Mingeso.ProjectMilkStgo.entities.AcopioLecheEntity;
import Mingeso.ProjectMilkStgo.repositories.AcopioLecheRepository;
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
        assertNotNull(acopioLecheService.obtenerAcopioLeche());
    }

    @Test
    void leerCSV(){
        List<String[]> datos = new ArrayList<String[]>();
        datos.add(new String[] {"Fecha;Turno;Proveedor;KLS Leche"});
        datos.add(new String[] {"2023/03/17;M;00003;50"});
        datos.add(new String[] {"2023/03/17;T;00003;70"});
        datos.add(new String[] {"2023/03/18;M;00004;40"});
        datos.add(new String[] {"2023/03/18;T;00005;90"});

        String ubicacion_archCSV = "D:\\Simon\\progra\\IdeaProjects\\Project-MilkStgo\\CSV_TEST_ACOPIO.csv";
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
        List<AcopioLecheEntity> acopioLecheEntityList = acopioLecheRepository.findAll();

        acopioLecheService.leerCSV(ubicacion_archCSV);
        List<AcopioLecheEntity> acopioLecheEntityList1 = acopioLecheRepository.findAll();

        int valorCorrecto = 1;
        acopioLecheEntity = acopioLecheEntityList1.get(0);
        if(!(acopioLecheEntity.getFecha().equals("2023/03/17") &&
                acopioLecheEntity.getTurno().equals("M") &&
                acopioLecheEntity.getProveedor_id().equals("00003")&&
                acopioLecheEntity.getKls_leche().equals("50"))){
            valorCorrecto=0;
        }
        acopioLecheEntity = acopioLecheEntityList1.get(1);
        if(!(acopioLecheEntity.getFecha().equals("2023/03/17") &&
                acopioLecheEntity.getTurno().equals("T") &&
                acopioLecheEntity.getProveedor_id().equals("00003")&&
                acopioLecheEntity.getKls_leche().equals("70"))){
            valorCorrecto=0;
        }
        acopioLecheEntity = acopioLecheEntityList1.get(2);
        if(!(acopioLecheEntity.getFecha().equals("2023/03/18") &&
                acopioLecheEntity.getTurno().equals("M") &&
                acopioLecheEntity.getProveedor_id().equals("00004")&&
                acopioLecheEntity.getKls_leche().equals("40"))){
            valorCorrecto=0;
        }
        acopioLecheEntity = acopioLecheEntityList1.get(3);
        if(!(acopioLecheEntity.getFecha().equals("2023/03/18") &&
                acopioLecheEntity.getTurno().equals("T") &&
                acopioLecheEntity.getProveedor_id().equals("00005")&&
                acopioLecheEntity.getKls_leche().equals("90"))){
            valorCorrecto=0;
        }

        acopioLecheRepository.deleteAll();
        for(AcopioLecheEntity acopioLecheEntity1: acopioLecheEntityList){
            acopioLecheService.guardarAcopioLeche(acopioLecheEntity1);
        }
        File archivo = new File(ubicacion_archCSV);
        if (archivo.delete()) {
            System.out.println("Archivo CSV eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el archivo CSV.");
        }

        assertThat(valorCorrecto).isEqualTo(1);
    }

    @Test
    void obtenerAcopioLeche_conProveedor(){
        acopioLecheEntity = new AcopioLecheEntity("2022/10/14","T","00101","200");
        acopioLecheRepository.save(acopioLecheEntity);
        assertFalse(acopioLecheService.obtenerAcopioLeche("00101").isEmpty());
        acopioLecheRepository.delete(acopioLecheEntity);
    }
}
