package portfolio.backend.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @DeleteMapping("/api/experiencia/eliminar/{id}")
    public String deleteExperiencia(@PathVariable Long id){
        interExp.deleteExperiencia(id);
        return "Se elimino correctamente la experiencia";
    }
    
    @PutMapping("/api/experiencia/editar/{id}")
    public ExperienciaLaboral editExperiencia(@PathVariable Long id,
                                              @RequestParam("empresa") String nuevaEmpresa,
                                              @RequestParam("descripcion") String nuevaDescripcion,
                                              @RequestParam("fechaInicio") Date nuevaFechaInicio,
                                              @RequestParam(name = "fechaFin", required = false)Date nuevaFechaFin){
        
        ExperienciaLaboral exp = interExp.findExperiencia(id);
        
        exp.setEmpresa(nuevaEmpresa);
        exp.setDescripcion(nuevaDescripcion);
        exp.setFechaInicio(nuevaFechaInicio);
        exp.setFechaFin(nuevaFechaFin);
        
        interExp.saveExperiencia(exp);
        return exp;
    }
    
}
