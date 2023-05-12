package portfolio.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import portfolio.backend.model.Skill;
import portfolio.backend.repository.ISkillService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class SkillController {
    @Autowired
    private ISkillService interSkill;
    
    @GetMapping("/api/skill")
    public List<Skill> getSkills(){
        return interSkill.getSkills();
    }
    
    @GetMapping("/api/skill/{id}")
    public Skill getSkill(@PathVariable Long id){
        return interSkill.findSkill(id);
    }
    
    @PostMapping("/api/skill/crear")
    public String saveSkill(@RequestBody Skill skill){
        interSkill.saveSkill(skill);
        return "La skill se creo correctamente";
    }
    
    @DeleteMapping("/api/skill/eliminar/{id}")
    public String deleteSkill(@PathVariable Long id){
        interSkill.deleteSkill(id);
        return "Se elimino correctamente la skill";
    }
    
    @PutMapping("/api/skill/editar/{id}")
    public Skill editSkill(@PathVariable Long id,
                           @RequestParam("skill") String nuevaSkill){
        Skill skill = interSkill.findSkill(id);
        
        skill.setSkill(nuevaSkill);
        
        interSkill.saveSkill(skill);
        return skill;
    }
    
    
    
}
