package Mingeso.ProjectMilkStgo.controllers;

import Mingeso.ProjectMilkStgo.entities.AcopioLecheEntity;
import Mingeso.ProjectMilkStgo.entities.GrasaSolidoTotalEntity;
import Mingeso.ProjectMilkStgo.entities.ProveedorEntity;
import Mingeso.ProjectMilkStgo.entities.QuincenasEntity;
import Mingeso.ProjectMilkStgo.repositories.ProveedorRepository;
import Mingeso.ProjectMilkStgo.repositories.QuincenasRepository;
import Mingeso.ProjectMilkStgo.services.AcopioLecheService;
import Mingeso.ProjectMilkStgo.services.GrasaSolidoTotalesService;
import Mingeso.ProjectMilkStgo.services.ProveedorService;
import Mingeso.ProjectMilkStgo.services.QuincenasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping
public class QuincenasController {

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
    @Autowired
    private ProveedorRepository proveedoresRepository;

    @GetMapping("/planillas_de_pagos")
    public String main(Model model){
        List<ProveedorEntity> proveedorEntityList = proveedoresRepository.findAll();
        List<QuincenasEntity> quincenasEntityList = new ArrayList<>();
        for(ProveedorEntity proveedorEntity:proveedorEntityList){
            quincenasEntityList.add(quincenasRepository.encontrarUltimo(proveedorEntity.getProveedor_id()));
        }
        int contador = 0;
        for(QuincenasEntity quincenasEntity:quincenasEntityList){
            if(quincenasEntity==null){
                quincenasEntityList.set(contador, new QuincenasEntity());
                quincenasEntityList.get(contador).setFecha("-");
                quincenasEntityList.get(contador).setProveedor_id(proveedorEntityList.get(contador).getProveedor_id());
                quincenasEntityList.get(contador).setNombreProveedor(proveedorEntityList.get(contador).getNombre());
            }
            contador++;
        }
        model.addAttribute("quincenasEntityList", quincenasEntityList);
        return "planillas_de_pagos";
    }

    @PostMapping("/planillas_de_pagos")
    public String nuevaQuincena(@RequestParam("proveedor_id") String proveedor_id,
                                RedirectAttributes redirectAttributes){
        ProveedorEntity proveedorEntity = proveedorService.encontrarPorCodigo(proveedor_id);
        List<AcopioLecheEntity> acopioLecheEntityList = acopioLecheService.obtenerAcopioLeche(proveedor_id);
        System.out.println(acopioLecheEntityList);
        if(acopioLecheEntityList.isEmpty()){
            redirectAttributes.addFlashAttribute("mensaje", "No ha sido posible calcular");
        }else {
            GrasaSolidoTotalEntity grasaSolidoTotalEntity = grasaSolidoTotalesService.obtenerGrasaSolidoTotal(proveedor_id);
            QuincenasEntity quincenasEntity = new QuincenasEntity();
            Calendar fecha = Calendar.getInstance();
            String fechaUnida = fecha.get(Calendar.YEAR) + "/" + fecha.get(Calendar.MONTH) + "/" + fecha.get(Calendar.DATE);
            quincenasEntity.setFecha(fechaUnida);
            quincenasEntity.setProveedor_id(proveedor_id);
            quincenasEntity.setNombreProveedor(proveedorEntity.getNombre());
            int sum = 0;
            for (AcopioLecheEntity acopioLecheEntity : acopioLecheEntityList) {
                sum += Integer.parseInt(acopioLecheEntity.getKls_leche());
            }
            quincenasEntity.setKlsLeche(sum);
            quincenasEntity.setNumeroDiasLeche(acopioLecheEntityList.size());
            quincenasEntity.setPromedioKlsLeche(sum / acopioLecheEntityList.size());
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
            quincenasService.guardarQuincenas(quincenasEntity);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha calculado correctamente");
        }
        return "redirect:/planillas_de_pagos";
    }
    @GetMapping("/planilla_de_pago")
    public String verQuincena(@RequestParam("proveedor_id2") String proveedor_id,
                              @RequestParam("fecha") String fecha,
                              Model model,
                              RedirectAttributes redirectAttributes){
        QuincenasEntity quincenasEntity;
        if(fecha.equals("-")){
            quincenasEntity = new QuincenasEntity();
            quincenasEntity.setFecha("-");
            quincenasEntity.setProveedor_id("");
            quincenasEntity.setNombreProveedor("");
            quincenasEntity.setKlsLeche(0);
            quincenasEntity.setNumeroDiasLeche(0);
            quincenasEntity.setPromedioKlsLeche(0);
            quincenasEntity.setVariacionLeche(0);
            quincenasEntity.setGrasa(0);
            quincenasEntity.setVariacionGrasa(0);
            quincenasEntity.setSolido(0);
            quincenasEntity.setVariacionSolido(0);
            quincenasEntity.setPagoLeche(0);
            quincenasEntity.setPagoGrasa(0);
            quincenasEntity.setPagoSolido(0);
            quincenasEntity.setBonificacion(0);
            quincenasEntity.setDescuentoLeche(0);
            quincenasEntity.setDescuentoGrasa(0);
            quincenasEntity.setDescuentoSolido(0);
            quincenasEntity.setPagoTotal(0);
            quincenasEntity.setRetencion(0);
            quincenasEntity.setMontoFinal(0);
            redirectAttributes.addFlashAttribute("mensaje", ("No existe quincena de proveedor" + proveedor_id));
        }else {
            quincenasEntity = quincenasRepository.encontrarPorFechaYProveedor(proveedor_id, fecha);
            redirectAttributes.addFlashAttribute("mensaje", "Si");
        }
        model.addAttribute("quincenasEntity", quincenasEntity);
        return "planilla_de_pago";
    }
}
