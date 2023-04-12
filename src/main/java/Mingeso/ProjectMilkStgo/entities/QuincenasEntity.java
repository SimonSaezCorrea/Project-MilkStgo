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
    private Integer leche;
    private Integer grasa;
    private Integer solido;
    private String proveedor_id;

    public QuincenasEntity(Integer leche, Integer grasa, Integer solido, String proveedor_id) {
        this.leche = leche;
        this.grasa = grasa;
        this.solido = solido;
        this.proveedor_id = proveedor_id;
    }
}
