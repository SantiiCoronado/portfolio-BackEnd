package portfolio.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
}
