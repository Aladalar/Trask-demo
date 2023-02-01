package cz.sarrakas.traskdemo.technology;

import cz.sarrakas.traskdemo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tech")
public class TechController {

    private final TechService techService;

    @Autowired
    public TechController(TechService techService) {
        this.techService = techService;
    }

    @GetMapping
    public List<Tech> getTech(){
        return techService.getTech();
    }

    @PostMapping
    public void regNewTech(@RequestBody Tech tech){
        techService.addNewTech(tech);
    }
    @DeleteMapping(path = "{techId}")
    public void deleteTech(@PathVariable("techId") Long id){
        techService.deleteTech(id);
    }

    @PutMapping(path = "{techId}")
    public void updateTech(
            @PathVariable("techId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String desc){
        techService.updateTech(id, name, desc);
    }
}
