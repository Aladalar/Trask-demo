package cz.sarrakas.traskdemo.certification;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificationService {

    private final CertificationRepository repo;
    @Autowired
    public CertificationService(CertificationRepository repo) {
        this.repo = repo;
    }

    public List<Certification> getTech() {return repo.findAll();}

    public void addNewTech(Certification c) {repo.save(c);}

    public void deleteTech(Long id) {
        if (!repo.existsById(id)){
            throw new IllegalStateException("Certification doesnt exists");
        }
        repo.deleteById(id);
    }

    @Transactional
    public void updateTech(Long id, String name, String desc) {
        if (!repo.existsById(id)){
            throw new IllegalStateException("Certification doesnt exists");
        }
        Certification c = repo.getById(id);

        if (name != null && name.length() > 0){
            c.setName(name);
        }

        if (desc != null && desc.length() > 0){
            c.setDesc(desc);
        }
    }
}
