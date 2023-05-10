package portfolio.backend.repository;

import java.util.List;
import portfolio.backend.model.Skill;

public interface ISkillService {
    public List<Skill> getSkills();
    public void saveSkill(Skill skill);
    
}
