package Mingeso.ProjectMilkStgo.controllers;

import Mingeso.ProjectMilkStgo.entities.AcopioLecheEntity;
import Mingeso.ProjectMilkStgo.services.AcopioLecheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Objects;

@Controller
@RequestMapping
public class AcopioLecheController {

    @Autowired
    private AcopioLecheService subirData;

    @GetMapping("/subir_acopioLeche")
    public String main() {
        return "subir_acopioLeche";
    }

    @PostMapping("/subir_acopioLeche")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        System.out.println("File: " + file.getOriginalFilename());
        if(!Objects.equals(file.getOriginalFilename(), "")){
            subirData.guardarAcopioLeche(file);
            redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
            subirData.leerCSV(file.getOriginalFilename());
        }
        else{
            redirectAttributes.addFlashAttribute("mensaje", "No se ha cargado algún archivo");
        }
        return "redirect:/subir_acopioLeche";
    }

    @GetMapping("/listado_AcopioLeche")
    public String listar(Model model) {
        ArrayList<AcopioLecheEntity> acopio_leche = subirData.ObtenerAcopioLeche();
        model.addAttribute("acopio_leche", acopio_leche);
        return "listado_acopioLeche";
    }

    @GetMapping("/agregar_acopioLeche")
    public String AcopioLeche(){
        return "agregar_acopioLeche";
    }
    @PostMapping("/agregar_acopioLeche")
    public String nuevoAcopioLeche(@RequestParam("fecha") String fecha,
                                 @RequestParam("turno") String turno,
                                 @RequestParam("proveedor_id") String proveedor_id,
                                 @RequestParam("kls_leche") String kls_leche){
        AcopioLecheEntity acopioLeche = new AcopioLecheEntity(fecha, turno, proveedor_id, kls_leche);
        subirData.guardarAcopioLeche(acopioLeche);
        return "redirect:/agregar_acopioLeche";
    }
}
