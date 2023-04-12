package Mingeso.ProjectMilkStgo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

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

    public AcopioLecheEntity(String fecha, String turno, String proveedor_id, String kls_leche) {
        this.fecha = fecha;
        this.turno = turno;
        this.proveedor_id = proveedor_id;
        this.kls_leche = kls_leche;
    }
}
