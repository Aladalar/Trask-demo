package cz.sarrakas.traskdemo.knowledge;

import cz.sarrakas.traskdemo.certification.Certification;
import cz.sarrakas.traskdemo.technology.Tech;
import cz.sarrakas.traskdemo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/knowledge")
public class KnowledgeController {

    private final KnowledgeService service;

    @Autowired
    public KnowledgeController(KnowledgeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Knowledge> getKnowledge(){
        return service.getKnowledge();
    }

    @PostMapping
    public void regNewKnowledge(@RequestBody Knowledge known){
        service.addNewKnowledge(known);
    }
    @DeleteMapping(path = "{knownId}")
    public void deleteKnowledge(@PathVariable("knownId") Long id){
        service.deleteKnowledge(id);
    }

    @PutMapping(path = "{userId}")
    public void updateKnowledge(
            @PathVariable("userId") Long id,
            @RequestParam(required = false) Long userid,
            @RequestParam(required = false) Certification certification,
            @RequestParam(required = false) Tech tech,
            @RequestParam(required = false) int techLevel){
        service.updateKnowledge(id, userid, certification, tech, techLevel);
    }
}
