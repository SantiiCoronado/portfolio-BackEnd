package portfolio.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import portfolio.backend.model.ExperienciaLaboral;
import portfolio.backend.repository.IExperienciaLaboralService;

@CrossOrigin (origins="http://localhost:4200")
@RestController
public class ExperienciaLaboralController {
    @Autowired
    private IExperienciaLaboralService interExp;
    
    @GetMapping("/api/experiencia")
    public List<ExperienciaLaboral> getExperiencia(){
        return interExp.getExperiencia();
    }
    
    @PostMapping("/api/experiencia/crear")
    public String createExperiencia (@RequestBody ExperienciaLaboral exp){
        interExp.saveExperiencia(exp);
        return "La experiencia fue creada correctamente";
    }
    
}
