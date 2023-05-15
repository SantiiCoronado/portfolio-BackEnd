package portfolio.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import portfolio.backend.model.ExperienciaLaboral;
import portfolio.backend.repository.IExperienciaLaboralService;

@CrossOrigin (origins="https://portfolio-frontend-santi-cbdce.web.app")
@RestController
public class ExperienciaLaboralController {
    @Autowired
    private IExperienciaLaboralService interExp;
    
    @GetMapping("/api/experiencia")
    public List<ExperienciaLaboral> getExperiencia(){
        return interExp.getExperiencia();
    }
    
    @GetMapping("/api/experiencia/{id}")
    public ExperienciaLaboral getExperiencia(@PathVariable Long id){
        return interExp.findExperiencia(id);
    }
    
    @PostMapping("/api/experiencia/crear")
    public String createExperiencia (@RequestBody ExperienciaLaboral exp){
        interExp.saveExperiencia(exp);
        return "La experiencia fue creada correctamente";
    }
    
    @DeleteMapping("/api/experiencia/eliminar/{id}")
    public String deleteExperiencia(@PathVariable Long id){
        interExp.deleteExperiencia(id);
        return "Se elimino correctamente la experiencia";
    }
    
    @PutMapping("/api/experiencia/editar/{id}")
    public ExperienciaLaboral editExperiencia(@PathVariable Long id,
                                              @RequestBody ExperienciaLaboral experiencia){
        
        ExperienciaLaboral exp = interExp.findExperiencia(id);
        
        exp.setEmpresa(experiencia.getEmpresa());
        exp.setDescripcion(experiencia.getDescripcion());
        exp.setFechaInicio(experiencia.getFechaInicio());
        exp.setFechaFin(experiencia.getFechaFin());
        
        interExp.saveExperiencia(exp);
        return exp;
    }
    
}
