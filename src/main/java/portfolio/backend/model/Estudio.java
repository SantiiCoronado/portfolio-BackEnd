package portfolio.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Estudio {
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    private Long id;
    private String institucion;
    private String titulo;
    private Date fechaInicio;
    private Date fechaFin;
}
