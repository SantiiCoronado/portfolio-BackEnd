package portfolio.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.backend.model.Estudio;
import portfolio.backend.repository.EstudioRepository;
import portfolio.backend.repository.IEstudioService;

@Service
public class EstudioService implements IEstudioService{
    @Autowired
    private EstudioRepository estuRepository;
    
    @Override
    public List<Estudio> getEstudios(){
        List<Estudio> listaEstudios = estuRepository.findAll();
        return listaEstudios;
    }
    
    @Override
    public void saveEstudio(Estudio estu){
        estuRepository.save(estu);
    }
    
}
