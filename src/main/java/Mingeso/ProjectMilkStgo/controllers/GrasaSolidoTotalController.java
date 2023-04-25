package Mingeso.ProjectMilkStgo.controllers;

import Mingeso.ProjectMilkStgo.entities.GrasaSolidoTotalEntity;
import Mingeso.ProjectMilkStgo.services.ArchivosService;
import Mingeso.ProjectMilkStgo.services.GrasaSolidoTotalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping
public class GrasaSolidoTotalController {

    @Autowired
    private GrasaSolidoTotalesService subirData;
    @Autowired
    private ArchivosService archivosService;

    @GetMapping("/subir_grasaSolidoTotal")
    public String main() {
        return "subir_grasaSolidoTotal";
    }

    @PostMapping("/subir_grasaSolidoTotal")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        System.out.println("File: " + file.getOriginalFilename());
        if(!Objects.equals(file.getOriginalFilename(), "")){
            archivosService.guardarArchivo(file);
            redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
            subirData.leerArchivoGrasaSolido(file.getOriginalFilename());
        }
        else{
            redirectAttributes.addFlashAttribute("mensaje", "No se ha cargado algún archivo");
        }
        return "redirect:/subir_grasaSolidoTotal";
    }

    @GetMapping("/listado_grasaSolidoTotal")
    public String listar(Model model) {
        List<GrasaSolidoTotalEntity> grasaSolidoTotalEntities = subirData.obtenerGrasaSolidoTotal();
        model.addAttribute("grasaSolidoTotal", grasaSolidoTotalEntities);
        return "listado_grasaSolidoTotal";
    }
}
