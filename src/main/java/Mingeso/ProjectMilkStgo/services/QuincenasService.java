package Mingeso.ProjectMilkStgo.services;

import Mingeso.ProjectMilkStgo.entities.AcopioLecheEntity;
import Mingeso.ProjectMilkStgo.entities.GrasaSolidoTotalEntity;
import Mingeso.ProjectMilkStgo.entities.ProveedorEntity;
import Mingeso.ProjectMilkStgo.entities.QuincenasEntity;
import Mingeso.ProjectMilkStgo.repositories.QuincenasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuincenasService {

    @Autowired
    private QuincenasRepository quincenasRepository;

    public void guardarQuincenas(QuincenasEntity quincenasEntity){
        quincenasRepository.save(quincenasEntity);
    }

    //----------------------------------------------------------------------------------------------------

    public int sueldoCategoria(List<AcopioLecheEntity> listAcopioLecheEntity, ProveedorEntity proveedorEntity){
        int sumKls=0;
        for(AcopioLecheEntity acopioLecheEntity:listAcopioLecheEntity){
            sumKls += Integer.parseInt(acopioLecheEntity.getKls_leche());
        }

        return switch (proveedorEntity.getCategoria()) {
            case "A" -> (700 * sumKls);
            case "B" -> (550 * sumKls);
            case "C" -> (400 * sumKls);
            case "D" -> (250 * sumKls);
            default -> 0;
        };
    }

    public int sueldoGrasa(List<AcopioLecheEntity> listAcopioLecheEntity, GrasaSolidoTotalEntity grasaSolidoTotalesEntity){
        int sumKls=0;
        for(AcopioLecheEntity acopioLecheEntity:listAcopioLecheEntity){
            sumKls += Integer.parseInt(acopioLecheEntity.getKls_leche());
        }
        if(Integer.parseInt(grasaSolidoTotalesEntity.getGrasa()) <= 20) {
            return (30 * sumKls);
        } else if (Integer.parseInt(grasaSolidoTotalesEntity.getGrasa()) <= 45) {
            return (80 * sumKls);
        } else{
            return (120 * sumKls);
        }
    }

    public int sueldoSolido(List<AcopioLecheEntity> listAcopioLecheEntity, GrasaSolidoTotalEntity grasaSolidoTotalesEntity){
        int sumKls=0;
        for(AcopioLecheEntity acopioLecheEntity:listAcopioLecheEntity){
            sumKls += Integer.parseInt(acopioLecheEntity.getKls_leche());
        }
        if(Integer.parseInt(grasaSolidoTotalesEntity.getSolidoTotal()) <= 7) {
            return (-130 * sumKls);
        } else if (Integer.parseInt(grasaSolidoTotalesEntity.getSolidoTotal()) <= 18) {
            return (-90 * sumKls);
        } else if (Integer.parseInt(grasaSolidoTotalesEntity.getSolidoTotal()) <= 35) {
            return (95 * sumKls);
        } else{
            return (150 * sumKls);
        }
    }

    public int bonificacionFrecuencia(List<AcopioLecheEntity> listAcopioLecheEntity) {
        int contador = 0;
        boolean diaDoble = true;
        boolean continuidad=true;
        boolean esManiana=false;
        for (int i = 0; i < listAcopioLecheEntity.size()-1; i++) {
            contador++;
           if(listAcopioLecheEntity.get(i).getTurno().equals("M") && !esManiana && !continuidad){

                esManiana=true;
            }
            if(listAcopioLecheEntity.get(i).getFecha().split("/")[2].equals
                    (listAcopioLecheEntity.get(i + 1).getFecha().split("/")[2])){
                contador--;
                diaDoble=true;
            }
            else if (Integer.parseInt(listAcopioLecheEntity.get(i).getFecha().split("/")[2]) ==
                    Integer.parseInt(listAcopioLecheEntity.get(i + 1).getFecha().split("/")[2])-1) {
                if(!diaDoble){
                    continuidad=false;
                }
                diaDoble=false;
            }else{
                if(contador<10){
                    contador = 0;
                }
            }
        }
        if(contador<10){
            return 0;
        } else if(continuidad){
            return 20;
        } else if(esManiana){
            return 12;
        }
        return 8;
    }
    //----------------------------------------------------------------------------------------------------

    public int descuentoVariacionLeche(List<AcopioLecheEntity> listAcopioLecheEntity){
        QuincenasEntity quincenasEntity = quincenasRepository.encontrarUltimo(listAcopioLecheEntity.get(0).getProveedor_id());
        if(quincenasEntity==null){
            return 0;
        }
        int suma = 0;
        for(AcopioLecheEntity acopioLecheEntity:listAcopioLecheEntity){
            suma += Integer.parseInt(acopioLecheEntity.getKls_leche());
        }
        if(suma > quincenasEntity.getKlsLeche()){
            return 0;
        }
        float variacion = ((float) suma /quincenasEntity.getKlsLeche() - 1) * -100;

        if(variacion < 9){
            return 0;
        }
        else if(variacion < 26){
            return 7;
        }
        else if(variacion < 41){
            return 20;
        }
        else{
            return 30;
        }
    }
    public int descuentoVariacionGrasa(GrasaSolidoTotalEntity grasaSolidoTotalEntity){
        QuincenasEntity quincenasEntity = quincenasRepository.encontrarUltimo(grasaSolidoTotalEntity.getProveedor_id());
        if(quincenasEntity==null){
            return 0;
        }
        if(Integer.parseInt(grasaSolidoTotalEntity.getGrasa()) > quincenasEntity.getGrasa()){
            return 0;
        }
        float variacion = ((float) Integer.parseInt(grasaSolidoTotalEntity.getGrasa()) /quincenasEntity.getGrasa() - 1) * -100;
        if(variacion < 15){
            return 0;
        }
        else if(variacion < 25){
            return 12;
        }
        else if(variacion < 40){
            return 20;
        }
        else{
            return 30;
        }
    }
    public int descuentoVariacionSolidoTotal(GrasaSolidoTotalEntity grasaSolidoTotalEntity){
        QuincenasEntity quincenasEntity = quincenasRepository.encontrarUltimo(grasaSolidoTotalEntity.getProveedor_id());
        if(quincenasEntity==null){
            return 0;
        }
        if(Integer.parseInt(grasaSolidoTotalEntity.getSolidoTotal()) > quincenasEntity.getSolido()){
            return 0;
        }
        float variacion = ((float) Integer.parseInt(grasaSolidoTotalEntity.getSolidoTotal()) /quincenasEntity.getSolido() - 1) * -100;
        if(variacion < 6){
            return 0;
        }
        else if(variacion < 12){
            return 18;
        }
        else if(variacion < 35){
            return 27;
        }
        else{
            return 45;
        }
    }


    //----------------------------------------------------------------------------------------------------

    public int retencion(int pago){
        int retencion = 0;
        if(pago > 950000){
            retencion = (int) (0.13*pago);
        }
        return retencion;
    }

    //----------------------------------------------------------------------------------------------------

    public int pagoAcopioLeche(GrasaSolidoTotalEntity grasaSolidoTotalesEntity, ProveedorEntity proveedorEntity, List<AcopioLecheEntity> listAcopioLecheEntitie){
        int sueldoLeche=sueldoCategoria(listAcopioLecheEntitie, proveedorEntity);
        int sueldoGrasa=sueldoGrasa(listAcopioLecheEntitie, grasaSolidoTotalesEntity);
        int sueldoSolido=sueldoSolido(listAcopioLecheEntitie, grasaSolidoTotalesEntity);
        int sueldo=sueldoLeche+sueldoGrasa+sueldoSolido;
        int bonificacion = (sueldo * bonificacionFrecuencia(listAcopioLecheEntitie))/100;
        return (sueldo + bonificacion);
    }

    public int descuentos(List<AcopioLecheEntity> listAcopioLecheEntity, GrasaSolidoTotalEntity grasaSolidoTotalesEntity, ProveedorEntity proveedorEntity){
        int sueldoLeche=sueldoCategoria(listAcopioLecheEntity, proveedorEntity);
        int sueldoGrasa=sueldoGrasa(listAcopioLecheEntity, grasaSolidoTotalesEntity);
        int sueldoSolido=sueldoSolido(listAcopioLecheEntity, grasaSolidoTotalesEntity);
        int descuentoLeche=sueldoLeche*descuentoVariacionLeche(listAcopioLecheEntity)/100;
        int descuentoGrasa=sueldoGrasa*descuentoVariacionGrasa(grasaSolidoTotalesEntity)/100;
        int descuentoSolido=sueldoSolido*descuentoVariacionSolidoTotal(grasaSolidoTotalesEntity)/100;
        return descuentoLeche+descuentoGrasa+descuentoSolido;
    }

    public int pagoTotal(GrasaSolidoTotalEntity grasaSolidoTotalesEntity, ProveedorEntity proveedorEntity, List<AcopioLecheEntity> listAcopioLecheEntitie){
        int pago = pagoAcopioLeche(grasaSolidoTotalesEntity, proveedorEntity, listAcopioLecheEntitie);
        int descuento = descuentos(listAcopioLecheEntitie, grasaSolidoTotalesEntity, proveedorEntity);
        return (pago - descuento);
    }

    //----------------------------------------------------------------------------------------------------

    public int pagoFinal(GrasaSolidoTotalEntity grasaSolidoTotalesEntity,
                         ProveedorEntity proveedorEntity,
                         List<AcopioLecheEntity> listAcopioLecheEntity){
        int pago = pagoTotal(grasaSolidoTotalesEntity, proveedorEntity, listAcopioLecheEntity);
        int retencion = retencion(pago);
        return pago - retencion;
    }
}
