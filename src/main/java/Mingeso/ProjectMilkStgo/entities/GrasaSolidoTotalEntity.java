package Mingeso.ProjectMilkStgo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "solido_grasasTotales")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GrasaSolidoTotalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer solido_grasasTotal_id;
    private String proveedor_id;
    private String grasa;
    private String solidoTotal;

    public GrasaSolidoTotalEntity(String proveedor_id, String grasa, String solidoTotal) {
        this.proveedor_id = proveedor_id;
        this.grasa = grasa;
        this.solidoTotal = solidoTotal;
    }
}
