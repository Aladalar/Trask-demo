package cz.sarrakas.traskdemo.knowledge;

import cz.sarrakas.traskdemo.certification.Certification;
import cz.sarrakas.traskdemo.technology.Tech;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeService {

    private final KnowledgeRepository repo;

    @Autowired
    public KnowledgeService(KnowledgeRepository repo) {
        this.repo = repo;
    }

    public List<Knowledge> getKnowledge() {return repo.findAll();}

    public void addNewKnowledge(Knowledge known) {repo.save(known);}

    public void deleteKnowledge(Long id) {
        if(!repo.existsById(id)){
            throw new IllegalStateException("Knowledge wasnt found!");
        }
        repo.deleteById(id);
    }

    @Transactional
    public void updateKnowledge(Long id, Long userid, Certification certification, Tech tech, int techLevel) {
        if(!repo.existsById(id)){
            throw new IllegalStateException("Knowledge wasnt found!");
        }
        Knowledge k = repo.getById(id);
        if (userid != null && userid >0){
            if (certification !=null){
                k.setCertification(certification);
            }
            if (tech != null){
                if (techLevel > 0 && techLevel < 11){
                    k.setTech(tech);
                    k.setTechLevel(techLevel);
                }
                else{
                    k.setTech(tech);
                    k.setTechLevel(1);
                }

            }
        }
    }

}
