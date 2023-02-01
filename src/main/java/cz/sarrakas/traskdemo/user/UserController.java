package cz.sarrakas.traskdemo.user;

import cz.sarrakas.traskdemo.certification.Certification;
import cz.sarrakas.traskdemo.knowledge.Knowledge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void regNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long id){
        userService.deleteUser(id);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        userService.updateUser(id, name, email);
    }
}
