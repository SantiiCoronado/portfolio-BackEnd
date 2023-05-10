package portfolio.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @PostMapping("/api/skill/crear")
    public String saveSkill(@RequestBody Skill skill){
        interSkill.saveSkill(skill);
        return "La skill se creo correctamente";
    }
}
