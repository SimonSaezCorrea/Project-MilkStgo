package Mingeso.ProjectMilkStgo.controllers;

import Mingeso.ProjectMilkStgo.entities.AcopioLecheEntity;
import Mingeso.ProjectMilkStgo.entities.GrasaSolidoTotalEntity;
import Mingeso.ProjectMilkStgo.entities.ProveedorEntity;
import Mingeso.ProjectMilkStgo.entities.QuincenasEntity;
import Mingeso.ProjectMilkStgo.repositories.QuincenasRepository;
import Mingeso.ProjectMilkStgo.services.AcopioLecheService;
import Mingeso.ProjectMilkStgo.services.GrasaSolidoTotalesService;
import Mingeso.ProjectMilkStgo.services.ProveedorService;
import Mingeso.ProjectMilkStgo.services.QuincenasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class PlanillaPagosController {

    @Autowired
    private AcopioLecheService acopioLecheService;
    @Autowired
    private ProveedorService proveedorService;
    @Autowired
    private GrasaSolidoTotalesService grasaSolidoTotalesService;
    @Autowired
    private QuincenasService quincenasService;
    @Autowired
    private QuincenasRepository quincenasRepository;

    @GetMapping("/planilla_de_pagos")
    public String main(){
        return "planilla_de_pagos";
    }

    @PostMapping("/planilla_de_pagos")
    public String nuevaQuincena(@RequestParam("codigo") String proveedor_id){
        ProveedorEntity proveedorEntity = proveedorService.encontrarPorCodigo(proveedor_id);
        List<AcopioLecheEntity> acopioLecheEntityList = acopioLecheService.obtenerAcopioLeche(proveedor_id);
        GrasaSolidoTotalEntity grasaSolidoTotalEntity = grasaSolidoTotalesService.obtenerGrasaSolidoTotal(proveedor_id);
        QuincenasEntity quincenasEntity = new QuincenasEntity();
        Calendar fecha = Calendar.getInstance();
        String fechaUnida = fecha.get(Calendar.YEAR) +"/"+ fecha.get(Calendar.MONTH) +"/"+ fecha.get(Calendar.DATE);
        quincenasEntity.setFecha(fechaUnida);
        quincenasEntity.setProveedor_id(proveedor_id);
        quincenasEntity.setNombreProveedor(proveedorEntity.getNombre());
        int sum = 0;
        for(AcopioLecheEntity acopioLecheEntity:acopioLecheEntityList){
            sum+=Integer.parseInt(acopioLecheEntity.getKls_leche());
        }
        quincenasEntity.setKlsLeche(sum);
        quincenasEntity.setNumeroDiasLeche(acopioLecheEntityList.size());
        quincenasEntity.setPromedioKlsLeche(sum/acopioLecheEntityList.size());
        quincenasEntity.setVariacionLeche(quincenasService.descuentoVariacionLeche(acopioLecheEntityList));
        quincenasEntity.setGrasa(Integer.parseInt(grasaSolidoTotalEntity.getGrasa()));
        quincenasEntity.setVariacionGrasa(quincenasService.descuentoVariacionGrasa(grasaSolidoTotalEntity));
        quincenasEntity.setSolido(Integer.parseInt(grasaSolidoTotalEntity.getSolidoTotal()));
        quincenasEntity.setVariacionSolido(quincenasService.descuentoVariacionSolidoTotal(grasaSolidoTotalEntity));
        quincenasEntity.setPagoLeche(quincenasService.sueldoCategoria(acopioLecheEntityList, proveedorEntity));
        quincenasEntity.setPagoGrasa(quincenasService.sueldoGrasa(acopioLecheEntityList, grasaSolidoTotalEntity));
        quincenasEntity.setPagoSolido(quincenasService.sueldoSolido(acopioLecheEntityList, grasaSolidoTotalEntity));
        quincenasEntity.setBonificacion(quincenasService.bonificacionFrecuencia(acopioLecheEntityList));
        quincenasEntity.setDescuentoLeche(quincenasService.descuentoVariacionLeche(acopioLecheEntityList));
        quincenasEntity.setDescuentoGrasa(quincenasService.descuentoVariacionGrasa(grasaSolidoTotalEntity));
        quincenasEntity.setDescuentoSolido(quincenasService.descuentoVariacionSolidoTotal(grasaSolidoTotalEntity));
        quincenasEntity.setPagoTotal(quincenasService.pagoAcopioLeche(grasaSolidoTotalEntity, proveedorEntity, acopioLecheEntityList));
        quincenasEntity.setRetencion(quincenasService.retencion(quincenasEntity.getPagoTotal()));
        quincenasEntity.setMontoFinal(quincenasService.pagoFinal(grasaSolidoTotalEntity, proveedorEntity, acopioLecheEntityList));
        quincenasService.guardarQuincena(quincenasEntity);
        return "redirect:/planilla_de_pagos";
    }

    @GetMapping("/planilla_de_pagos/{proveedor_id}")
    public String mostrarQuincenas(@RequestParam("proveedor_id") String proveedor_id,
                                                         Model model){
        List<QuincenasEntity> quincenasList= quincenasRepository.encontrarTodos(proveedor_id);
        List<String> fechasList = quincenasList.stream().map(QuincenasEntity::getFecha).distinct().collect(Collectors.toList());
        model.addAttribute("fechasList", fechasList);
        return "planilla_de_pagos";
    }
    @GetMapping("/planilla_de_pagos/{proveedor_id}/{fecha}")
    public String mostrarQuincena(@RequestParam("proveedor_id") String proveedor_id,
                                                           @RequestParam("fecha") String fecha,
                                                           Model model){
        QuincenasEntity quincenas = quincenasRepository.encontrarPorFechaYProveedor(proveedor_id, fecha);
        model.addAttribute("quincenas", quincenas);
        return "planilla_de_pagos";
    }
}
