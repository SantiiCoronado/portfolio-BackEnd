package portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.backend.model.Estudio;

public interface EstudioRepository extends JpaRepository <Estudio, Long>{
    
}
