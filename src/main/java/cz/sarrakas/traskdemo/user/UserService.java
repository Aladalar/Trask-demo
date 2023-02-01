package cz.sarrakas.traskdemo.user;

import cz.sarrakas.traskdemo.knowledge.Knowledge;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();

    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "user dont exist with selected id " + id
            );
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(Long id, String name, String email) {
        boolean exists = userRepository.existsById(id);
        User user = userRepository.getById(id);
        if (!exists){
            throw new IllegalStateException(
                    "user dont exist with selected id " + id
            );
        }
        if (name != null && name.length() > 0){
            user.setName(name);
        }
        if (email != null && email.length() >0){
            user.setEmail(email);
        }

    }
}
