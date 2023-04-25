package Mingeso.ProjectMilkStgo.services;

import Mingeso.ProjectMilkStgo.entities.AcopioLecheEntity;
import Mingeso.ProjectMilkStgo.repositories.AcopioLecheRepository;

import lombok.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AcopioLecheService {
    @Autowired
    private AcopioLecheRepository acopioLecheRepository;
    @Autowired
    ArchivosService archivosService;

    public void guardarAcopioLeche(AcopioLecheEntity acopioLeche){
        acopioLecheRepository.save(acopioLeche);
    }
    public List<AcopioLecheEntity> obtenerAcopioLeche(){
        return acopioLecheRepository.findAll();
    }
    public List<AcopioLecheEntity> obtenerAcopioLeche(String proveedorId){
        return acopioLecheRepository.encontrarPorProveedor(proveedorId);
    }

    @Generated
    public void leerArchivoAcopio(String direccion){
        for(String[] listaDatos:archivosService.leerCSV(direccion)){
            AcopioLecheEntity acopioLeche = new AcopioLecheEntity(listaDatos[0], listaDatos[1], listaDatos[2], listaDatos[3]);
            guardarAcopioLeche(acopioLeche);
        }
    }
}