package Mingeso.ProjectMilkStgo.services;

import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArchivosService {
    private final Logger logg = LoggerFactory.getLogger(ArchivosService.class);
    @Generated
    public String guardarArchivo(MultipartFile file){
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

    @Generated
    public List<String[]> leerCSV(String direccion){
        BufferedReader bf = null;
        List<String[]> listaDatos = new ArrayList<>();
        try (FileReader fr = new FileReader(direccion)){
            bf = new BufferedReader(fr);
            String bfRead;
            int count = 1;
            while((bfRead = bf.readLine()) != null){
                if (count == 1){
                    count = 0;
                }
                else {
                    listaDatos.add(bfRead.split(";"));
                }
            }
            logg.info("Archivo leido exitosamente");
        }
        catch(Exception e){
            logg.info("No se encontro el archivo");
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
        return listaDatos;
    }
}
