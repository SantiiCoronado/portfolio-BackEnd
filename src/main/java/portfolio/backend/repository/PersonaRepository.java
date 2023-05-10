package portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portfolio.backend.model.Persona;

public interface PersonaRepository extends JpaRepository <Persona, Long> {
    
}
