package portfolio.backend.controller;

import java.sql.Date;
import java.util.List;
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
import portfolio.backend.model.Estudio;
import portfolio.backend.repository.IEstudioService;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
public class EstudioController {
    @Autowired
    private IEstudioService interEstudio;
    @GetMapping("/api/estudio")
    public List<Estudio> getEstudios(){
        return interEstudio.getEstudios();
    }
    
    @PostMapping("/api/estudio/crear")
    public String createEstudio(@RequestBody Estudio estu){
        interEstudio.saveEstudio(estu);
        return "El estudio fue creado correctamente";
    }
    
    @DeleteMapping("/api/estudio/eliminar/{id}")
    public String deleteEstudio (@PathVariable Long id){
        interEstudio.deleteEstudio(id);
        return "El estudio fue eliminado exitosamente";
    }
    
    @PutMapping("/api/estudio/editar/{id}")
    public Estudio editEstudio(@PathVariable Long id,
                               @RequestParam("institucion") String nuevaInstitucion,
                               @RequestParam("titulo") String nuevoTitulo,
                               @RequestParam("fechaInicio") Date nuevaFechaIni,
                               @RequestParam(name = "fechaFin", required = false) Date nuevaFechaFin){
        Estudio estu = interEstudio.findEstudio(id);
        
        estu.setInstitucion(nuevaInstitucion);
        estu.setTitulo(nuevoTitulo);
        estu.setFechaInicio(nuevaFechaIni);
        estu.setFechaFin(nuevaFechaFin);
        
        interEstudio.saveEstudio(estu);
        return estu;               
    }
}
