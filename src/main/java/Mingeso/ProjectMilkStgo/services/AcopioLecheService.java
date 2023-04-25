package Mingeso.ProjectMilkStgo.services;

import Mingeso.ProjectMilkStgo.entities.AcopioLecheEntity;
import Mingeso.ProjectMilkStgo.repositories.AcopioLecheRepository;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


@Service
public class AcopioLecheService {
    @Autowired
    private AcopioLecheRepository acopioLecheRepository;
    private final Logger logg = LoggerFactory.getLogger(AcopioLecheRepository.class);

    public void guardarAcopioLeche(AcopioLecheEntity acopioLeche){
        acopioLecheRepository.save(acopioLeche);
    }

    @Generated
    public String guardarAcopioLeche(MultipartFile file){
        String filename = file.getOriginalFilename();
        if(filename != null){
            if(!file.isEmpty()){
                try{
                    byte [] bytes = file.getBytes();
                    Path path  = Paths.get(file.getOriginalFilename());
                    Files.write(path, bytes);
                    logg.info("Archivo guardado");
                }
                catch (IOException e){
                    logg.error("ERROR", e);
                }
            }
            return "Archivo guardado con exito!";
        }
        else{
            return "No se pudo guardar el archivo";
        }
    }
    public void leerCSV(String direccion){
        BufferedReader bf = null;
        acopioLecheRepository.deleteAll();
        try {
            bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int count = 1;
            while((bfRead = bf.readLine()) != null){
                if (count == 1){
                    count = 0;
                }
                else {
                    String[] listaDatos = bfRead.split(";");
                    AcopioLecheEntity acopioLeche = new AcopioLecheEntity(listaDatos[0], listaDatos[1], listaDatos[2], listaDatos[3]);
                    guardarAcopioLeche(acopioLeche);
                    temp = temp + "\n" + bfRead;
                }
            }
            System.out.println("Archivo leido exitosamente");
        }
        catch(Exception e){
            System.err.println("No se encontro el archivo");
        }
        finally {
            if(bf != null){
                try{
                    bf.close();
                }
                catch(IOException e){
                    logg.error("ERROR", e);
                }
            }
        }
    }
    public ArrayList<AcopioLecheEntity> obtenerAcopioLeche(){
        return (ArrayList<AcopioLecheEntity>) acopioLecheRepository.findAll();
    }
    public ArrayList<AcopioLecheEntity> obtenerAcopioLeche(String proveedor_id){
        return (ArrayList<AcopioLecheEntity>) acopioLecheRepository.encontrarPorProveedor(proveedor_id);
    }
}