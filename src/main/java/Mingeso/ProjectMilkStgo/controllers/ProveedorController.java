package Mingeso.ProjectMilkStgo.controllers;

import Mingeso.ProjectMilkStgo.entities.ProveedorEntity;
import Mingeso.ProjectMilkStgo.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/listado_proveedores")
    public String listar(Model model) {
        ArrayList<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
        model.addAttribute("proveedores", proveedores);
        return "listado_proveedores";
    }

    @GetMapping("/agregar_proveedor")
    public String proveedor(){
        return "agregar_proveedor";
    }
    @PostMapping("/agregar_proveedor")
    public String nuevoProveedor(@RequestParam("proveedor_id") String proveedor_id,
                                 @RequestParam("nombre") String nombre,
                                 @RequestParam("categoria") String categoria,
                                 @RequestParam("afecto_retencion") String afecto_retencion){
        ProveedorEntity proveedor = new ProveedorEntity(proveedor_id, nombre, categoria, afecto_retencion);
        proveedorService.guardarProveedor(proveedor);
        return "redirect:/agregar_proveedor";
    }
}
