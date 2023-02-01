package cz.sarrakas.traskdemo.technology;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechService {

    private final TechRepository techRepository ;

    @Autowired
    public TechService(TechRepository techRepository) {
        this.techRepository = techRepository;
    }

    public List<Tech> getTech() {return techRepository.findAll();}

    public void addNewTech(Tech tech) {techRepository.save(tech);}

    public void deleteTech(Long id) {
        boolean exists = techRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Tech wasnt found");
        }
        techRepository.deleteById(id);
    }

    @Transactional
    public void updateTech(Long id, String name, String desc) {
        if (!techRepository.existsById(id)){
            throw new IllegalStateException("Tech wasnt found");
        }
        Tech t = techRepository.getById(id);

        if (name != null && name.length() > 0){
            t.setName(name);
        }

        if (desc != null && desc.length() > 0){
            t.setDesc(desc);
        }
    }
}
