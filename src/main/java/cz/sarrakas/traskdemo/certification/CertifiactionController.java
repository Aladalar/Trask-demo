package cz.sarrakas.traskdemo.certification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/certification")
public class CertifiactionController {
    private final CertificationService service;

    @Autowired
    public CertifiactionController(CertificationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Certification> getCertification(){
        return service.getTech();
    }

    @PostMapping
    public void regNewCertification(@RequestBody Certification c){
        service.addNewTech(c);
    }
    @DeleteMapping(path = "{certificationId}")
    public void deleteCertification(@PathVariable("certificationId") Long id){
        service.deleteTech(id);
    }

    @PutMapping(path = "{certificationId}")
    public void updateCertification(
            @PathVariable("certificationId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String desc){
        service.updateTech(id, name, desc);
    }
}
