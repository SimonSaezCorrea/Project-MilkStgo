package Mingeso.ProjectMilkStgo.services;

import Mingeso.ProjectMilkStgo.entities.ProveedorEntity;
import Mingeso.ProjectMilkStgo.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {
    @Autowired
    ProveedorRepository proveedorRepository;

    public void guardarProveedor(ProveedorEntity proveedor){
        proveedorRepository.save(proveedor);
    }
    public List<ProveedorEntity> obtenerProveedores(){
        return proveedorRepository.findAll();
    }

    public String obtenerCategoria(String proveedorId){
        return proveedorRepository.encontrarCategoria(proveedorId);
    }

    public ProveedorEntity encontrarPorCodigo(String proveedorId){
        return proveedorRepository.encontrarPorCodigo(proveedorId);
    }
}