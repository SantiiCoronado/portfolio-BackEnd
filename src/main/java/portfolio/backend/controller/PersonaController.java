package portfolio.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import portfolio.backend.model.Persona;
import portfolio.backend.repository.IPersonaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PersonaController {
    @Autowired
    private IPersonaService interPersona;
    @GetMapping("/api/persona")
    public List<Persona> getPersonas(){
        return interPersona.getPersonas();
    }
    
    @PostMapping("/api/persona/crear")
    public String savePersona(@RequestBody Persona perso){
        interPersona.savePersona(perso);
        return "Se creo correctamente a la persona";
    }
}