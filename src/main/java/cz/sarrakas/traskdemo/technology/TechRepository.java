package cz.sarrakas.traskdemo.technology;

import cz.sarrakas.traskdemo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechRepository extends JpaRepository<Tech, Long> {
}
