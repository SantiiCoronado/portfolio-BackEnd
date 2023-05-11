package portfolio.backend.repository;

import java.util.List;
import portfolio.backend.model.Proyecto;

public interface IProyectoService {
    public List<Proyecto> getProyectos();
    public void saveProyecto(Proyecto proy);
    public void deleteProyecto(Long id);
    public Proyecto findProyecto(Long id);
}
