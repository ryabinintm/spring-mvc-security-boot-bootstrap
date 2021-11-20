package web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findUserByEmail(String email);

}
