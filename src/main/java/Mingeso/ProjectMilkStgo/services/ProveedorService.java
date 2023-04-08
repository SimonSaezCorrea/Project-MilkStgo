package Mingeso.ProjectMilkStgo.services;

import Mingeso.ProjectMilkStgo.entities.ProveedorEntity;
import Mingeso.ProjectMilkStgo.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProveedorService {
    @Autowired
    ProveedorRepository proveedorRepository;

    public void guardarProveedor(ProveedorEntity proveedor){
        proveedorRepository.save(proveedor);
    }
    public ArrayList<ProveedorEntity> obtenerProveedores(){
        return (ArrayList<ProveedorEntity>) proveedorRepository.findAll();
    }

    public String obtenerCategoria(String proveedor_id){
        return proveedorRepository.encontrarCategoria(proveedor_id);
    }

    public ProveedorEntity encontrarPorCodigo(String proveedor_id){
        return proveedorRepository.encontrarPorCodigo(proveedor_id);
    }
}