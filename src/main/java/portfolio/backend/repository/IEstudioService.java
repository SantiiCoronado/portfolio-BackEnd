package portfolio.backend.repository;

import java.util.List;
import portfolio.backend.model.Estudio;

public interface IEstudioService {
    public List<Estudio> getEstudios();
    public void saveEstudio (Estudio estu);
    public void deleteEstudio(Long id);
    public Estudio findEstudio(Long id);
}
