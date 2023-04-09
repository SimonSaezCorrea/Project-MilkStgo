package Mingeso.ProjectMilkStgo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "acopio_leche")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AcopioLecheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer acopio_leche_id;
    private String fecha;
    private String turno;
    private String proveedor_id;
    private String kls_leche;
}
