package com.tom.roles.rolesauthorities.persistence;

import com.tom.roles.rolesauthorities.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    void delete(User user);

}
