package portfolio.backend.repository;

import java.util.List;
import portfolio.backend.model.ExperienciaLaboral;

public interface IExperienciaLaboralService {
    public List<ExperienciaLaboral> getExperiencia();
    public void saveExperiencia (ExperienciaLaboral exp);
    public void deleteExperiencia(Long id);
    public ExperienciaLaboral findExperiencia(Long id);
    
}
