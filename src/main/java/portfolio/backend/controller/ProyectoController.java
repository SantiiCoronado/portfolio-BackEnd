package portfolio.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import portfolio.backend.model.Proyecto;
import portfolio.backend.repository.IProyectoService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ProyectoController {
    @Autowired
    private IProyectoService interProyecto;
    
    @GetMapping("/api/proyecto")
    public List<Proyecto> getProyectos(){
        return interProyecto.getProyectos();
    }
    
    @PostMapping("/api/proyecto/crear")
    public String createProyecto(@RequestBody Proyecto proy){
        interProyecto.saveProyecto(proy);
        return "El proyecto fue creado correctamente";
    }
}
