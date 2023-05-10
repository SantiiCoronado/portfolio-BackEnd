package portfolio.backend.repository;

import java.util.List;
import portfolio.backend.model.Persona;

public interface IPersonaService {
    public List<Persona> getPersonas();
    public void savePersona(Persona perso);
}
