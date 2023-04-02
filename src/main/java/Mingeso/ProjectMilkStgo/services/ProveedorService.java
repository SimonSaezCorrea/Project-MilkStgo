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

    public void guardarProveedor(String proveedor_id, String nombre, String categoria, String afecto_retencion){
        ProveedorEntity proveedor = new ProveedorEntity();
        proveedor.setProveedor_id(proveedor_id);
        proveedor.setNombre(nombre);
        proveedor.setCategoria(categoria);
        proveedor.setAfecto_retencion(afecto_retencion);
        proveedorRepository.save(proveedor);
    }
    public ArrayList<ProveedorEntity> obtenerProveedores(){
        return (ArrayList<ProveedorEntity>) proveedorRepository.findAll();
    }

    public String obtenerCategoria(String proveedor_id){
        return proveedorRepository.findCategory(proveedor_id);
    }

    public ProveedorEntity findByCodigo(String proveedor_id){
        return proveedorRepository.findByCodigo(proveedor_id);
    }
}