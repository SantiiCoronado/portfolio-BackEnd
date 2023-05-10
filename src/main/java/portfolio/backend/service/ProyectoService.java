package portfolio.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.backend.model.Proyecto;
import portfolio.backend.repository.IProyectoService;
import portfolio.backend.repository.ProyectoRepository;

@Service
public class ProyectoService implements IProyectoService{
    @Autowired
    private ProyectoRepository proyRepository;
    
    @Override
    public List<Proyecto> getProyectos(){
        List<Proyecto> listaProyectos = proyRepository.findAll();
        return listaProyectos;
    }
    
    @Override
    public void saveProyecto(Proyecto proy){
        proyRepository.save(proy);
    }
}
