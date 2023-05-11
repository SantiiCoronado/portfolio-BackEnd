package portfolio.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.backend.model.ExperienciaLaboral;
import portfolio.backend.repository.ExperienciaLaboralRepository;
import portfolio.backend.repository.IExperienciaLaboralService;

@Service
public class ExperienciaLaboralService implements IExperienciaLaboralService{
    @Autowired
    private ExperienciaLaboralRepository expRepository;
    
    @Override
    public List<ExperienciaLaboral> getExperiencia(){
        List<ExperienciaLaboral> listaExperiencias = expRepository.findAll();
        return listaExperiencias;
    }
    
    @Override
    public void saveExperiencia(ExperienciaLaboral exp){
        expRepository.save(exp);
    }
    
    @Override
    public void deleteExperiencia(Long id){
        expRepository.deleteById(id);
    }
    
    @Override
    public ExperienciaLaboral findExperiencia(Long id){
        ExperienciaLaboral exp = expRepository.findById(id).orElse(null);
        return exp;
    }
    
}
