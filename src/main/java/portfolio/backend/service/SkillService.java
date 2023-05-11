package portfolio.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.backend.model.Skill;
import portfolio.backend.repository.ISkillService;
import portfolio.backend.repository.SkillRepository;

@Service
public class SkillService implements ISkillService{
    @Autowired
    private SkillRepository skillRepository;
    
    @Override
    public List<Skill> getSkills(){
        List<Skill> listaSkills = skillRepository.findAll();
        return listaSkills;
    }
    
    @Override
    public void saveSkill(Skill skill){
        skillRepository.save(skill);
    }
    
    @Override
    public void deleteSkill(Long id){
        skillRepository.deleteById(id);
    }
    
    @Override
    public Skill findSkill(Long id){
        Skill skill = skillRepository.findById(id).orElse(null);
        return skill;
    }
}
