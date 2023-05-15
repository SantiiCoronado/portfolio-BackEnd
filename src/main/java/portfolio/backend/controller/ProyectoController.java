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
import portfolio.backend.model.Proyecto;
import portfolio.backend.repository.IProyectoService;

@CrossOrigin(origins="https://portfolio-frontend-santi.firebaseapp.com/")
@RestController
public class ProyectoController {
    @Autowired
    private IProyectoService interProyecto;
    
    @GetMapping("/api/proyecto")
    public List<Proyecto> getProyectos(){
        return interProyecto.getProyectos();
    }
    
    @GetMapping("/api/proyecto/{id}")
    public Proyecto getProyecto(@PathVariable Long id){
        return interProyecto.findProyecto(id);
    }
    
    @PostMapping("/api/proyecto/crear")
    public String createProyecto(@RequestBody Proyecto proy){
        interProyecto.saveProyecto(proy);
        return "El proyecto fue creado correctamente";
    }
    
    @DeleteMapping("/api/proyecto/eliminar/{id}")
    public String deleteProyecto(@PathVariable Long id){
        interProyecto.deleteProyecto(id);
        return "Se elimino correctamente el proyecto";
    }
    
    @PutMapping("/api/proyecto/editar/{id}")
    public Proyecto editProyecto(@PathVariable Long id,
                                 @RequestBody Proyecto proyecto){
        
        Proyecto proy = interProyecto.findProyecto(id);
        
        proy.setNombre(proyecto.getNombre());
        proy.setDescripcion(proyecto.getDescripcion());
        proy.setUrlFoto(proyecto.getUrlFoto());
        
        interProyecto.saveProyecto(proy);
        return proy;
    }
}
