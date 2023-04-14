package Mingeso.ProjectMilkStgo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quincenas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuincenasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quincena_id;
    private String fecha;
    private String proveedor_id;
    private String nombreProveedor;
    private Integer klsLeche;
    private Integer numeroDiasLeche;
    private Integer promedioKlsLeche;
    private Integer variacionLeche;
    private Integer grasa;
    private Integer variacionGrasa;
    private Integer solido;
    private Integer variacionSolido;
    private Integer pagoLeche;
    private Integer pagoGrasa;
    private Integer pagoSolido;
    private Integer bonificacion;
    private Integer descuentoLeche;
    private Integer descuentoGrasa;
    private Integer descuentoSolido;
    private Integer pagoTotal;
    private Integer retencion;
    private Integer montoFinal;

    public QuincenasEntity(Integer klsLeche, Integer grasa, Integer solido, String proveedor_id) {
        this.klsLeche = klsLeche;
        this.grasa = grasa;
        this.solido = solido;
        this.proveedor_id = proveedor_id;
    }
}
