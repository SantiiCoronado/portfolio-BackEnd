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
public class ExperienciaLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empresa;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
}
