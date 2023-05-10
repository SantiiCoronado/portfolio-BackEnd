package portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.backend.model.Proyecto;

public interface ProyectoRepository extends JpaRepository <Proyecto, Long>{
    
}
