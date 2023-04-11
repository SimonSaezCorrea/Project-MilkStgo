package Mingeso.ProjectMilkStgo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
