package portfolio.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.backend.model.Persona;
import portfolio.backend.repository.IPersonaService;
import portfolio.backend.repository.PersonaRepository;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    private PersonaRepository persoRepository;
    
    @Override
    public List<Persona> getPersonas(){
        List<Persona> listaPersonas = persoRepository.findAll();
        return listaPersonas;
    }
    @Override
    public void savePersona(Persona perso){
        persoRepository.save(perso);
    }
}
